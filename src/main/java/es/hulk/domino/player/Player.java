package es.hulk.domino.player;

import es.hulk.domino.token.Deck;
import es.hulk.domino.token.Token;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Player {

    private int id;
    private String name;
    private Deck deck;

    private boolean isWinner;

    public Player(String name) {
        this.name = name;
    }
}
