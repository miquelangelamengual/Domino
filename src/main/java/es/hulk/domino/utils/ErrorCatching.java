package es.hulk.domino.utils;

import es.hulk.domino.board.Board;
import lombok.experimental.UtilityClass;

import java.util.Scanner;

@UtilityClass
public class ErrorCatching {

    public int returnChoseInt(int min, int max) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        if (isNumeric(str)) {
            int num = Integer.parseInt(str);
            if (num < min || num > max) {
                System.out.println("Error, introduce un numero entre " + min + " y " + max);
                return returnChoseInt(min, max);
            }
            return num;
        }
        System.out.println("Esto no es un numero...");
        return returnChoseInt(min, max);
    }

    public static boolean isNumeric(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            int num = Integer.parseInt(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static int returnParseInt(boolean isInGame) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();

        if (isNumeric(str)) {
            int number = Integer.parseInt(str);
            if (isInGame) {
                /*Board board = Buscaminas.getMenu().getBoard();
                if (number < 0 || number > (board.getColumns() - 1)) {
                    System.out.println("Error, introduce un numero entre 0 y " + board.getColumns());
                    return returnParseInt(isInGame);
                }*/
            }
            return number;
        }
        System.out.println("Esto no es un numero...");
        return returnParseInt(isInGame);
    }
}

