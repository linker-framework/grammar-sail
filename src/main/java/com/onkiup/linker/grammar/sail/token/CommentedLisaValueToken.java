package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

public class CommentedLisaValueToken implements LisaValueToken, Serializable {

  private LisaValueToken token;

  private CommentToken comment;

  public CommentedLisaValueToken() {

  }

  public CommentedLisaValueToken(LisaValueToken token, CommentToken comment) {
    this.token = token;
    this.comment = comment;
  }

  public LisaValueToken token() {
    return token;
  }

  public CommentToken comment() {
    return comment;
  }
}
