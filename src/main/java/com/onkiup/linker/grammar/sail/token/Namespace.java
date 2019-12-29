package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;
import java.util.Objects;

import com.onkiup.linker.parser.annotation.CapturePattern;

public class Namespace implements LisaToken, Serializable {

  private static final String OPEN = "{";
  @CapturePattern(until = "}")
  private String namespace;
  private static final String CLOSE = "}";

  private transient static final String appianNamespace = "http://www.appian.com/ae/types/2009";
  transient static final String appianNamespaceAlias = "appian";

  private transient Boolean isAppian;

  public Namespace() {

  }

  public Namespace(String value) {
    namespace = value;
  }


  public String value() {
    return namespace;
  }

  public boolean isAppian() {
    if (isAppian == null) {
      isAppian = namespace != null && (
          namespace.equals(appianNamespace) || namespace.equals(appianNamespaceAlias)
      );
    }
    return isAppian;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    Namespace nameSpace = (Namespace)o;
    return Objects.equals(namespace, nameSpace.namespace);
  }

  @Override
  public int hashCode() {
    return namespace == null ? 0 : namespace.hashCode();
  }
}
