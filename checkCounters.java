import java.awt.*;
import java.awt.event.*;
import java.io.File;

public class checkCounters extends MouseAdapter {

    private DrawingPanel frame;

    public checkCounters(int player) {
        if (player == 1) {
            
            if (p2Game.aCount == 5) {
                frame = new DrawingPanel(new File(".\\pics\\shipsSunk\\aircraftSunk.jpg"));
                frame.addMouseListener(this);
                p2Game.aCount++;
                p2Game.shipSunkCount++;
            }
            else if (p2Game.bCount == 4) {
                frame = new DrawingPanel(new File(".\\pics\\shipsSunk\\battleshipSunk.jpg"));
                frame.addMouseListener(this);
                p2Game.bCount++;
                p2Game.shipSunkCount++;
            }
            else if (p2Game.dCount == 3) {
                frame = new DrawingPanel(new File(".\\pics\\shipsSunk\\destroyerSunk.jpg"));
                frame.addMouseListener(this);
                p2Game.dCount++;
                p2Game.shipSunkCount++;
            }
            else if (p2Game.sCount == 3) {
                frame = new DrawingPanel(new File(".\\pics\\shipsSunk\\subSunk.jpg"));
                frame.addMouseListener(this);
                p2Game.sCount++;
                p2Game.shipSunkCount++;
            }
            else if (p2Game.pCount == 2) {
                frame = new DrawingPanel(new File(".\\pics\\shipsSunk\\patrolSunk.jpg"));
                frame.addMouseListener(this);
                p2Game.pCount++;
                p2Game.shipSunkCount++;
            }
            if(p2Game.shipSunkCount == 5){
                frame.getFrame().dispose();
                new Winner(1);
            }
        }
        else if (player == 2) {
            
            if (p1Game.aCount == 5) {
                frame = new DrawingPanel(new File(".\\pics\\shipsSunk\\aircraftSunk.jpg"));
                frame.addMouseListener(this);
                p1Game.aCount++;
                p1Game.shipSunkCount++;
            }
            else if (p1Game.bCount == 4) {
                frame = new DrawingPanel(new File(".\\pics\\shipsSunk\\battleshipSunk.jpg"));
                frame.addMouseListener(this);
                p1Game.bCount++;
                p1Game.shipSunkCount++;
            }
            else if (p1Game.dCount == 3) {
                frame = new DrawingPanel(new File(".\\pics\\shipsSunk\\destroyerSunk.jpg"));
                frame.addMouseListener(this);
                p1Game.dCount++;
                p1Game.shipSunkCount++;
            }
            else if (p1Game.sCount == 3) {
                frame = new DrawingPanel(new File(".\\pics\\shipsSunk\\subSunk.jpg"));
                frame.addMouseListener(this);
                p1Game.sCount++;
                p1Game.shipSunkCount++;
            }
            else if (p1Game.pCount == 2) {
                frame = new DrawingPanel(new File(".\\pics\\shipsSunk\\patrolSunk.jpg"));
                frame.addMouseListener(this);
                p1Game.pCount++;
                p1Game.shipSunkCount++;
            }
            if(p1Game.shipSunkCount == 5){
                frame.getFrame().dispose();
                new Winner(2);
            }
        }

    }

    public void mousePressed(MouseEvent e) {
        frame.getFrame().dispose();

    }
}
