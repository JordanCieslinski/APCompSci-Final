import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class p1 extends MouseAdapter {
    public static Ship[][] board;
    private DrawingPanel frame;
    private Graphics g;

    private DrawingPanel loadShips;
    private Graphics shipDraw;

    private boolean shipIsPlaced = false;

    private int[] clicked;
    private int[] released;

    private int currentShip;

    private String orientation = "";

    public static ArrayList<Point> shipPos = new ArrayList<>();
    public static ArrayList<String> orientationList = new ArrayList<>();

    private Ship[] arr = { new Ship('a'), new Ship('b'), new Ship('d'), new Ship('s'), new Ship('p') };

    public p1() {
        shipIsPlaced = false;

        clicked = new int[2];
        released = new int[2];

        board = new Ship[10][10];

        frame = new DrawingPanel(600, 650, 320);
        frame.addMouseListener(this);
        g = frame.getGraphics();

        g.drawImage(frame.loadImage(".\\pics\\usboard.jpg"), 0, 0, frame);

        loadShips = new DrawingPanel(600, 400, -320);
        loadShips.addMouseListener(this);
        shipDraw = loadShips.getGraphics();

        // AIRCRAFT CARRIER
        shipDraw.drawImage(loadShips.loadImage(".\\pics\\aircraft.jpg"), 0, 0, loadShips);
        currentShip = 0;

    }

    public void mousePressed(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        // FRAME
        if (e.getSource().toString().equals("javax.swing.JPanel[,0,0,600x650,layout=java.awt.FlowLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=java.awt.Dimension[width=600,height=650]]")) {
            if (!shipIsPlaced) {
                clicked[0] = findPos(x, y)[0];
                clicked[1] = findPos(x, y)[1];
            }

        }
        // loadShips
        else if (e.getSource().toString().equals("javax.swing.JPanel[,0,0,600x400,layout=java.awt.FlowLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=java.awt.Dimension[width=600,height=400]]")) {
            if (shipIsPlaced && currentShip == 4 && x > 400 && y >350) {
                frame.getFrame().dispose();
                loadShips.getFrame().dispose();
                new p2();
            }
            else if (shipIsPlaced) {
                if (x > 400 && y > 350) {
                    shipDraw.drawImage(loadShips.loadImage(arr[currentShip += 1].placeLoc), 0, 0, loadShips);
                    shipIsPlaced = false; 
                }
            }
        }

    }

    public void mouseReleased(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        // FRAME
        if (e.getSource().toString().equals(
                "javax.swing.JPanel[,0,0,600x650,layout=java.awt.FlowLayout,alignmentX=0.0,alignmentY=0.0,border=,flags=9,maximumSize=,minimumSize=,preferredSize=java.awt.Dimension[width=600,height=650]]")) {
            released[0] = findPos(x, y)[0];
            released[1] = findPos(x, y)[1];
            if (isValidLocation()) {
                placeShip();
            }

        }

    }

    public int[] findPos(int x, int y) {
        int[] arr = new int[2];
        arr[0] = -1;
        arr[1] = -1;
        if (x > 50 && x < 550 && y > 105 && y < 605 && ((x % 50 != 0) && ((y - 105) % 50 != 0))) {
            arr[1] = (x - 50) / 50;
            arr[0] = (y - 105) / 50;
        }
        return arr;
    }

    public boolean isValidLocation() {
        // rows are same, so it has to be horizontal
        if (clicked[0] == released[0]) {
            if (Math.abs(clicked[1] - released[1]) != arr[currentShip].leng - 1)
                return false;
            for (int i = Math.min(clicked[1], released[1]); i < Math.min(clicked[1], released[1])
                    + arr[currentShip].leng; i++) {
                if (board[clicked[0]][i] != null) {
                    return false;
                }
            }
        } else if (clicked[1] == released[1]) {
            if (Math.abs(clicked[0] - released[0]) != arr[currentShip].leng - 1)
                return false;
            for (int i = Math.min(clicked[0], released[0]); i < Math.min(clicked[0], released[0])
                    + arr[currentShip].leng; i++) {
                if (board[i][clicked[1]] != null) {
                    return false;
                }
            }
        }
        return true;

    }

    public void placeShip() {
        if (clicked[0] == released[0]) {
            orientation = "hori";
            for (int i = Math.min(clicked[1], released[1]); i < Math.min(clicked[1], released[1])
                    + arr[currentShip].leng; i++) {
                board[clicked[0]][i] = arr[currentShip];
            }
            shipIsPlaced = true;
            if(currentShip == 4)
                shipDraw.drawImage(loadShips.loadImage(".\\pics\\p2turn.jpg"), 400, 350, loadShips);
            else
                shipDraw.drawImage(loadShips.loadImage(".\\pics\\nextShip.jpg"), 400, 350, loadShips);
            g.drawImage(frame.loadImage(shipTransparents.shipsOnBoard(arr[currentShip].type, orientation)),(int) positionToDraw().getX(), (int) positionToDraw().getY(), frame);
            shipPos.add(positionToDraw());
            orientationList.add(orientation);
        } else if (clicked[1] == released[1]) {
            orientation = "vert";
            for (int i = Math.min(clicked[0], released[0]); i < Math.min(clicked[0], released[0])
                    + arr[currentShip].leng; i++) {
                board[i][clicked[1]] = arr[currentShip];
            }
            shipIsPlaced = true;
            if(currentShip == 4)
                shipDraw.drawImage(loadShips.loadImage(".\\pics\\p2turn.jpg"), 400, 350, loadShips);
            else
                shipDraw.drawImage(loadShips.loadImage(".\\pics\\nextShip.jpg"), 400, 350, loadShips);
            g.drawImage(frame.loadImage(shipTransparents.shipsOnBoard(arr[currentShip].type, orientation)),
                    (int) positionToDraw().getX(), (int) positionToDraw().getY(), frame);
            shipPos.add(positionToDraw());
            orientationList.add(orientation);
        }
    }

    public void printBoard() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "      ");
            }
            System.out.println();
        }
    }

    public Point positionToDraw() {
        int min;
        int xPos = 0;
        int yPos = 0;
        if (orientation.equals("hori")) {
            min = Math.min(clicked[1], released[1]);
            xPos = 50 + 50 * min;
            yPos = 105 + 50 * clicked[0];
        } else if (orientation.equals("vert")) {
            min = Math.min(clicked[0], released[0]);
            xPos = 50 + 50 * clicked[1];
            yPos = 105 + 50 * min;
        }
        return (new Point(xPos, yPos));

    }
}