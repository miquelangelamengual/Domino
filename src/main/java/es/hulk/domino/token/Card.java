package es.hulk.domino.token;

import lombok.Getter;

@Getter
public class Card {
    private int firstNumber;
    private int secondNumber;

    public Card(int firstNumber, int secondNumber) {
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    public void rotate() {
        int temp = this.firstNumber;
        this.firstNumber = this.secondNumber;
        this.secondNumber = temp;
    }


    @Override
    public String toString() {
        return " [ " + firstNumber + " | " + secondNumber + " ] ";
    }
}
