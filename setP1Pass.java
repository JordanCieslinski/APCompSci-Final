import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class setP1Pass extends MouseAdapter {

    public static ArrayList<Integer> p1_password = new ArrayList<>();

    private DrawingPanel frame;
    private Graphics g;

    private boolean four = false;

    // 150 235 220 305
    public setP1Pass() {
        frame = new DrawingPanel(600, 650, 0);
        g = frame.getGraphics();
        frame.addMouseListener(this);
        g.drawImage(frame.loadImage(".\\pics\\setp1.jpg"), 0, 0, frame);

    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x > 400 && y > 600 && four) {
            frame.getFrame().dispose();
            new p1();
        } else if (x > 150 && y > 235 && x < 220 && y < 305 && !four) {
            // 1
            p1_password.add(1);
            g.drawImage(frame.loadImage(".\\pics\\nums\\1.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 260 && y > 235 && x < 335 && y < 305 && !four) {
            // 2
            p1_password.add(2);
            g.drawImage(frame.loadImage(".\\pics\\nums\\2.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 375 && y > 235 && x < 450 && y < 305 && !four) {
            // 3
            p1_password.add(3);
            g.drawImage(frame.loadImage(".\\pics\\nums\\3.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 150 && y > 350 && x < 220 && y < 415 && !four) {
            // 4
            p1_password.add(4);
            g.drawImage(frame.loadImage(".\\pics\\nums\\4.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 260 && y > 350 && x < 335 && y < 415 && !four) {
            // 5
            p1_password.add(5);
            g.drawImage(frame.loadImage(".\\pics\\nums\\5.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 375 && y > 350 && x < 450 && y < 415 && !four) {
            // 6
            p1_password.add(6);
            g.drawImage(frame.loadImage(".\\pics\\nums\\6.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 150 && y > 460 && x < 220 && y < 530 && !four) {
            // 7
            p1_password.add(7);
            g.drawImage(frame.loadImage(".\\pics\\nums\\7.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 260 && y > 460 && x < 335 && y < 530 && !four) {
            // 8
            p1_password.add(8);
            g.drawImage(frame.loadImage(".\\pics\\nums\\8.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 375 && y > 460 && x < 450 && y < 530 && !four) {
            // 9
            p1_password.add(9);
            g.drawImage(frame.loadImage(".\\pics\\nums\\9.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 130 && y > 565 && x < 245 && y < 610) {
            // DELETE
            if (p1_password.size() > 0) {
                g.drawImage(frame.loadImage(".\\pics\\nums\\blank.jpg"), (int) xandy().getX(), (int) xandy().getY(),frame);
                p1_password.remove(p1_password.size() - 1);
            }
        }
        isThere4();
    }

    public void isThere4() {
        if (p1_password.size() == 4) {
            g.drawImage(frame.loadImage(".\\pics\\continue.jpg"), 400, 600, frame);
            four = true;
        }
        else{
            g.drawImage(frame.loadImage(".\\pics\\blankCon.jpg"), 400, 600, frame);
            four = false;
        }
    }

    public Point xandy() {
        switch (p1_password.size()) {
            case 1:
                return (new Point(65, 50));
            case 2:
                return (new Point(200, 50));
            case 3:
                return (new Point(330, 50));
            case 4:
                return (new Point(465, 50));
        }
        return null;
    }
}