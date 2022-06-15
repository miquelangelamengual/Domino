package es.hulk.domino.menus;

import es.hulk.domino.player.Player;
import es.hulk.domino.player.PlayerManager;
import es.hulk.domino.utils.ErrorCatching;
import es.hulk.domino.utils.Text;
import lombok.Getter;

import java.util.Scanner;


public class MainMenu {

    @Getter private static String gameType;

    public void printRuleSelection() {
        Text.printMainMenu();
        int option = ErrorCatching.returnChoseInt(0, 3);
        switch (option) {
            case 1 -> gameType = "INTERNATIONAL_BLOCK";
            case 2 -> gameType = "INTERNATIONAL_DRAW";
            case 3 -> gameType = "TAPADITO";
            default -> printRuleSelection();
        }
    }

}
