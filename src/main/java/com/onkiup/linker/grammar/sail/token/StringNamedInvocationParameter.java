package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.annotation.CaptureLimit;
import com.onkiup.linker.parser.annotation.CapturePattern;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;
import com.onkiup.linker.parser.annotation.OptionalToken;
import com.onkiup.linker.parser.annotation.SkipIfFollowedBy;

@IgnoreCharacters(" \r\t\n")
public class StringNamedInvocationParameter implements InvocationParameter, Serializable {

  private StringTerminal name;

  private static final String COLON = ":";

  private LisaValueToken token;

  @OptionalToken
  private CommentToken comment;

  @SkipIfFollowedBy(")")
  @CapturePattern("[,;]")
  @CaptureLimit(max=1)
  private String COMMA;

  public StringNamedInvocationParameter() {

  }

  public StringNamedInvocationParameter(StringTerminal name, LisaValueToken token, CommentToken comment) {
    this.name = name;
    this.token = token;
    this.comment = comment;
  }

  @Override
  public CharSequence name() {
    return name;
  }

  @Override
  public LisaValueToken token() {
    return token;
  }
  
  @Override
  public String toString() {
    return (name != null ? name + ": " : "") + token;
  }
}

