package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.Rule;
import com.onkiup.linker.parser.annotation.CaptureLimit;
import com.onkiup.linker.parser.annotation.CapturePattern;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;
import com.onkiup.linker.parser.annotation.OptionalToken;
import com.onkiup.linker.parser.annotation.SkipIfFollowedBy;


@IgnoreCharacters(" \r\t\n")
public class UnnamedInvocationParameter implements InvocationParameter, Serializable {

  private Rule token;

  @OptionalToken
  private CommentToken comment;

  @SkipIfFollowedBy(")")
  @CapturePattern("[,;]")
  @CaptureLimit(max=1)
  private String COMMA;

  public UnnamedInvocationParameter() {

  }

  public UnnamedInvocationParameter(Rule token, CommentToken comment) {
    this.token = token;
    this.comment = comment;
  }

  @Override
  public Rule token() {
    return token;
  }

  @Override
  public CharSequence name() {
    return null;
  }

  public CommentToken comment() {
    return comment;
  }
}

