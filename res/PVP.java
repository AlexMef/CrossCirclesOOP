package res;

import java.util.Scanner;

public class PVP {
    private char[][] map;
    private int playerNumber;
    private String playerFigure;
    private final char CROSS = 'X';
    private final char CIRCLE = 'O';

    private Scanner in = new Scanner(System.in);


    PVP(char[][] map, int playerNumber, String playerFigure) {
        this.map = map;
        this.playerNumber = playerNumber;
        this.playerFigure = playerFigure;

    }

    private void chooseCell(int i, int j) {
        --i;
        --j;
        if (map[i][j] == '*') {
            if (playerFigure.equals("cross")) {
                map[i][j] = CROSS;
            } else if (playerFigure.equals("circle")) {
                map[i][j] = CIRCLE;
            }

        } else {
            System.out.println("Клетка занята, выберите другую");
            chooseCell(in.nextInt(), in.nextInt());
        }
    }

    private void makeTurn() {
        System.out.println("Ход игрока " + playerNumber + " фигурой " + playerFigure);
        System.out.print("Координаты : ");
        chooseCell(in.nextInt(), in.nextInt());
    }

    private void drawMap() {
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }

    private void changePlayer(String figure, int playerNumber) {
        this.playerNumber = playerNumber == 1 ? 2 : 1;
        this.playerFigure = figure.equals("cross") ? "circle" : "cross";
    }

    public void play() {
        while (true) {
            drawMap();
            makeTurn();
            if (isWin()) break;
            changePlayer(this.playerFigure, this.playerNumber);
        }
        winnerIs();
        drawMap();
    }

    public boolean isWin() {
        if (map[0][0] == map[0][1] && map[0][1] == map[0][2] && (map[0][0] == CIRCLE || map[0][0] == CROSS)) {
            return true;
        } else if (map[1][0] == map[1][1] && map[1][1] == map[1][2] && (map[1][0] == CIRCLE || map[1][0] == CROSS)) {
            return true;
        } else if (map[2][0] == map[2][1] && map[2][1] == map[2][2] && (map[2][0] == CIRCLE || map[2][0] == CROSS)) {
            return true;
        } else if (map[0][0] == map[1][0] && map[1][0] == map[2][0] && (map[0][0] == CIRCLE || map[0][0] == CROSS)) {
            return true;
        } else if (map[1][0] == map[1][1] && map[1][1] == map[1][2] && (map[1][0] == CIRCLE || map[1][0] == CROSS)) {
            return true;
        } else if (map[0][2] == map[1][2] && map[1][2] == map[2][2] && (map[2][0] == CIRCLE || map[2][0] == CROSS)) {
            return true;
        } else if (map[0][0] == map[1][1] && map[1][1] == map[2][2] && (map[0][0] == CIRCLE || map[0][0] == CROSS)) {
            return true;
        } else if (map[0][2] == map[1][1] && map[1][1] == map[2][0] && (map[0][2] == CIRCLE || map[0][0] == CROSS)) {
            return true;
        }
        return false;

    }

    private void winnerIs() {
        System.out.println("Winner is " + playerNumber + " " + playerFigure);
    }
}
