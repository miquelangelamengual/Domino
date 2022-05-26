package es.hulk.domino.player;

import es.hulk.domino.token.Token;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Player {

    private int id;
    private String name;
    private List<Token> cards;
    private boolean isWinner;

    public Player(String name, List<Token> cards) {
        this.name = name;
        this.cards = cards;
    }
}
