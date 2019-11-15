package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.annotation.IgnoreCharacters;

@IgnoreCharacters(" \t\n\r")
public interface LisaValueToken extends LisaToken, Serializable {

}

