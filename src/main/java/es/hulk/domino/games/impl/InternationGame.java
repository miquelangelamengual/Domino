package es.hulk.domino.games.impl;

import es.hulk.domino.Domino;
import es.hulk.domino.games.Game;
import es.hulk.domino.games.GameInterface;
import es.hulk.domino.player.Player;
import es.hulk.domino.player.PlayerManager;
import es.hulk.domino.token.Card;
import es.hulk.domino.utils.ErrorCatching;
import es.hulk.domino.utils.Text;

public class InternationGame implements GameInterface {

    private final Game game = Domino.getGameLoader().getGame();

    @Override
    public void chooseOption() {
        for (Player player : PlayerManager.getPlayerList()) {
            Text.chooseElection(player);
            int option = ErrorCatching.returnChoseInt(0, 3);

            switch (option) {
                case 1 -> putCard(player);
                case 2 -> takeCard(player);
                case 3 -> Text.tornLeave();
                case 4 -> Text.exit();
            }
        }
        this.chooseOption();
    }

    public void takeCard(Player player) {
        if (player.getHand().size() > 0) {
            int option = ErrorCatching.returnChoseInt(0, player.getHand().size() - 1);
            Card card = player.getHand().get(option);
            game.getPlayedCard().add(card);
            player.getHand().remove(card);
        } else {
            Text.noCard();
        }
    }

    public void putCard(Player player) {
        player.displayHand();
        Text.printSideSelection(player);
        int option = ErrorCatching.returnChoseInt(0, 2);
        int cardIndex = ErrorCatching.returnParseInt() - 1;
        Card card = player.getHand().get(cardIndex);

        switch (option) {
            case 1 -> Domino.getGameLoader().getGame().putCardLeft(player, card);
            case 2 -> Domino.getGameLoader().getGame().putCardRight(player, card);
        }

        this.displayGame();

        if (player.getHand().isEmpty()) Text.gameWon(player);
    }

    @Override
    public void displayGame() {
        for (Card card : game.getPlayedCard()) System.out.print(card);
    }
}
