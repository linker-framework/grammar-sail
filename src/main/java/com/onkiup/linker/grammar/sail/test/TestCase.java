package com.onkiup.linker.grammar.sail.test;

import com.onkiup.linker.grammar.sail.token.LisaValueToken;
import com.onkiup.linker.parser.Rule;
import com.onkiup.linker.parser.annotation.CapturePattern;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;

@IgnoreCharacters(" \t\r\n")
public class TestCase implements Rule {

  private static final String MARKER = "@test";

  @CapturePattern(until="\n")
  private String name;

  private LisaValueToken actualToken;

  private static final String DIVIDER = "--->";

  private LisaValueToken expectedToken;

  private static final String END = "@end";

  public String name() {
    return name;
  }

  public LisaValueToken actualToken() {
    return actualToken;
  }

  public LisaValueToken expectedToken() {
    return expectedToken;
  }
}

