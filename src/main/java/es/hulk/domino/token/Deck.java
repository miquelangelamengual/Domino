package es.hulk.domino.token;

import es.hulk.domino.player.Player;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Getter
public class Deck {

    private final List<Card> cardList = new ArrayList<>();

    public Deck() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                this.cardList.add(new Card(i, j));
            }
        }
    }
}
