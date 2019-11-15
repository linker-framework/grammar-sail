package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.ParserLocation;
import com.onkiup.linker.parser.annotation.AdjustPriority;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;
import com.onkiup.linker.parser.annotation.OptionalToken;


/**
 *  General invocation trap token -- because of its priority it will be tested by parser after any built-in InvocableLisaToken
 */
@AdjustPriority(-100)
@IgnoreCharacters(" \r\t\n")
public class RuleInvocation implements LisaValueToken, Serializable {

  private NamedEntity rule;

  private static final String OPEN_BRACKET = "(";

  @OptionalToken(whenFollowedBy = ")")
  private InvocationParameter[] parameters;

  private static final String CLOSE_BRACKET = ")";

  public RuleInvocation() {

  }

  public RuleInvocation(NamedEntity rule, InvocationParameter[] parameters) {
    this.rule = rule;
    this.parameters = parameters;
  }

  @Override
  public String toString() {
    ParserLocation location = location();
    return rule.name() + (location == null ? "" : "@" + location().line() + ":" + location().column());
  }

  public NamedEntity rule() {
    return rule;
  }

  public InvocationParameter[] parameters() {
    return parameters;
  }

}
