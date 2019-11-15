package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.Rule;
import com.onkiup.linker.parser.annotation.IgnoreCharacters;
 
@IgnoreCharacters(value=" \r\t\n", inherit=false)
public interface LisaToken extends Rule, Serializable {

}

