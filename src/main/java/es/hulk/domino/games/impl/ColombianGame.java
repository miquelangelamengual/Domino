package es.hulk.domino.games.impl;

import es.hulk.domino.games.GameInterface;
import es.hulk.domino.player.Player;
import es.hulk.domino.player.PlayerManager;
import es.hulk.domino.token.Card;
import es.hulk.domino.utils.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ColombianGame implements GameInterface {

    List<Card> playedCards = new ArrayList<>();

    @Override
    public void electionMenu() {
        displayGame();
        for (Player player : PlayerManager.getPlayerList()) {
            Scanner scanner = new Scanner(System.in);
            System.out.println();
            System.out.println("Player " + player.getName() + " choose a card to play");
            int cardIndex = scanner.nextInt() - 1;
            Card card = player.getHand().get(cardIndex);
            player.getHand().remove(cardIndex);
            playedCards.add(card);
            for (Card playCard : playedCards) {
                System.out.print(playCard);
            }
            if (player.getHand().isEmpty() || player.getHand().size() == 0) Text.gameWon(player);
        }
        this.electionMenu();
    }

    @Override
    public void displayGame() {
        for (Player player : PlayerManager.getPlayerList()) {
            System.out.println();
            System.out.println(player.getName() + " deck");
            System.out.println();
            for (Card card : player.getHand()) {
                System.out.println(card.toString());
            }
            System.out.println();
            System.out.println();
        }
        for (Card playCard : playedCards) {
            System.out.print(playCard);
        }
    }
}
