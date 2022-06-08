package es.hulk.domino.games.impl;

import es.hulk.domino.games.GameInterface;
import es.hulk.domino.menus.ElectionMenu;
import es.hulk.domino.player.Player;
import es.hulk.domino.player.PlayerManager;
import es.hulk.domino.token.Card;

import java.util.List;

public class InternationGame implements GameInterface {

    private final ElectionMenu electionMenu = new ElectionMenu();
    private final List<Card> playedCards = electionMenu.getPlayedCard();

    @Override
    public void electionMenu() {
        this.electionMenu.chooseOption();
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
