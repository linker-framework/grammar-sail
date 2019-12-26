package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.Rule;

public interface InvocationParameter extends LisaToken, Serializable {
  Rule token();
  CharSequence name();
}

