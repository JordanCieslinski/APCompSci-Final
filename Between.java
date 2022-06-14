import java.awt.*;
import java.awt.event.*;
public class Between extends MouseAdapter{
    
    private DrawingPanel frame;

    public Between(String a){
        frame = new DrawingPanel(600, 400, 0);
        Graphics g = frame.getGraphics();
        String b = "";
        frame.addMouseListener(this);
        switch(a){
            case "hit":
                b = ".\\pics\\hitShot.jpg";
                break;
            case "miss":
                b = ".\\pics\\missedShot.jpg";
                break;
            case "again":
                b = ".\\pics\\tryagain.jpg";
                break;
            case "a":
                b = ".\\pics\\shipsSunk\\aircraftSunk.jpg";
                break;
            case "b":
                b = ".\\pics\\shipsSunk\\battleshipSunk.jpg";
                break;
            case "d":
                b = ".\\pics\\shipsSunk\\destroyerSunk.jpg";
                break;
            case "s":
                b = ".\\pics\\shipsSunk\\subsunk.jpg";
                break;
            case "p":
                b = ".\\pics\\shipsSunk\\patrolSunk.jpg";
                break;
        }
        g.drawImage(frame.loadImage(b), 0, 0, frame);
    }
    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();
        if( x > 0 && y > 0)
            frame.getFrame().dispose();
    }
}
