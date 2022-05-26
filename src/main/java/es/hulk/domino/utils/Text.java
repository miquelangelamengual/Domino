package es.hulk.domino.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class Text {

    public String MAX_PLAYERS = "Seleccione los jugadores que quieren que juege, tiene que ser de 2 a 4 jugadores";

    public void logNewLine(String str) {
        System.out.println(str);
    }

    public void log(String str) {
        System.out.print(str);
    }

    public void printMainMenu() {
        logNewLine("");
        logNewLine(CC.RESET + "Trii amb quines regles vol jugar");
        logNewLine("");
        logNewLine("1 - Espanyol");
        logNewLine("2 - Mexicà");
        logNewLine("3 - Colombià");
        logNewLine("");
        logNewLine("5 - Surtir del programa");
        logNewLine("");
        log("Trii amb quines regles vol jugar: ");
    }

    public void printElectionMenu() {
        logNewLine("Elige una opción:");
        logNewLine("");
        logNewLine("1. Destapar casilla");
        logNewLine("2. Cambiar bandera");
        logNewLine("");
        logNewLine("3. Surtir del programa");
        logNewLine("");
        log("Opción: ");
    }

    public void gameLost() {
        logNewLine("");
        logNewLine("Has perdido!");
        logNewLine("");
        logNewLine("Asi es como ha quedado el tablero: ");
        logNewLine("");
        System.exit(404);
    }

    public void gameWon() {
        logNewLine("");
        logNewLine("Has ganado!");
        logNewLine("");
        System.exit(404);
    }
}
