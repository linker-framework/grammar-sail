package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

public interface InvocationParameter extends LisaToken, Serializable {
  LisaValueToken token();
  CharSequence name();
}

