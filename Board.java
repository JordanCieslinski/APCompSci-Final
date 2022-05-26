import java.awt.*;

public class Board{
    private DrawingPanel shotFrame;
    private DrawingPanel shipFrame;
    private Graphics gShot;
    private Graphics gShip;
    private final int offset = 320;

/*
    Coordinates for the board and its coresponding boxes/places
          1          2          3          4          5          6          7          8          9         10
  1      (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)

  2      (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,) 

  3      (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   

  4      (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   

  5      (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)  

  6      (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,) 

  7      (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,) 

  8      (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)

  9      (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)

  10     (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   |    (,)   
*/

    public Board(){
        shotFrame = new DrawingPanel(600,600, -offset);
        shipFrame = new DrawingPanel(600,600, offset);
        gShot = shotFrame.getGraphics();
        gShip = shipFrame.getGraphics();
<<<<<<< Updated upstream

        gShot.drawImage(shotFrame.loadImage(".\\board.jpg"), 50, 50, shotFrame);
        gShip.drawImage(shipFrame.loadImage(".\\board.jpg"), 50, 50, shipFrame);
=======

<<<<<<< HEAD
        gShot.drawImage(shotFrame.loadImage(".\\board.jpg"), 50, 50, shotFrame);
        gShip.drawImage(shipFrame.loadImage(".\\board.jpg"), 50, 50, shipFrame);

    }

    public void placeShip(int x, int y, Ship ship){
        
    }

    //call in shipHit method from the ship class when coding in main
    //to check if a ship is hit, then place a red dot over the ship coordinate
    // public void 
=======
        gShot.drawImage(shotFrame.loadImage(".\\board.jpg"), 0, 0, shotFrame);
        gShip.drawImage(shipFrame.loadImage(".\\board.jpg"), 0, 0, shipFrame);

    }
>>>>>>> Stashed changes

    public void placeShips(){
        
    }
<<<<<<< Updated upstream

    public void placeShip(int x, int y, Ship ship){
        
    }

    //call in shipHit method from the ship class when coding in main
    //to check if a ship is hit, then place a red dot over the ship coordinate
    // public void 
=======
>>>>>>> 4b93019c065994873526ccc7bc893ee47d0f4a0c
>>>>>>> Stashed changes
}
