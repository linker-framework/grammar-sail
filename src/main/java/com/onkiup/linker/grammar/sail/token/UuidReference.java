package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

public class UuidReference implements NamedEntity, Serializable {

  private static final String MARKER = "#";

  private StringTerminal uuid;

  public UuidReference() {

  }

  public UuidReference(StringTerminal uuid) {
    this.uuid = uuid;
  }

  @Override
  public String domain() {
    return null;
  }

  @Override
  public String name() {
    String uuid = this.uuid.toString();
    if (uuid.toString().startsWith("SYSTEM_SYSRULES_")) {
      return uuid.replace("SYSTEM_SYSRULES_", "");
    }
    return uuid;
  }

}
