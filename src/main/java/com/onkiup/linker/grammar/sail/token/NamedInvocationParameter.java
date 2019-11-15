package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.annotation.CaptureLimit;
import com.onkiup.linker.parser.annotation.CapturePattern;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;
import com.onkiup.linker.parser.annotation.OptionalToken;
import com.onkiup.linker.parser.annotation.SkipIfFollowedBy;

@IgnoreCharacters(" \r\t\n")
public class NamedInvocationParameter implements InvocationParameter, Serializable {

  @CapturePattern("[a-zA-Z_][a-zA-Z0-9_!]*")
  private String name;

  @OptionalToken
  private CommentToken comment;

  private static final String COLON = ":";

  private LisaValueToken parameter;

  @SkipIfFollowedBy(")")
  @CapturePattern("[,;]")
  @CaptureLimit(max=1)
  private String COMMA;

  public NamedInvocationParameter() {

  }

  public NamedInvocationParameter(String name, CommentToken comment, LisaValueToken parameter) {
    this.name = name;
    this.comment = comment;
    this.parameter = parameter;
  }

  public CharSequence name() {
    return name;
  }

  public LisaValueToken token() {
    return parameter;
  }

  public CommentToken comment() {
    return comment;
  }
  
  @Override
  public String toString() {
    return (name != null ? name + ": " : "") + parameter;
  }
}

