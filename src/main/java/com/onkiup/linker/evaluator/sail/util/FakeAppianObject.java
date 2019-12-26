package com.onkiup.linker.evaluator.sail.util;

import java.util.HashMap;
import java.util.Objects;

import com.onkiup.linker.grammar.sail.token.TypeReference;

public class FakeAppianObject extends HashMap {
  private TypeReference type;

  public FakeAppianObject(TypeReference type) {
    this.type = type;
  }

  public TypeReference type() {
    return type;
  }

  public boolean is(TypeReference type) {
    return Objects.equals(this.type, type);
  }
}
