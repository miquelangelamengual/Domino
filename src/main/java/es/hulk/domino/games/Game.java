package es.hulk.domino.games;

import es.hulk.domino.player.Player;
import es.hulk.domino.token.Card;
import es.hulk.domino.utils.Text;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Game {

    private List<Card> playedCard = new ArrayList<>();

    public void putCardLeft(Player player, Card card) {
        Text.selectCard("al principio");
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
    }

    public void putCardRight(Player player, Card card) {
        Text.selectCard("al final");
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
    }

    public void displayPlayedCards() {
        Text.logNewLine("");
        for (Card card : playedCard) System.out.print(card);
        Text.logNewLine("");
    }
}
