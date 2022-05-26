package es.hulk.domino.games;

import es.hulk.domino.games.impl.Colombian;
import es.hulk.domino.games.impl.International;
import es.hulk.domino.games.impl.Latin;
import es.hulk.domino.menus.MainMenu;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameLoader {

    private String selectedGame = MainMenu.getGameType();

    private GameInterface gameInterface;
    private static String gameType;

    public void load() {
        if (MainMenu.getGameType().equals("INTERNATIONAL")) {
            setGameInterface(new International());
            gameType = "International";
        } else if (MainMenu.getGameType().equals("COLOMBIAN")) {
            setGameInterface(new Colombian());
            gameType = "Colombian";
        } else if (MainMenu.getGameType().equals("LATIN")) {
            setGameInterface(new Latin());
            gameType = "LATIN";
        }
    }

}
