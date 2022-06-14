import java.awt.*;

public class drawBoard{
    private DrawingPanel shotFrame;
    private DrawingPanel shipFrame;
    private Graphics gShot;
    private Graphics gShip;
    private final int offset = 320;

    public drawBoard(){
        shotFrame = new DrawingPanel(600,600, -offset);
        shipFrame = new DrawingPanel(600,600, offset);
        gShot = shotFrame.getGraphics();
        gShip = shipFrame.getGraphics();

        gShot.drawImage(shotFrame.loadImage("./pics/board.jpg"), 0, 0, shotFrame);
        gShip.drawImage(shipFrame.loadImage("./pics/board.jpg"), 0, 0, shipFrame);

    }

    public void placeShips(){
        
    }
}
