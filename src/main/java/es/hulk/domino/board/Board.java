package es.hulk.domino.board;

import es.hulk.domino.player.Player;
import es.hulk.domino.player.PlayerManager;
import es.hulk.domino.token.Card;

public class Board {

    public static void printBoard() {
        for (Player player : PlayerManager.getPlayerList()) {
            System.out.println(player.getName() + " deck");
            System.out.println();
            for (Card card : player.getHand()) {
                System.out.println(card.toString());
            }
            System.out.println();
            System.out.println();
        }
    }

    public static void addCard() {

    }

}
