import java.util.*;
import java.awt.*;
import java.awt.event.*;
public class Demo extends MouseAdapter implements KeyListener 
{
    DrawingPanel frame;
    Graphics g;
    public Demo()
    {
        frame = new DrawingPanel(600,300);
        g = frame.getGraphics();
        frame.addMouseListener(this);
        frame.addKeyListener(this);
    }
    public void mouseClicked(MouseEvent e)
    {
        int x = e.getX();
        int y = e.getY();
        //System.out.println(x+" "+ y);
        if(x < 100 && x >= 0 && y <100 && y>=0){
            g.setColor(Color.RED);
            g.fillRect(0,0,300,200);
            g.setColor(Color.BLACK);
            g.setFont(new Font("Arial",Font.BOLD, 30));
            g.drawString("Hello World!",100,40);
        }
        else{
            frame.getFrame().dispose();
            new Demo();
        }
    }
    public void keyPressed(KeyEvent e)
    {
        int key  = e.getKeyCode();
        if(key == KeyEvent.VK_LEFT){
            Image i = frame.loadImage(".\\Final Project Student Notes\\pmg.jpg");
            g.drawImage(i, 0, 0, frame);
        }
        else if(key == KeyEvent.VK_A){
            Image i = frame.loadImage(".\\Final Project Student Notes\\pic.jpg");
            g.drawImage(i, 400, 0, frame);
        }
    }
    public void keyReleased(KeyEvent e){}
    public void keyTyped(KeyEvent e){}
}
