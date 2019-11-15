package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

public interface NamedEntity extends LisaValueToken, Serializable {
  String domain();
  String name();
}
