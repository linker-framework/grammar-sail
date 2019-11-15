package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;
import java.io.StringReader;
import java.util.Arrays;
import java.util.Objects;

import com.onkiup.linker.grammar.sail.util.Patterns;
import com.onkiup.linker.parser.Rule;
import com.onkiup.linker.parser.TokenGrammar;
import com.onkiup.linker.parser.annotation.CaptureLimit;
import com.onkiup.linker.parser.annotation.CapturePattern;
import com.onkiup.linker.parser.annotation.ContextAware;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;
import com.onkiup.linker.parser.annotation.OptionalToken;
import com.onkiup.linker.parser.token.PartialToken;
import com.onkiup.linker.parser.util.LoggerLayout;


@IgnoreCharacters(inherit=false)
public class StringTerminal implements LisaValueToken, Serializable, CharSequence {

  @OptionalToken
  @CapturePattern(Patterns.WHITESPACE )
  private String wsBefore;

  @CaptureLimit(max=1)
  @CapturePattern("['\\\"]")
  private String OPQUOTE;
  
  private StringMember[] value;

  @ContextAware(matchField = "OPQUOTE")
  private String CLQUOTE;

  @OptionalToken
  private CommentToken comment;

  private transient StringBuilder compiled;

  public StringTerminal() {

  }

  public StringTerminal(StringMember[] value) {
    this.value = value;
  }

  public StringTerminal(String value) {
    TokenGrammar<StringParser> grammar = TokenGrammar.forClass(StringParser.class);
    StringParser parser = grammar.parse(new StringReader(value));
    this.value = parser.members();
  }

  private CharSequence compiled() {
    if (value == null) {
      return null;
    }
    if (compiled == null) {
      compiled = new StringBuilder();
      Arrays.stream(value).map(StringMember::value).forEach(compiled::append);
    }
    return compiled;
  }

  /**
   * Returns the length of this character sequence.  The length is the number
   * of 16-bit <code>char</code>s in the sequence.
   *
   * @return the number of <code>char</code>s in this sequence
   */
  @Override
  public int length() {
    return compiled().length();
  }

  /**
   * Returns the <code>char</code> value at the specified index.  An index ranges from zero
   * to <tt>length() - 1</tt>.  The first <code>char</code> value of the sequence is at
   * index zero, the next at index one, and so on, as for array
   * indexing.
   * <p>If the <code>char</code> value specified by the index is a
   * <a href="{@docRoot}/java/lang/Character.html#unicode">surrogate</a>, the surrogate
   * value is returned.
   *
   * @param index the index of the <code>char</code> value to be returned
   * @return the specified <code>char</code> value
   * @throws IndexOutOfBoundsException if the <tt>index</tt> argument is negative or not less than
   *                                   <tt>length()</tt>
   */
  @Override
  public char charAt(int index) {
    return compiled().charAt(index);
  }

  /**
   * Returns a <code>CharSequence</code> that is a subsequence of this sequence.
   * The subsequence starts with the <code>char</code> value at the specified index and
   * ends with the <code>char</code> value at index <tt>end - 1</tt>.  The length
   * (in <code>char</code>s) of the
   * returned sequence is <tt>end - start</tt>, so if <tt>start == end</tt>
   * then an empty sequence is returned.
   *
   * @param start the start index, inclusive
   * @param end   the end index, exclusive
   * @return the specified subsequence
   * @throws IndexOutOfBoundsException if <tt>start</tt> or <tt>end</tt> are negative,
   *                                   if <tt>end</tt> is greater than <tt>length()</tt>,
   *                                   or if <tt>start</tt> is greater than <tt>end</tt>
   */
  @Override
  public CharSequence subSequence(int start, int end) {
    return compiled.subSequence(start, end);
  }

  @Override
  public String toString() {
     return compiled().toString();
  }

  private static class StringParser implements Rule {
    private StringMember[] members;

    protected StringMember[] members() {
      return members;
    }
  }

  public abstract static class StringMember implements LisaToken, Serializable {
    abstract String value();
    @Override
    public String toString() {
      return value();
    }
  }

  public static class Characters extends StringMember implements Serializable {
    @CapturePattern(until="[\\\\\"']")
    private String value;

    public Characters() {

    }

    public Characters(String value) {
      this.value = value;
    }

    @Override
    public String value() {
      return value;
    }
  }

  public static class EscapeDoubleQuote extends StringMember implements Serializable {
    private static final String VALUE = "\\\"";

    @Override
    public String value() {
      return "\"";
    }
  }

  public static class EscapeQuote extends StringMember implements Serializable {
    private static final String VALUE = "\\'";

    @Override
    public String value() {
      return "'";
    }
  }

  public static class Quote extends StringMember implements Serializable {
    @CaptureLimit(max = 1)
    @CapturePattern("['\"]")
    private String value;

    @Override
    String value() {
      return "'";
    }

    @Override
    public void onPopulated() {
      PartialToken<Quote> meta = metadata().get();
      if (!meta.isFailed()) {
        meta.log("Validating Quote string member does not match parent's OPQUOTE field...");
        parent().ifPresent(parent -> {
          String opquote = ((StringTerminal)parent).OPQUOTE;
          if (Objects.equals(opquote, value)) {
            meta.log("Quote string member matches parent's OPQUOTE field '%s', failing!", LoggerLayout.sanitize(opquote));
            meta.onFail();
          } else {
            meta.log("Quote string member does not match parent's OPQUOTE field '%s'", LoggerLayout.sanitize(opquote));
          }
        });
      }
    }
  }

  public static class EscapeTab extends StringMember implements Serializable {
    private static final String VALUE = "\\t";

    @Override
    public String value() {
      return "\t";
    }
  }

  public static class EscapeNewLine extends StringMember implements Serializable {
    private static final String VALUE = "\\n";

    @Override
    public String value() {
      return "\n";
    }
  }

  public static class EscapeReturn extends StringMember implements Serializable {
    private static final String VALUE = "\\r";

    @Override
    public String value() {
      return "\r";
    }
  }

  public static class EscapeSlash extends StringMember implements Serializable {
    private static final String VALUE = "\\\\";

    @Override
    public String value() {
      return "\\";
    }
  }
}

