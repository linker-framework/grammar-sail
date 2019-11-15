package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;
import java.util.Objects;

import com.onkiup.linker.parser.annotation.CapturePattern;
import com.onkiup.linker.parser.annotation.ContextAware;
import com.onkiup.linker.parser.annotation.OptionalToken;

public class TypeReference implements NamedEntity, Serializable {

  @OptionalToken
  private static final String OQUOTE = "'";
  private static final String MARKER = "type!";
  @OptionalToken
  private Namespace namespace;
  @CapturePattern("(\\.[a-zA-Z_$]|[a-zA-Z_$0-9])+")
  private String name;
  @ContextAware(matchField = "OQUOTE")
  private static final String CQUOTE = "'";

  private transient Class javaType;

  public TypeReference() {

  }

  public TypeReference(Namespace namespace, String name) {
    this.namespace = namespace;
    this.name = name;
  }

  @Override
  public String domain() {
    if (namespace == null) {
      return Namespace.appianNamespaceAlias;
    }
    return namespace.value();
  }

  @Override
  public String name() {
    return name;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o)
      return true;
    if (o == null || getClass() != o.getClass())
      return false;
    TypeReference that = (TypeReference)o;
    return Objects.equals(namespace(), that.namespace()) && Objects.equals(name(), that.name());
  }

  public Namespace namespace() {
    return namespace;
  }

  @Override
  public int hashCode() {
    return Objects.hash(namespace, name);
  }

  @Override
  public String toString() {
    StringBuilder result= new StringBuilder();
    if (namespace != null) {
      result.append("{").append(namespace.value()).append("}");
    }
    return result.append(name()).toString();
  }

  public boolean isInstance(Object other) {
    if (other instanceof FakeAppianObject) {

    }
  }
}
