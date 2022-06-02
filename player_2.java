import java.io.File;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class player_2 {

    private DrawingPanel shotFrame;
    private DrawingPanel shipFrame;
    private Graphics gShot;
    private Graphics gShip;
    private final int offset = 320;

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
        Graphics shipDraw = ship.getGraphics();
        for (int i = 0; i < arr.length; i++) {
            shipDraw.drawImage(ship.loadImage(arr[i].shipLoc), 0, 0, ship);
            while(true){
                place();
                
            }
        }

    }

    public void place(){

    }
}
