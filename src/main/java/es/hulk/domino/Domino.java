package es.hulk.domino;

import es.hulk.domino.games.GameLoader;
import es.hulk.domino.menus.MainMenu;
import lombok.Getter;

public class Domino {

    @Getter private static GameLoader gameLoader;
    @Getter private static MainMenu mainMenu;

    public static void main(String[] args) {
        mainMenu = new MainMenu();
        gameLoader = new GameLoader();

        mainMenu.printMenu();
        gameLoader.load();
    }

}
