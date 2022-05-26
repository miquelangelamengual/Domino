package es.hulk.domino.games;

import es.hulk.domino.games.impl.Colombian;
import es.hulk.domino.games.impl.International;
import es.hulk.domino.games.impl.Latin;
import es.hulk.domino.menus.MainMenu;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameLoader {

    private GameInterface gameInterface;

    public void load() {
        if (MainMenu.getGameType().equals("INTERNATIONAL")) {
            setGameInterface(new International());
            getGameInterface().setup();
        } else if (MainMenu.getGameType().equals("COLOMBIAN")) {
            setGameInterface(new Colombian());
            getGameInterface().setup();
        } else if (MainMenu.getGameType().equals("LATIN")) {
            setGameInterface(new Latin());
            getGameInterface().setup();
        }
    }

}
