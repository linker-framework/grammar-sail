package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.grammar.sail.util.Patterns;
import com.onkiup.linker.parser.annotation.CapturePattern;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;
import com.onkiup.linker.parser.annotation.OptionalToken;

@IgnoreCharacters(" \t\r\n")
public class DomainValueReference implements NamedEntity, Serializable {

  @OptionalToken
  private DomainMarker domain;

  @CapturePattern(Patterns.NAMED_ENTITY)
  private String name;

  public DomainValueReference() {

  }

  public DomainValueReference(DomainMarker domain, String name) {
    this.domain = domain;
    this.name = name;
  }

  public DomainMarker domainToken() {
    return domain;
  }

  @Override
  public String domain() {
    return domain == null ? null : domain.domain();
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public String toString() {
    StringBuilder result = new StringBuilder();
    result.append(domain == null ? "" : domain.toString())
      .append(name);
    return result.toString();
  }

//  public Stream<LisaValueToken> children() {
//    T value = evaluate();
//    if (value instanceof LisaValueToken) {
//      return (Stream<LisaValueToken<?>>)Stream.of(value);
//    }
//    return Stream.empty();
//  }
}

