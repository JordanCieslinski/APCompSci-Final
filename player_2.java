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

    public player_2(){
        shotFrame = new DrawingPanel(600,650, -offset);
        shipFrame = new DrawingPanel(600,650, offset);
        gShot = shotFrame.getGraphics();
        gShip = shipFrame.getGraphics();

        gShot.drawImage(shotFrame.loadImage(".\\pics\\shots.jpg"), 0, 0, shotFrame);
        gShip.drawImage(shipFrame.loadImage(".\\pics\\fleet.jpg"), 0, 0, shipFrame);

    }
}
