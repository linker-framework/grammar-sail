package com.onkiup.linker.grammar.sail.test;

import com.onkiup.linker.parser.Rule;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;
import com.onkiup.linker.parser.annotation.OptionalToken;

@IgnoreCharacters(" \t\r\n")
public class ContextSection implements Rule {

  private static final String MARKER = "@context";

  @OptionalToken
  private ContextMemberDefinition[] definitions;

  private static final String END = "@end";

  public ContextMemberDefinition[] definitions() {
    return definitions;
  }
}

