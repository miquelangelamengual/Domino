package es.hulk.domino.token;

import lombok.Getter;

@Getter
public class Card {

    private final int id;
    private final int firstNumber;
    private final int secondNumber;

    public Card(int firstNumber, int secondNumber) {
        this.id = getId() + 1;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    @Override
    public String toString() {
        return " [ " + firstNumber + " | " + secondNumber + " ] ";
    }
}
