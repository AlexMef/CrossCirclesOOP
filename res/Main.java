package res;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
        private static int playerNumber;
        private static String figure;
        private static boolean valid;
    public static void main(String[] args) {
        char[][] map = new char[3][3];
//        int playerNumber = 0;
//        String figure = "";
//        boolean valid = false;
        map = initMap(map);
        setPreferences();

        PVP pvp = new PVP(map, playerNumber, figure);
        pvp.play();

    }

    private static char[][] initMap(char[][] map) {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                map[i][j] = '*';
            }
        }
        return map;
    }

    private static void drawMap(char[][] map){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void setPreferences(){
        Scanner in = new Scanner(System.in);
        System.out.println("Выберите номер игрока и фигуру для игры");
        do {
            try {
                System.out.print("Номер игрока (1-2) : ");
                playerNumber = in.nextInt();
                if (playerNumber == 1 || playerNumber == 2) valid = true;

            } catch (InputMismatchException e){
                System.err.println(e);
                in = new Scanner(System.in);
                valid = false;
            }
        } while (!valid);

        System.out.println("Выберите фигуру для игры");
        do {
            try {
                System.out.println("Игрок " + playerNumber + " выбирает : ");
                figure = in.next().toLowerCase();
            } catch (InputMismatchException e){
                System.err.println(e);
                in = new Scanner(System.in);
            }

        } while (!figure.equals("cross") && !figure.equals("circle"));

    }
}
