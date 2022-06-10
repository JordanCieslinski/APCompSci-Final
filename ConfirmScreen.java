import java.io.File;
import java.awt.*;
import java.awt.event.*;

public class ConfirmScreen extends MouseAdapter implements KeyListener {
    private DrawingPanel frame;
    private Graphics g;
    boolean mouseClick = false;
    private Image f;
    private int gMode;

    public ConfirmScreen(int mode) {
        frame = new DrawingPanel(720, 540, 0);
        frame.addKeyListener(this);
        frame.addMouseListener(this);
        g = frame.getGraphics();
        gMode = mode;
        if (mode == 0) {
            f = frame.loadImage(new File(".\\pics\\quit.jpg"));
        } else if (mode == 1) {
            f = frame.loadImage(new File(".\\pics\\1player.jpg"));
        } else if (mode == 2) {
            f = frame.loadImage(new File(".\\pics\\2player.jpg"));
        }
        g.drawImage(f, 0, 0, frame);

    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x >= 600 && y >= 500) { // continue
            frame.getFrame().dispose();
            if (gMode == 0) {
                System.exit(y);
            } else if (gMode == 1) {
                new player_1();
            } else if (gMode == 2) {

                Game a = new Game();
                a.placeShips(1);

            }

        } else if (x <= 80 && y >= 500) { // back
            frame.getFrame().dispose();
            new gamechoose();
        }

    }

    public void keyPressed(KeyEvent e) {

    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
