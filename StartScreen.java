import java.io.File;
import java.util.*;

import org.w3c.dom.events.MouseEvent;

import java.awt.*;
import java.awt.event.*;

public class StartScreen extends MouseAdapter implements KeyListener {
    private DrawingPanel startScreen;
    private Graphics g;
    private int down;
    private Image f;

    public StartScreen(int stage) {
            startScreen = new DrawingPanel(720, 540, 0);
            startScreen.addKeyListener(this);
            startScreen.addMouseListener(this);
            g = startScreen.getGraphics();
        if (stage == 1) {
            Image f = startScreen.loadImage(new File(".\\StartScreen.jpg"));
            g.drawImage(f, 0, 0, startScreen);
        }
        else if(stage == 2){
            startScreen = new DrawingPanel(720, 540, 0);

        }

    }

    public void arrow() {
        

        g.setFont(new Font("Arial", Font.BOLD, 30));
        g.drawString(">", 155, 357 + down);
    }

    public void mouseClicked(MouseEvent e) {
        startScreen.getFrame().dispose();
    }

    public void keyPressed(KeyEvent e) {
        int key = e.getKeyCode();
        switch (key) {
            case KeyEvent.VK_DOWN:
                startScreen.clear();

        }
    }

    public void keyReleased(KeyEvent e) {
    }

    public void keyTyped(KeyEvent e) {
    }
}
