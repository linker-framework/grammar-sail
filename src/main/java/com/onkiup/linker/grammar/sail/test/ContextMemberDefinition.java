package com.onkiup.linker.grammar.sail.test;

import com.onkiup.linker.grammar.sail.token.DomainValueReference;
import com.onkiup.linker.grammar.sail.token.LisaValueToken;
import com.onkiup.linker.parser.Rule;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;
import com.onkiup.linker.parser.annotation.SkipIfFollowedBy;

@IgnoreCharacters(" \t\r\n")
public class ContextMemberDefinition implements Rule {

  private DomainValueReference name;
  private static final String COLON = ":";
  private LisaValueToken value;

  @SkipIfFollowedBy("@end")
  private static final String COMMA = ",";

  public DomainValueReference name() {
    return name;
  }

  public LisaValueToken value() {
    return value;
  }
}

