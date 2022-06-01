package es.hulk.domino.board;

import es.hulk.domino.token.Token;

public class Board {

    public static void printBoard() {
        Token token = new Token("0");
        System.out.print(token.toString());
    }

}
