import java.awt.*;
import java.awt.event.*;

public class player_2 extends MouseAdapter {

    public DrawingPanel shotFrame;
    public static DrawingPanel shipFrame;
    public Graphics gShot;
    public static Graphics gShip;
    private final int offset = 320;

    public static int counter;
    public static boolean updateShip = false;

    private int[] coordClicked = new int[2];
    private int[] coordReleased = new int[2];

    private int length;

    private int player;

    private Ship[] shipArr = new Ship[5];

    public static boolean alreadyAShip = false;

    public player_2() {
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

        placeShips(1);

        for (int i = 0; i < boards.player1_Ships.length; i++) {
            for (int j = 0; j < boards.player1_Ships[i].length; j++) {
                System.out.print(boards.player1_Ships[i][j] + "      ");
            }
            System.out.println();
        }
        // placeShips(2);
    }
    public void wait_until_correct(Graphics shipDraw, DrawingPanel ship){
        while (true){
            length = shipArr[counter - 1].leng - 1;
            shipDraw.drawImage(ship.loadImage(shipArr[counter - 1].placeLoc), 0, 0, ship);

            //wait until correct placement
            if(boards.isvalidLocation2){
                boards.isvalidLocation2 = false;
                break;
            }
        }
    }
    public void placeShips(int p) {
        player = p;

        DrawingPanel ship = new DrawingPanel(600, 400, -offset);
        Graphics shipDraw = ship.getGraphics();

        for (counter = 0; counter <= shipArr.length; counter++) {
            wait_until_correct(shipDraw, ship);
        }
        ship.getFrame().dispose();
    }

    public int[] findPos(int x, int y) {
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        if (x > 50 && x < 550 && y > 105 && y < 605 && ((x % 50 != 0) && ((y - 105) % 50 != 0))) {
            arr[1] = (x - 50) / 50;
            arr[0] = (y - 105) / 50;
        }
        // System.out.println(arr[0]+", "+arr[1]);
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

        // up and down
        if (coordReleased[0] == (coordClicked[0] + length) || coordReleased[0] == (coordClicked[0] - length)) {
            boards.placeShip(player, shipArr[counter - 1], coordClicked[0], coordClicked[1], coordReleased[0],
                    coordReleased[1], "horizontal");

            if (alreadyAShip == false) {
                alreadyAShip = true;
            }

        } else if (coordReleased[1] == (coordClicked[1] + length) || coordReleased[1] == (coordClicked[1] - length)) {
            boards.placeShip(player, shipArr[counter - 1], coordClicked[0], coordClicked[1], coordReleased[0],
                    coordReleased[1], "vertical");
            if (alreadyAShip == false) {
                alreadyAShip = true;
            }

        } else {
            System.out.println("bad location?");
        }

    }

}
