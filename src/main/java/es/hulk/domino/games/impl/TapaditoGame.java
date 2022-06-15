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

public class TapaditoGame extends Game implements GameInterface {

    private final Game game = Domino.getGameLoader().getGame();

    @Override
    public void start() {
        this.gameStart();
        this.chooseOption();
    }

    @Override
    public void chooseOption() {
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

    public void putCard(Player player) {
        player.displayHiddenHand();
        Text.printSideSelection(player);
        int option = ErrorCatching.returnChoseInt(0, 2);
        int cardIndex = ErrorCatching.returnParseInt() - 1;
        Card card = player.getHand().get(cardIndex);

        switch (option) {
            case 1 -> this.game.putCardLeft(player, card);
            case 2 -> this.game.putCardRight(player, card);
        }

        this.game.displayPlayedCards();

        if (player.getHand().isEmpty()) Text.gameWon(player);
    }
}
