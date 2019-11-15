package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.grammar.sail.util.Patterns;
import com.onkiup.linker.parser.annotation.AdjustPriority;
import com.onkiup.linker.parser.annotation.CapturePattern;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;
import com.onkiup.linker.parser.annotation.OptionalToken;
import com.onkiup.linker.parser.annotation.SkipIfFollowedBy;

@AdjustPriority(1000) // makes sure that LisaListToken has priority over this token
@IgnoreCharacters(" \r\n\t")
public class LisaDictionaryToken implements LisaValueToken, Serializable {

  private final static String OBRACKET = "{";

  private Member[] members;

  private final static String CBRACKET = "}";

  public LisaDictionaryToken() {

  }

  public LisaDictionaryToken(Member[] members) {
    this.members = members;
  }

  public Member[] members() {
    return members;
  }

  @IgnoreCharacters(" \r\n\t")
  public static class Member implements LisaToken, Serializable {

    @OptionalToken
    private CommentToken leadingComment;

    @OptionalToken
    private StringTerminal stringName;

    @CapturePattern(Patterns.NAMED_ENTITY)
    @OptionalToken(whenFieldIsNull = "stringName")
    private String name;

    private static final String COLON = ":";

    private LisaValueToken value;

    @OptionalToken
    private CommentToken trailingComment;

    @SkipIfFollowedBy("}")
    private static final String COMMA = ",";

    public Member() {

    }

    public Member(String name, LisaValueToken value) {
      this.name = name;
      this.value = value;
    }

    public CharSequence name() {
      return name == null ? stringName : name;
    }

    public LisaValueToken token() {
      return value;
    }
  }
}

