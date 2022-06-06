import java.io.File;
import java.util.*;

import java.awt.*;
import java.awt.event.*;

public class player_2 extends MouseAdapter {

    private DrawingPanel shotFrame;
    private DrawingPanel shipFrame;
    private Graphics gShot;
    private Graphics gShip;
    private final int offset = 320;

    private int counter = 0;

    private int[] coordClicked = new int[2];
    private int[] coordReleased = new int[2];

    public player_2() {
        shotFrame = new DrawingPanel(600, 650, -offset);
        shipFrame = new DrawingPanel(600, 650, offset);
        gShot = shotFrame.getGraphics();
        gShip = shipFrame.getGraphics();

        gShot.drawImage(shotFrame.loadImage(".\\pics\\shots.jpg"), 0, 0, shotFrame);
        gShip.drawImage(shipFrame.loadImage(".\\pics\\fleet.jpg"), 0, 0, shipFrame);

        placeShips();

    }

    public void placeShips() {
        // Ship airCraft = new Ship(5, 'a');
        // Ship battleship = new Ship(4, 'b');
        // Ship destroyer = new Ship(3, 'd');
        // Ship submarine = new Ship(3, 's');
        // Ship patrol = new Ship(2, 'p');
        Ship[] arr = { new Ship(5, 'a'), new Ship(4, 'b'), new Ship(3, 'd'), new Ship(3, 's'), new Ship(2, 'p') };

        DrawingPanel ship = new DrawingPanel(600, 400, -offset);
        ship.addMouseListener(this);
        Graphics shipDraw = ship.getGraphics();
        for (counter = 0; counter < arr.length; counter++) {
            shipDraw.drawImage(ship.loadImage(arr[counter].shipLoc), 0, 0, ship);
        }

    }
    public void findPos(int x, int y){
        return {}
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        // 50 105
        // 550 605
        if (x > 50 && x < 550 && y > 105 && y < 605 && ((x % 50 != 0) && ((y - 105) % 50 != 0))){
            coordClicked[0] = x;
            coordClicked[1] = y;
        }
            

    }

    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        

    }


}
