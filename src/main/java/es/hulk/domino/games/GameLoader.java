package es.hulk.domino.games;

import es.hulk.domino.games.impl.TapaditoGame;
import es.hulk.domino.games.impl.InternationBlockGame;
import es.hulk.domino.games.impl.InternationalDrawGame;
import es.hulk.domino.menus.MainMenu;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class GameLoader {

    private GameInterface gameInterface;
    private Game game;

    public void load() {
        this.game = new Game();
        switch (MainMenu.getGameType()) {
            case "INTERNATIONAL_BLOCK" -> {
                setGameInterface(new InternationBlockGame());
                getGameInterface().start();
            }
            case "TAPADITO" -> {
                setGameInterface(new TapaditoGame());
                getGameInterface().start();
            }
            case "INTERNATIONAL_DRAW" -> {
                setGameInterface(new InternationalDrawGame());
                getGameInterface().start();
            }
        }
    }
}