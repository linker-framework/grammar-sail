package com.onkiup.linker.grammar.sail.operator;

import java.io.Serializable;

import com.onkiup.linker.grammar.sail.token.LisaValueToken;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;

@IgnoreCharacters(" \n\t\r")
public class BinaryOperatorStatement implements LisaValueToken, Serializable {

  private LisaValueToken leftOperand;

  private BinaryOperator operator;

  private LisaValueToken rightOperand;

  public BinaryOperatorStatement() {

  }

  public BinaryOperatorStatement(LisaValueToken leftOperand, BinaryOperator operator, LisaValueToken rightOperand) {
    this.leftOperand = leftOperand;
    this.operator = operator;
    this.rightOperand = rightOperand;
  }

  public LisaValueToken leftOperand() {
    return leftOperand;
  }

  public BinaryOperator operator() {
    return operator;
  }

  public LisaValueToken rightOperand() {
    return rightOperand;
  }

}

