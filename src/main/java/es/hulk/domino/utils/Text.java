package es.hulk.domino.utils;

import es.hulk.domino.player.Player;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Text {

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
        logNewLine("1 - Internacional");
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

    public void gameWon(Player player) {
        logNewLine("");
        logNewLine(player.getName() + " Ha ganado el domino!");
        logNewLine("");
        System.exit(404);
    }

    public void printSideSelection(Player player) {
        logNewLine("");
        logNewLine("Jugador " + player.getName() + " elija una opción:");
        logNewLine("");
        logNewLine("1 - Al Principio");
        logNewLine("2 - Al Final");
        logNewLine("");
        log("Seleccione una de las opciones disponibles: ");
    }

    public void chooseElection(Player player) {
        logNewLine("");
        logNewLine(player.getName() + " elija una opción:");
        logNewLine("");
        logNewLine("1 - Poner Carta");
        logNewLine("2 - Coger Carta");
        logNewLine("3 - Pasar turno");
        logNewLine("");
        logNewLine("4 - Surtir del programa");
        logNewLine("");
        log("Seleccione una de las opciones: ");
    }

    public void exit() {
        logNewLine("");
        logNewLine("Saliendo del programa...");
        logNewLine("");
        System.exit(404);
    }

    public void tornLeave() {
        logNewLine("");
        logNewLine("Has pasado turno");
        logNewLine("");
    }

    public void noCard() {
        logNewLine("");
        logNewLine("No hay mas cartas para coger!");
        logNewLine("");
    }

    public void selectPlayers() {
        logNewLine("");
        logNewLine("Selecciona el numero de jugadores: ");
        logNewLine("");
        logNewLine("Tiene que haber un minimo de 2 jugadores y un maximo de 4");
        logNewLine("");
        log("Numero de jugadores: ");
    }

    public void selectPlayerName() {
        logNewLine("");
        logNewLine("Escribe el nombre del jugador: ");
        logNewLine("");
        log("Nombre del jugador: ");
    }

    public void invalidCard() {
        logNewLine("");
        logNewLine("La carta que has elegido no es valida!");
        logNewLine("");
    }
}
