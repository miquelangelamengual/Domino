package es.hulk.domino.games;

import es.hulk.domino.games.impl.InternationGame;
import es.hulk.domino.games.impl.ColombianGame;
import es.hulk.domino.games.impl.MexicanGame;
import es.hulk.domino.menus.MainMenu;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameLoader {

    private GameInterface gameInterface;

    public void load() {
        if (MainMenu.getGameType().equals("INTERNATIONAL")) {
            setGameInterface(new InternationGame());
            getGameInterface().electionMenu();
        } else if (MainMenu.getGameType().equals("COLOMBIAN")) {
            setGameInterface(new ColombianGame());
            getGameInterface().electionMenu();
        } else if (MainMenu.getGameType().equals("MEXICAN")) {
            setGameInterface(new MexicanGame());
            getGameInterface().electionMenu();
        }
    }

}
