package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.annotation.IgnoreCharacters;

@IgnoreCharacters(" \r\t\n")
public class EqualsPrefix implements LisaValueToken, Serializable {
  private static final String MARKER = "=";
  private LisaValueToken value;

  public EqualsPrefix() {

  }

  public EqualsPrefix(LisaValueToken value) {
    this.value = value;
  }

  public LisaValueToken token() {
    return value;
  }
}
