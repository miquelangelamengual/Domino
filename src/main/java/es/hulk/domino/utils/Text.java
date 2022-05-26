package es.hulk.domino.utils;

import es.hulk.buscaminas.Buscaminas;
import es.hulk.buscaminas.objects.Board;
import lombok.experimental.UtilityClass;

@UtilityClass
public class Text {

    public String LEFT_GAME = CC.RED + "Has sortit del Buscaminas";
    public String CUSTOM_BOARD_ERROR = CC.RED + "El tablero no puede ser menor de 4x4 o mayor de 200x200";
    public String CUSTOM_BOARD_ROWS = "Introduce el numero de filas: ";
    public String CUSTOM_BOARD_COLS = "Introduce el numero de columnas: ";
    public String CUSTOM_BOARD_MINES = "Introduce el numero de minas: ";
    public String INVALID_POSITION = "ERROR: Posicion invalida";

    public void logNewLine(String str) {
        System.out.println(str);
    }

    public void log(String str) {
        System.out.print(str);
    }

    public void printMainMenu() {
        logNewLine(CC.RESET + "Trii una de les seguents opcions");
        logNewLine("");
        logNewLine("1 - Principiant (Tauler 8x8 amb 10 mines");
        logNewLine("2 - Normal (Tauler 16x16 amb 40 mines)");
        logNewLine("3 - Dificil (Tauler 16x30 amb 99 mines");
        logNewLine("4 - Personalitzat (Tauler maxim 200x200 amb x mines maxim");
        logNewLine("");
        logNewLine("5 - Surtir del programa");
        logNewLine("");
        log("Trii una de les opcions: ");
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
        printLastBoard();
        System.exit(404);
    }

    public void gameWon() {
        logNewLine("");
        logNewLine("Has ganado!");
        logNewLine("");
        printLastBoard();
        System.exit(404);
    }

    public void printBoard() {
        Board board = Buscaminas.getMenu().getBoard();
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                System.out.print(board.getBoard()[i][j].getBoard(false));
            }
            System.out.println();
        }
    }

    public void printLastBoard() {
        Board board = Buscaminas.getMenu().getBoard();
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                System.out.print(board.getBoard()[i][j].getBoard(true));
            }
            System.out.println();
        }
    }

    public void getFirstBoard() {
        Board board = Buscaminas.getMenu().getBoard();
        for (int i = 0; i < board.getRows(); i++) {
            for (int j = 0; j < board.getColumns(); j++) {
                System.out.print(CC.RESET + " [   ] " + CC.RESET);
            }
            System.out.println();
        }
    }
}
