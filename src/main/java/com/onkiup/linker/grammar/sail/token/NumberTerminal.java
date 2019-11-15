package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.annotation.IgnoreCharacters;

@IgnoreCharacters(inherit=false)
public class NumberTerminal implements LisaValueToken, Serializable {

  private Number number;

  public NumberTerminal() {

  }

  public NumberTerminal(Number number) {
    this.number = number;
  }

  @Override
  public String toString() {
    return number.toString();
  }

  public Number number() {
    return number;
  }
}

