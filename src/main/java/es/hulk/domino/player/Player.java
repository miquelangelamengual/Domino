package es.hulk.domino.player;

import es.hulk.domino.token.Card;
import es.hulk.domino.utils.Text;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Player {

    private int id;
    private String name;
    private List<Card> hand;

    private boolean isWinner;

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
}
