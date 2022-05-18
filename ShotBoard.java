import java.awt.*;
public class ShotBoard {
    private final int rows = 10;
    private final int columns = 10;
    public static DrawingPanel frame;
    private Graphics g;
    private char[][] arr;

    public ShotBoard(){
        frame = new DrawingPanel(1200,600); //each board 500x500 pixels
        g = frame.getGraphics();
        arr = new char[rows][columns];
    }

}
