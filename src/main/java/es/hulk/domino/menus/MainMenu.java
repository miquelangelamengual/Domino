package es.hulk.domino.menus;

import es.hulk.domino.board.Board;
import es.hulk.domino.player.Player;
import es.hulk.domino.player.PlayerManager;
import es.hulk.domino.utils.ErrorCatching;
import es.hulk.domino.utils.Text;
import lombok.Getter;

import java.util.Scanner;

public class MainMenu {

    @Getter private static String gameType;
    @Getter private static Board board;

    private int numPlayers;

    public void selectPlayers() {
        Text.log(Text.MAX_PLAYERS);
        numPlayers = ErrorCatching.returnChoseInt(1,5);
        createPlayers();
    }

    public void createPlayers() {
        for (int i = 0; i < numPlayers; i++) {
            Scanner scanner = new Scanner(System.in);

            String name = scanner.nextLine();

            PlayerManager.addPlayer(new Player(name));
        }
        printRuleSelection();
    }


    public void printRuleSelection() {
        Text.printMainMenu();
        int option = ErrorCatching.returnChoseInt(0, 3);
        switch (option) {
            case 1 -> gameType = "SPANISH";
            case 2 -> gameType = "COLOMBIAN";
            case 3 -> gameType = "MEXICAN";
            default -> printRuleSelection();
        }
    }

}
