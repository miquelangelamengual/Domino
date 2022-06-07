package es.hulk.domino.menus;

import es.hulk.domino.Domino;
import es.hulk.domino.games.GameLoader;
import es.hulk.domino.player.Player;
import es.hulk.domino.player.PlayerManager;
import es.hulk.domino.token.Card;
import es.hulk.domino.utils.ErrorCatching;
import es.hulk.domino.utils.Text;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ElectionMenu {

    private final List<Card> playedCard = new ArrayList<>();
    private final GameLoader gameLoader = Domino.getGameLoader();
    public void selectSide() {
        gameLoader.getGameInterface().displayGame();
        for (Player player : PlayerManager.getPlayerList()) {
            Text.printSideSelection(player);
            int option = ErrorCatching.returnChoseInt(0, 2);
            int cardIndex = ErrorCatching.returnParseInt() - 1;
            Card card = player.getHand().get(cardIndex);
            player.getHand().remove(cardIndex);

            if (option == 1) {
                playedCard.add(0, card);
            } else if (option == 2) {
                playedCard.add(card);
            } else {
                System.out.println("OPCION NO VALIDA PESTUZO");
            }

            for (Card playCard : playedCard) {
                System.out.print(playCard);
            }

            if (player.getHand().isEmpty()) Text.gameWon(player);
        }
        gameLoader.getGameInterface().displayGame();
        this.selectSide();
    }

}
