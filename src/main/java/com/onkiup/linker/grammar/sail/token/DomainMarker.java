package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.Rule;
import com.onkiup.linker.grammar.sail.util.Patterns;
import com.onkiup.linker.parser.annotation.CapturePattern;

public class DomainMarker implements Rule, Serializable {

  @CapturePattern(Patterns.NAMED_ENTITY)
  private String domain;

  private static final String BANG = "!";

  public DomainMarker() {

  }

  public DomainMarker(String domain) {
    this.domain = domain;
  }

  public String domain() {
    return domain;
  }

  public String toString() {
    return domain + BANG;
  }
}

