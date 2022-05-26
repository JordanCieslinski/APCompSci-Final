import java.io.File;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class StartScreen extends MouseAdapter implements KeyListener {
    private DrawingPanel startScreen;
    private Graphics g;
    private int down;
    private Image f;

    public StartScreen() {
        startScreen = new DrawingPanel(720, 540, 0);
        startScreen.addKeyListener(this);
        startScreen.addMouseListener(this);
        g = startScreen.getGraphics();

        Image f = startScreen.loadImage(new File(".\\pics\\StartScreen.jpg"));
        g.drawImage(f, 0, 0, startScreen);

    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (x >= 0 && y >= 0) {
            startScreen.getFrame().dispose();
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
