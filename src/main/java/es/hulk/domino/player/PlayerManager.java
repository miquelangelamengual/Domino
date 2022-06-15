package es.hulk.domino.player;

import es.hulk.domino.token.Card;
import es.hulk.domino.token.Deck;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

public class PlayerManager {

    @Getter private static final List<Player> playerList = new ArrayList<>();
    @Getter private static final Deck deck = new Deck();

    public static void addPlayer(Player player) {
        playerList.add(player);
    }



}
