package com.onkiup.linker.grammar.sail.test;

import com.onkiup.linker.parser.Rule;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;
import com.onkiup.linker.parser.annotation.OptionalToken;

@IgnoreCharacters(" \t\r\n")
public class CoreFile implements Rule {

  private static final String MARKER = "@corefile";

  @OptionalToken
  private ContextSection context;

  private TestCase[] tests;

  public ContextSection context() {
    return context;
  }

  public TestCase[] tests() {
    return tests;
  }
}

