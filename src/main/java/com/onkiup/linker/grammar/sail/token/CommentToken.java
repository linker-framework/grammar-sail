package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.annotation.CapturePattern;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;
import com.onkiup.linker.parser.annotation.MetaToken;

@IgnoreCharacters(" \r\t\n")
@MetaToken
public class CommentToken implements LisaValueToken, InvocationParameter, Serializable {
  private final static String MARKER = "/*";
  @CapturePattern(until="\\*/")
  private String comment;
  private final static String END = "*/";

  public CommentToken() {

  }

  public CommentToken(String comment) {
    this.comment = comment;
  }

  @Override
  public LisaValueToken token() {
    return this;
  }

  @Override
  public CharSequence name() {
    return null;
  }
}
