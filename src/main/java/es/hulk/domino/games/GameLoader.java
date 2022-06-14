package es.hulk.domino.games;

import es.hulk.domino.games.impl.TapaditoGame;
import es.hulk.domino.games.impl.InternationGame;
import es.hulk.domino.games.impl.MexicanGame;
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
            case "INTERNATIONAL" -> {
                setGameInterface(new InternationGame());
                getGameInterface().chooseOption();
            }
            case "TAPADITO" -> {
                setGameInterface(new TapaditoGame());
                getGameInterface().chooseOption();
            }
            case "MEXICAN" -> {
                setGameInterface(new MexicanGame());
                getGameInterface().chooseOption();
            }
        }
    }
}