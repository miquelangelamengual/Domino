package es.hulk.domino.games.impl;

import es.hulk.domino.Domino;
import es.hulk.domino.games.Game;
import es.hulk.domino.games.GameInterface;
import es.hulk.domino.player.Player;
import es.hulk.domino.player.PlayerManager;
import es.hulk.domino.token.Card;
import es.hulk.domino.utils.ErrorCatching;
import es.hulk.domino.utils.Text;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class InternationBlockGame extends Game implements GameInterface {

    private final Game game = Domino.getGameLoader().getGame();

    @Override
    public void start() {
        this.gameStart();
        this.chooseOption();
    }

    @Override
    public void chooseOption() {
        for (Player player : PlayerManager.getPlayerList()) {
            this.assignCardsToPlayer(player);
            Text.chooseElection(player);
            int option = ErrorCatching.returnChoseInt(0, 3);

            switch (option) {
                case 1 -> this.game.putCard(player);
                case 2 -> this.takeCard(player);
                case 3 -> Text.tornLeave();
                case 4 -> Text.exit();
            }
        }
        this.chooseOption();
    }

    private void assignCardsToPlayer(Player player) {
        List<Card> hand = new ArrayList<>();
        List<Card> shuffledDeck = game.getDeckList();

        for (int i = 0; i < 7; i++) {
            hand.add(game.getDeckList().get(0));
            shuffledDeck.remove(0);
            Collections.shuffle(shuffledDeck);
        }

        player.setHand(hand);
    }

    public void takeCard(Player player) {
        if (player.getHand().size() > 0) {
            int option = ErrorCatching.returnChoseInt(0, player.getHand().size() - 1);
            player.getHand().add(this.getDeckList().get(0));
            this.getDeckList().remove(0);
        } else {
            Text.noCard();
        }
    }
}
