import java.io.File;
import java.awt.event.*;

public class HowToPlay extends MouseAdapter {
    DrawingPanel frame;
    public HowToPlay(){
        frame = new DrawingPanel(new File("./pics/howtoplay.jpg"));
        frame.addMouseListener(this);
    }

    public void mousePressed(MouseEvent e){
        frame.getFrame().dispose();
        new gamechoose();
    }
}
