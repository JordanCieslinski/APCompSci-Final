import java.io.File;
import java.awt.event.*;
public class Winner extends MouseAdapter {
    
    public Winner(int player){
        if(player == 1){
            p1Game.fleet.getFrame().dispose();
            p1Game.shots.getFrame().dispose();
            DrawingPanel frame = new DrawingPanel(new File(".\\pics\\usfleet.jpg"));
            frame.addMouseListener(this);
        }
        else if(player == 2){
            p2Game.fleet.getFrame().dispose();
            p2Game.shots.getFrame().dispose();
            DrawingPanel frame = new DrawingPanel(new File(".\\pics\\sovietfleet.jpg"));
            frame.addMouseListener(this);
        }
    }

    public void mousePressed(MouseEvent e){
        int x = e.getX();
        int y = e.getY();

        if( x > 750 && y >600){
            System.exit(1);
        }
    }

    
}
