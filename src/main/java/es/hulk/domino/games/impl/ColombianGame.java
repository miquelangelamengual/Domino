package es.hulk.domino.games.impl;

import es.hulk.domino.board.Board;
import es.hulk.domino.games.GameInterface;
import es.hulk.domino.player.Player;
import es.hulk.domino.player.PlayerManager;
import es.hulk.domino.token.Card;

import java.util.Scanner;

public class ColombianGame implements GameInterface {

    @Override
    public void electionMenu() {
        Board.printBoard();
        for (Player player : PlayerManager.getPlayerList()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println("Player " + player.getName() + " choose a card to play");
            int cardIndex = scanner.nextInt();
            Card card = player.getHand().get(cardIndex);
            player.getHand().remove(cardIndex);
            System.out.println(card.toString());

            if (player.getHand().isEmpty()) break;
        }
        this.electionMenu();
    }
}
