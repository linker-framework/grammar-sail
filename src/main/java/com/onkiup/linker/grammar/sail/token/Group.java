package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

public class Group implements LisaValueToken, Serializable {

  private static final String OPEN = "(";

  private LisaValueToken token;

  private static final String CLOSE = ")";

  public Group() {

  }

  public Group(LisaValueToken token) {
    this.token = token;
  }

  public LisaValueToken token() {
    return token;
  }
}
