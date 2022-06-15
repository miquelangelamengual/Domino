package es.hulk.domino.player;

import es.hulk.domino.token.Card;
import es.hulk.domino.utils.Text;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Player {

    private String name;
    private List<Card> hand;

    public Player(String name) {
        this.name = name;
    }

    public void displayHand() {
        Text.logNewLine("Tus Cartas");
        Text.logNewLine("");
        int count = 1;
        for (Card card : hand) {
            System.out.println(count + ": " +card);
            count++;
        }
    }

    public void displayHiddenHand() {
        Text.logNewLine("Tus Cartas");
        Text.logNewLine("");
        int count = 1;
        for (Card card : hand) {
            System.out.println(count + ": " + " [ ? / ? ] ");
            count++;
        }
    }

    public void addCard(Card card) {
        hand.add(card);
    }
}
