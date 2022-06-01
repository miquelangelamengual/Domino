package es.hulk.domino.player;

import es.hulk.domino.token.Deck;
import es.hulk.domino.token.Token;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    private static final List<Player> playerList = new ArrayList<>();

    public static void addPlayer(Player player) {
        player.setId(player.getId() + 1);
        assignPlayerDeck(player);
        playerList.add(player);
    }

    public static Player getWinner() {
        for (Player player : playerList) if (player.isWinner()) return player;
        return null;
    }

    public static void assignPlayerDeck(Player player) {
        Deck deck = new Deck();
        for (Token token : deck.getTokenList()) {
            System.out.println(token.getName());
        }
        player.setDeck(deck);
    }


}
