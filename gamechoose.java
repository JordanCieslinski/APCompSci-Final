import java.io.File;
import java.awt.*;
import java.awt.event.*;

public class gamechoose extends MouseAdapter implements KeyListener {
    private DrawingPanel frame;
    private Graphics g;
    boolean mouseClick = false;

    public gamechoose() {
        frame = new DrawingPanel(720, 540, 0);
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        g = frame.getGraphics();

        Image f = frame.loadImage(new File("./pics/gamescreen.jpg"));
        g.drawImage(f, 0, 0, frame);

    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x >= 300 && y >= 220 && x <= 420 && y <= 250) { 
            frame.getFrame().dispose();
            new ConfirmScreen(2);
        } else if (x >= 290 && y >= 270 && x <= 430 && y <= 300) { 
            frame.getFrame().dispose();
            new ConfirmScreen(1);
        } else if (x >= 320 && y >= 320 && x <= 400 && y <= 350) { // QUIT
            frame.getFrame().dispose();
            new ConfirmScreen(0);
        }

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
