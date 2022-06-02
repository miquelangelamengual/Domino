package es.hulk.domino.token;

import es.hulk.domino.player.Player;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class Deck {

    private final List<Card> cardList = new ArrayList<>();
    public Deck() {
        this.generate();
        this.shuffle();
    }

    public void generate() {
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 7; j++) {
                    this.cardList.add(new Card(i, j));
                }
            }
        }


    // method to shuffle the deck
    public void shuffle() {
        for (int i = 0; i < this.cardList.size(); i++) {
            int randomIndex = (int) (Math.random() * this.cardList.size());
            Card temp = this.cardList.get(i);
            this.cardList.set(i, this.cardList.get(randomIndex));
            this.cardList.set(randomIndex, temp);
        }
    }

    public void assignDeck(Player player) {
        for (int i = 0; i < 7; i++) {
            player.getDeck().getCardList().add(this.cardList.get(0));
            this.cardList.remove(0);
        }
    }

}
