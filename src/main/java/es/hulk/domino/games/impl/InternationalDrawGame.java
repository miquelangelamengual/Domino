package es.hulk.domino.games.impl;

import es.hulk.domino.Domino;
import es.hulk.domino.games.Game;
import es.hulk.domino.games.GameInterface;
import es.hulk.domino.player.Player;
import es.hulk.domino.player.PlayerManager;
import es.hulk.domino.token.Card;
import es.hulk.domino.utils.ErrorCatching;
import es.hulk.domino.utils.Text;

import java.util.List;

public class InternationalDrawGame extends Game implements GameInterface {
    private final List<Card> deckList = PlayerManager.getDeck().getCardList();

    @Override
    public void start() {
        this.gameStart();
        this.chooseOption();
    }

    @Override
    public void chooseOption() {
        PlayerManager.assignAllCardsToPlayers(deckList);
        for (Player player : PlayerManager.getPlayerList()) {
            Text.chooseElection(player);
            int option = ErrorCatching.returnChoseInt(0, 3);

            switch (option) {
                case 1 -> this.putCard(player);
                case 2 -> Text.tornLeave();
                case 3 -> Text.exit();
            }
        }
        this.chooseOption();
    }
}
