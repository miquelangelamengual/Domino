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
            playedCard.add(card);
            player.getHand().remove(card);
        } else {
            Text.noCard();
        }
    }

    public void putCard(Player player) {
        gameLoader.getGameInterface().displayGame();
        Text.printSideSelection(player);
        int option = ErrorCatching.returnChoseInt(0, 2);
        int cardIndex = ErrorCatching.returnParseInt() - 1;
        Card card = player.getHand().get(cardIndex);

        switch (option) {
            case 1:
                if (playedCard.size() == 0) {
                    playedCard.add(card);
                    player.getHand().remove(card);
                } else if (card.getSecondNumber() == playedCard.get(0).getFirstNumber()) {
                    playedCard.add(0, card);
                    player.getHand().remove(card);
                } else {
                    card.rotate();
                    if (card.getSecondNumber() == playedCard.get(0).getFirstNumber()) {
                        playedCard.add(0, card);
                        player.getHand().remove(card);
                    } else {
                        Text.invalidCard();
                    }
                }
                break;
            case 2:
                if (playedCard.size() == 0) {
                    playedCard.add(card);
                    player.getHand().remove(card);
                } else if (card.getSecondNumber() == playedCard.get(playedCard.size() - 1).getFirstNumber()) {
                    playedCard.add(card);
                    player.getHand().remove(card);
                } else {
                    card.rotate();
                    if (card.getSecondNumber() == playedCard.get(playedCard.size() - 1).getFirstNumber()) {
                        playedCard.add(card);
                        player.getHand().remove(card);
                    } else {
                        Text.invalidCard();
                    }
                }
                break;
        }

        for (Card playCard : playedCard) {
            System.out.print(playCard);
        }

        if (player.getHand().isEmpty()) Text.gameWon(player);
        gameLoader.getGameInterface().displayGame();
    }

}
