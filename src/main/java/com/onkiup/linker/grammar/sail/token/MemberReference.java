package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

public class MemberReference implements LisaValueToken, Serializable {

  private LisaValueToken source;
  private static final String OBRACKET = "[";
  private LisaValueToken key;
  private static final String CBRACKET = "]";

  public MemberReference() {

  }

  public MemberReference(LisaValueToken source, LisaValueToken key) {
    this.source = source;
    this.key = key;
  }

  public LisaValueToken sourceToken() {
    return source;
  }

  public LisaValueToken keyToken() {
    return key;
  }
}
