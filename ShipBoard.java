import java.awt.*;

public class ShipBoard extends ShotBoard{
    private DrawingPanel frame;
    private Graphics g;

    public ShipBoard(){
        super();
        DrawingPanel frame = new DrawingPanel(400, 400);
    }
}
