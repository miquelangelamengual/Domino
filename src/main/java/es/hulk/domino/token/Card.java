package es.hulk.domino.token;

import lombok.Getter;

@Getter
public class Card {

    private final int id;
    private int firstNumber;
    private int secondNumber;

    public Card(int firstNumber, int secondNumber) {
        this.id = getId() + 1;
        this.firstNumber = firstNumber;
        this.secondNumber = secondNumber;
    }

    // Method to rotate firstNumber and secondNumber
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
