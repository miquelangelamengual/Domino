package es.hulk.domino.token;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Deck {

    private final List<Card> cardList = new ArrayList<>();

    public Deck() {
        int counter = 0;
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                if (j >= counter) {
                    this.cardList.add(new Card(i, j));
                }
            }
            counter++;
        }
    }
}
