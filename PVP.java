import java.util.Scanner;

public class PVP {
    private char[][] map;
    private int playerNumber;
    private String figure;
    private int currentPlayerNumber;
    private final char CROSS = 'X';
    private final char CIRCLE = 'O';

    private Scanner in = new Scanner(System.in);


    public PVP(char[][] map, int playerNumber, String figure){
        this.map = map;
        this.playerNumber = playerNumber;
        this.figure = figure;

    }

    public void chooseCell(int i, int j){
        if (map[i][j] != '*') {
            System.out.println("Клетка занята, выберите другую");
            chooseCell(in.nextInt(), in.nextInt());
        } else {
            if (figure.equals("cross")){
                map[--i][--j] = CROSS;
                figure = "circle";
            } else if (figure.equals("circle")){
                map[--i][--j] = CIRCLE;
                figure = "cross";
            }
            playerNumber = playerNumber == 1 ? 2 : 1;

        }
    }

    public void makeTurn(){
        System.out.println("Ход игрока " + playerNumber + " фигурой " + figure);
        System.out.print("Координаты : " );
        chooseCell(in.nextInt(), in.nextInt());
        drawMap();
    }

    public void drawMap(){
        for (int i = 0; i < map.length; i++) {
            for (int j = 0; j < map[i].length; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
    }



}
