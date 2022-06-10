import java.awt.*;
import java.awt.event.*;

public class Game extends MouseAdapter {

    public DrawingPanel shotFrame;
    public static DrawingPanel shipFrame;
    public Graphics gShot;
    public static Graphics gShip;
    private final int offset = 320;

    public static int counter;

    private int[] coordClicked = new int[2];
    private int[] coordReleased = new int[2];

    private int length;

    private int player;

    private Ship[] shipArr = new Ship[5];

    public int orientation; // 0 = horizontal 1 = vertical

    public Game() {
        shotFrame = new DrawingPanel(600, 650, -offset);
        shipFrame = new DrawingPanel(600, 650, offset);
        gShot = shotFrame.getGraphics();
        gShip = shipFrame.getGraphics();
        shipFrame.addMouseListener(this);

        gShot.drawImage(shotFrame.loadImage(".\\pics\\shots.jpg"), 0, 0, shotFrame);
        gShip.drawImage(shipFrame.loadImage(".\\pics\\fleet.jpg"), 0, 0, shipFrame);

        shipArr[0] = new Ship(5, 'a');
        shipArr[1] = new Ship(4, 'b');
        shipArr[2] = new Ship(3, 'd');
        shipArr[3] = new Ship(3, 's');
        shipArr[4] = new Ship(2, 'p');

        boards b = new boards(player, shipArr[0], coordClicked[0], coordClicked[1], coordReleased[0], coordReleased[1])
        placeShips(1);

        
        // placeShips(2);
    }
    public void printBoard(){
        for (int i = 0; i < boards.player1_Ships.length; i++) {
            for (int j = 0; j < boards.player1_Ships[i].length; j++) {
                System.out.print(boards.player1_Ships[i][j] + "      ");
            }
            System.out.println();
        }
    }

    public void placeShips(int p) {
        player = p;

        DrawingPanel ship = new DrawingPanel(600, 400, -offset);
        Graphics shipDraw = ship.getGraphics();

        //TODO REWORK THIS
    }


    public int[] findPos(int x, int y) {
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        if (x > 50 && x < 550 && y > 105 && y < 605 && ((x % 50 != 0) && ((y - 105) % 50 != 0))) {
            arr[1] = (x - 50) / 50;
            arr[0] = (y - 105) / 50;
        }
        return arr;
    }


    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        // 50 105
        // 550 605
        coordClicked = findPos(x, y);

    }

    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        coordReleased = findPos(x, y);

        

    }

}
