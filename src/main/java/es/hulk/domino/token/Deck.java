package es.hulk.domino.token;

import es.hulk.domino.player.Player;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class Deck {

    private Player player;
    private List<Token> tokenList;
    
}
