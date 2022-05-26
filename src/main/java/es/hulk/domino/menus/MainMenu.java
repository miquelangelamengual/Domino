package es.hulk.domino.menus;

import lombok.Getter;

import java.util.Scanner;

public class MainMenu {

    @Getter private static String gameType;

    public void printMenu() {
        Scanner scanner = new Scanner(System.in);
        switch (scanner.nextLine()) {
            case "INTERNATIONAL":
                gameType = "INTERNATIONAL";
                break;
            case "COLOMBIAN":
                gameType = "COLOMBIAN";
                break;
            case "LATIN":
                gameType = "LATIN";
                break;
        }
    }

}
