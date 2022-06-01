package es.hulk.domino.token;

import lombok.Getter;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@Getter
public class Deck {

    private List<Token> tokenList = new ArrayList<>();

    public Deck() {
        this.addToken();
    }

    public void addToken() {
        for (int i = 0; i < 7; i++) {
            Random random = new Random();
            tokenList.add(new Token(String.valueOf(random.nextInt(6))));
        }
    }

}
