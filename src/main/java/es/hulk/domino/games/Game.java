package es.hulk.domino.games;

import es.hulk.domino.player.Player;
import es.hulk.domino.player.PlayerManager;
import es.hulk.domino.token.Card;
import es.hulk.domino.utils.ErrorCatching;
import es.hulk.domino.utils.Text;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Getter
public class Game {

    private final List<Card> playedCard = new ArrayList<>();
    private final List<Card> deckList = PlayerManager.getDeck().getCardList();

    public void gameStart() {
        this.selectPlayers();
    }

    public void selectPlayers() {
        Text.selectPlayers();
        createPlayers(ErrorCatching.returnChoseInt(1, 4));
    }

    public void createPlayers(int numPlayers) {
        for (int i = 0; i < numPlayers; i++) {
            Scanner scanner = new Scanner(System.in);

            Text.selectPlayerName();
            String name = scanner.nextLine();

            PlayerManager.addPlayer(new Player(name));
        }
    }

    public void putCardLeft(Player player, Card card) {
        Text.selectCard("al principio");
        if (playedCard.size() == 0) {
            playedCard.add(card);
            player.getHand().remove(card);
        } else {
            if (card.getSecondNumber() == playedCard.get(0).getFirstNumber()) {
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
        }
    }

    public void putCardRight(Player player, Card card) {
        Text.selectCard("al final");
            if (playedCard.size() == 0) {
                playedCard.add(card);
                player.getHand().remove(card);
            } else {
                if (card.getSecondNumber() == playedCard.get(playedCard.size() - 1).getFirstNumber()) {
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
            }
    }

    public void putCard(Player player) {
        player.displayHand();
        Text.printSideSelection(player);
        int option = ErrorCatching.returnChoseInt(0, 2);
        int cardIndex = ErrorCatching.returnParseInt() - 1;
        Card card = player.getHand().get(cardIndex);

        switch (option) {
            case 1 -> this.putCardLeft(player, card);
            case 2 -> this.putCardRight(player, card);
        }

        this.displayPlayedCards();

        if (player.getHand().isEmpty()) Text.gameWon(player);
    }

    public void displayPlayedCards() {
        Text.logNewLine("");
        for (Card card : playedCard) System.out.print(card);
        Text.logNewLine("");
    }
}
