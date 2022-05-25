import java.io.File;
import java.util.*;
import java.awt.*;
import java.awt.event.*;

public class GameMode extends MouseAdapter implements KeyListener {
    private DrawingPanel startScreen;
    private Graphics g;
    private int down;
    private Image f;

    public GameMode() {
        startScreen = new DrawingPanel(720, 540, 0);
        startScreen.addKeyListener(this);
        startScreen.addMouseListener(this);
        g = startScreen.getGraphics();

        Image f = startScreen.loadImage(new File(".\\gamescreen.jpg"));
        g.drawImage(f, 0, 0, startScreen);

    }

    public void arrow() {
        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(">", 155, 357 + down);
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        if (x >= 0 && y >= 0) {
            startScreen.clear();
            new GameMode();
        }
    }

    public void keyPressed(KeyEvent e) {
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}

