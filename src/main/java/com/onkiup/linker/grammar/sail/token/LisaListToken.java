package com.onkiup.linker.grammar.sail.token;

import java.io.Serializable;

import com.onkiup.linker.parser.annotation.IgnoreCharacters;
import com.onkiup.linker.parser.annotation.OptionalToken;
import com.onkiup.linker.parser.annotation.SkipIfFollowedBy;

@IgnoreCharacters(value=" \t\r\n", inherit=false)
public class LisaListToken implements LisaValueToken, Serializable {

  private static final String OPEN_BRACKET = "{";

  private Member[] items;

  private static final String CLOSE_BRACKET = "}";

  public LisaListToken() {

  }

  public LisaListToken(Member[] items) {
    this.items = items;
  }

  public Member[] items() {
    return items;
  }

  public static class Member implements LisaToken, Serializable {
    @OptionalToken
    private CommentToken leadingComment;
    private LisaValueToken value;
    @OptionalToken
    private CommentToken trailingComment;
    @SkipIfFollowedBy("}")
    private static final String COMMA = ",";

    public Member() {

    }

    public Member(LisaValueToken value) {
      this.value = value;
    }

    public LisaValueToken token() {
      return value;
    }

    public CommentToken leadingComment() {
      return leadingComment;
    }

    public CommentToken trailingComment() {
      return trailingComment;
    }
  }
}

