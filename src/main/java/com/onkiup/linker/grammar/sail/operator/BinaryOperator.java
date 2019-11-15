package com.onkiup.linker.grammar.sail.operator;

import java.io.Serializable;

import com.onkiup.linker.parser.Rule;
import com.onkiup.linker.parser.annotation.MatchTerminal;

public enum BinaryOperator implements Rule, Serializable {
  @MatchTerminal("&")   AMPERSAND,
  @MatchTerminal(".")   DOT,
  @MatchTerminal("==")  DOUBLE_EQUALS,
  @MatchTerminal("=")   EQUALS,
  @MatchTerminal("<=")  LESS_EQUALS,
  @MatchTerminal("<>")  LESS_MORE,
  @MatchTerminal("<")   LESS,
  @MatchTerminal("-")   MINUS,
  @MatchTerminal(">=")  MORE_EQUALS,
  @MatchTerminal(">")   MORE,
  @MatchTerminal("!=")  NOT_EQUALS,
  @MatchTerminal("+")   PLUS,
  @MatchTerminal("/")   SLASH,
  @MatchTerminal("*")   STAR,
  @MatchTerminal("<<")  STREAM
}

