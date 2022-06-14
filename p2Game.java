import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class p2Game extends MouseAdapter {
    private static Ship[][] board = p2.board;

    private static Ship[][] shot = new Ship[10][10];

    public static DrawingPanel fleet;
    private Graphics shipDraw;

    public static DrawingPanel shots;
    private Graphics shotDraw;

    private Ship[] arr = { new Ship('a'), new Ship('b'), new Ship('d'), new Ship('s'), new Ship('p') };

    private int[] shotPos = new int[2];

    private boolean shotIsTaken = false;

    public static ArrayList<Point> hitList = new ArrayList<>();
    public static ArrayList<Point> missList = new ArrayList<>();  

    public static int aCount = 0;
    public static int bCount = 0;
    public static int dCount = 0;
    public static int sCount = 0;
    public static int pCount = 0;
    public static int shipSunkCount = 0;

    public p2Game() {

        fleet = new DrawingPanel(600, 650, 320);
        shipDraw = fleet.getGraphics();

        shots = new DrawingPanel(600, 650, -320);
        shotDraw = shots.getGraphics();
        shots.addMouseListener(this);

        shipDraw.drawImage(fleet.loadImage(".\\pics\\sovietboard.jpg"), 0, 0, fleet);
        shotDraw.drawImage(shots.loadImage(".\\pics\\shots.jpg"), 0, 0, fleet);

        replaceShips();
        replaceShots();

    }


    public void replaceShips() {
        for (int i = 0; i < p2.shipPos.size(); i++) {
            shipDraw.drawImage(fleet.loadImage(shipTransparents.shipsOnBoard(arr[i].type, p2.orientationList.get(i))),(int) p2.shipPos.get(i).getX(), (int) p2.shipPos.get(i).getY(), fleet);
        }
        for (int i = 0; i < p1Game.hitList.size(); i++) {
            shipDraw.drawImage(fleet.loadImage(".\\pics\\hit.png"), (int)p1Game.hitList.get(i).getX(), (int)p1Game.hitList.get(i).getY(),fleet);
        }
    }

    public void replaceShots() {
        for (int i = 0; i < hitList.size(); i++) {
            shotDraw.drawImage(shots.loadImage(".\\pics\\hit.png"), (int)hitList.get(i).getX(), (int)hitList.get(i).getY(), shots);
        }
        for (int i= 0; i < missList.size(); i++) {
            shotDraw.drawImage(shots.loadImage(".\\pics\\miss.png"), (int)missList.get(i).getX(), (int)missList.get(i).getY(), shots);
        }
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        shotPos = findPos(x, y);
        if (!shotIsTaken) {
            if (isValidLocation()) {
                if (p1.board[shotPos[0]][shotPos[1]] != null) {
                    shot[shotPos[0]][shotPos[1]] = new Ship('x');
                    addToCounter(shotPos[0], shotPos[1]);
                    new checkCounters(2);
                    shotDraw.drawImage(shots.loadImage(".\\pics\\hit.png"), (int) positionToDraw().getX(),(int) positionToDraw().getY(), shots);
                    new Between("hit");
                    shotIsTaken = true;
                    shotDraw.drawImage(shots.loadImage(".\\pics\\p1turn.jpg"), 390, 15, shots);
                    hitList.add(positionToDraw());

                } else {
                    shot[shotPos[0]][shotPos[1]] = new Ship('m');
                    shotDraw.drawImage(shots.loadImage(".\\pics\\miss.png"), (int) positionToDraw().getX(),(int) positionToDraw().getY(), shots);
                    new Between("miss");
                    shotIsTaken = true;
                    shotDraw.drawImage(shots.loadImage(".\\pics\\p1turn.jpg"), 390, 15, shots);
                    missList.add(positionToDraw());
                }
            }

        } else if (x > 390 && y > 15 && x < 590 && y < 65) {
            shots.getFrame().dispose();
            fleet.getFrame().dispose();
            new P1Pass();
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
        if (shot[shotPos[0]][shotPos[1]] != null) {
            return false;
        }
        return true;

    }

    public void printBoard() {
        for (int i = 0; i < shot.length; i++) {
            for (int j = 0; j < shot[i].length; j++) {
                System.out.print(shot[i][j] + "      ");
            }
            System.out.println();
        }
    }

    public Point positionToDraw() {
        int xPos = 50 + 50 * shotPos[1];
        int yPos = 105 + 50 * shotPos[0];

        return (new Point(xPos, yPos));

    }

    public static void addToCounter(int x, int y){
        switch(p1.board[x][y].type){
            case 'a':
                p1Game.aCount++;
                break;
            case 'b':
                p1Game.bCount++;
                break;
            case 'd':
                p1Game.dCount++;
                break;
            case 's':
                p1Game.sCount++;
                break;
            case 'p':
                p1Game.pCount++;
                break;
        }
    }
}