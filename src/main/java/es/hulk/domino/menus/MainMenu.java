package es.hulk.domino.menus;

import es.hulk.domino.player.Player;
import es.hulk.domino.player.PlayerManager;
import es.hulk.domino.utils.ErrorCatching;
import es.hulk.domino.utils.Text;
import lombok.Getter;

import java.util.Scanner;


public class MainMenu {

    @Getter private static String gameType;
    private int numPlayers;

    public void selectPlayers() {
        Text.selectPlayers();
        numPlayers = ErrorCatching.returnChoseInt(1, 4);
        createPlayers();
    }

    public void createPlayers() {
        for (int i = 0; i < numPlayers; i++) {
            Scanner scanner = new Scanner(System.in);

            Text.selectPlayerName();
            String name = scanner.nextLine();

            PlayerManager.addPlayer(new Player(name));
        }
        printRuleSelection();
    }


    public void printRuleSelection() {
        Text.printMainMenu();
        int option = ErrorCatching.returnChoseInt(0, 3);
        switch (option) {
            case 1 -> gameType = "INTERNATIONAL";
            case 2 -> gameType = "COLOMBIAN";
            case 3 -> gameType = "MEXICAN";
            default -> printRuleSelection();
        }
    }

}
