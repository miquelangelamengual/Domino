package es.hulk.domino.games.impl;

import es.hulk.domino.board.Board;
import es.hulk.domino.games.GameInterface;

public class ColombianGame implements GameInterface {

    @Override
    public void electionMenu() {
        Board.printBoard();
    }
}
