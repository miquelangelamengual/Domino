package es.hulk.domino.player;

import es.hulk.domino.token.Card;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter @Setter
public class Player {

    private int id;
    private String name;
    private List<Card> hand;

    private boolean isWinner;
    private boolean isCPU;

    public Player(String name, boolean isCPU) {
        this.name = name;
        this.isCPU = isCPU;
    }
}
