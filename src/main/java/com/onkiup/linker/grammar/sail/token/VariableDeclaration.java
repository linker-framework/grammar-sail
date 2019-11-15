package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.annotation.IgnoreCharacters;

@IgnoreCharacters(value=" \t\r\n", inherit=false)
public class VariableDeclaration implements LisaToken, Serializable {

  private NamedEntity name;

  private static String COLON = ":";

  private LisaValueToken value;

  private static String COMMA = ",";

  public VariableDeclaration() {

  }

  public VariableDeclaration(NamedEntity name, LisaValueToken value) {
    this.name = name;
    this.value = value;
  }

  public NamedEntity name() {
    return name;
  }

  public LisaValueToken token() {
    return value;
  }

}
