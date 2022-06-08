package es.hulk.domino.player;

import es.hulk.domino.token.Deck;
import es.hulk.domino.token.Card;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class PlayerManager {

    @Getter private static final List<Player> playerList = new ArrayList<>();
    @Getter private static final Deck deck = new Deck();

    public static void addPlayer(Player player) {
        player.setId(player.getId() + 1);
        assignHandToPlayer(player);
        playerList.add(player);
    }

    public static Player getPlayerById(int id) {
        for (Player player : playerList) {
            if (player.getId() == id) {
                return player;
            }
        }
        return null;
    }

    public static void assignHandToPlayer(Player player) {
        List<Card> hand = new ArrayList<>();
        List<Card> shuffledDeck = deck.getCardList();

        for (int i = 0; i < 7; i++) {
            hand.add(deck.getCardList().get(0));
            shuffledDeck.remove(0);
            Collections.shuffle(shuffledDeck);
        }

        player.setHand(hand);
    }
}
