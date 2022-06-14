import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Arrays;

public class P2Pass extends MouseAdapter {

    public ArrayList<Integer> pass_entered = new ArrayList<>();

    private DrawingPanel frame;
    private Graphics g;

    private boolean four = false;

    public P2Pass() {
        frame = new DrawingPanel(600, 650, 0);
        g = frame.getGraphics();
        frame.addMouseListener(this);
        g.drawImage(frame.loadImage(".\\pics\\enterp2.jpg"), 0, 0, frame);

    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        if (x > 400 && y > 600 && four) {
            if(checkPass()){
                frame.getFrame().dispose();
                new p2Game();
            }
            else{
                new Between("again");
                pass_entered.clear();
                g.drawImage(frame.loadImage(".\\pics\\removePass.jpg"), 0, 50, frame);
            }
        } else if (x > 150 && y > 235 && x < 220 && y < 305 && !four) {
            // 1
            pass_entered.add(1);
            g.drawImage(frame.loadImage(".\\pics\\nums\\1.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 260 && y > 235 && x < 335 && y < 305 && !four) {
            // 2
            pass_entered.add(2);
            g.drawImage(frame.loadImage(".\\pics\\nums\\2.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 375 && y > 235 && x < 450 && y < 305 && !four) {
            // 3
            pass_entered.add(3);
            g.drawImage(frame.loadImage(".\\pics\\nums\\3.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 150 && y > 350 && x < 220 && y < 415 && !four) {
            // 4
            pass_entered.add(4);
            g.drawImage(frame.loadImage(".\\pics\\nums\\4.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 260 && y > 350 && x < 335 && y < 415 && !four) {
            // 5
            pass_entered.add(5);
            g.drawImage(frame.loadImage(".\\pics\\nums\\5.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 375 && y > 350 && x < 450 && y < 415 && !four) {
            // 6
            pass_entered.add(6);
            g.drawImage(frame.loadImage(".\\pics\\nums\\6.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 150 && y > 460 && x < 220 && y < 530 && !four) {
            // 7
            pass_entered.add(7);
            g.drawImage(frame.loadImage(".\\pics\\nums\\7.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 260 && y > 460 && x < 335 && y < 530 && !four) {
            // 8
            pass_entered.add(8);
            g.drawImage(frame.loadImage(".\\pics\\nums\\8.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 375 && y > 460 && x < 450 && y < 530 && !four) {
            // 9
            pass_entered.add(9);
            g.drawImage(frame.loadImage(".\\pics\\nums\\9.jpg"), (int) xandy().getX(), (int) xandy().getY(), frame);
        } else if (x > 130 && y > 565 && x < 245 && y < 610) {
            // DELETE
            if (pass_entered.size() > 0) {
                g.drawImage(frame.loadImage(".\\pics\\nums\\blank.jpg"), (int) xandy().getX(), (int) xandy().getY(),frame);
                pass_entered.remove(pass_entered.size() - 1);
            }
        }
        isThere4();
    }

    public void isThere4() {
        if (pass_entered.size() == 4) {
            g.drawImage(frame.loadImage(".\\pics\\continue.jpg"), 400, 600, frame);
            four = true;
        }
        else{
            g.drawImage(frame.loadImage(".\\pics\\blankCon.jpg"), 400, 600, frame);
            four = false;
        }
    }

    public Point xandy() {
        switch (pass_entered.size()) {
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

    public boolean checkPass(){
        for (int i = 0; i < pass_entered.size(); i++) {
            if(pass_entered.get(i) != setP2Pass.p2_password.get(i)){
                return false;
            }
        }
        return true;
    }
}