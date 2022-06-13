import java.awt.*;
import java.awt.event.*;

public class p1Game extends MouseAdapter {
    private static Ship[][] board = p1.board;

    private static Ship[][] shot = new Ship[10][10];

    private DrawingPanel fleet;
    private Graphics shipDraw;

    private DrawingPanel shots;
    private Graphics shotDraw;

    private Ship[] arr = { new Ship('a'), new Ship('b'), new Ship('d'), new Ship('s'), new Ship('p') };

    private int[] shotPos = new int[2];

    private boolean shotIsTaken = false;

    public p1Game() {

        fleet = new DrawingPanel(600, 650, 320);
        shipDraw = fleet.getGraphics();

        shots = new DrawingPanel(600, 650, -320);
        shotDraw = shots.getGraphics();
        shots.addMouseListener(this);

        shipDraw.drawImage(fleet.loadImage(".\\pics\\usboard.jpg"), 0, 0, fleet);
        shotDraw.drawImage(shots.loadImage(".\\pics\\shots.jpg"), 0, 0, fleet);

        replaceShips();
        replaceShots();

    }

    public void replaceShips() {
        for (int i = 0; i < p1.shipPos.size(); i++) {
            shipDraw.drawImage(fleet.loadImage(shipTransparents.shipsOnBoard(arr[i].type, p1.orientationList.get(i))),
                    (int) p1.shipPos.get(i).getX(), (int) p1.shipPos.get(i).getY(), fleet);
        }
    }

    public void replaceShots() {
        for (int i = 0; i < p1.shipPos.size(); i++) {
            // TODO REDRAW ALL SHOTS
        }
    }

    public void mouseClicked(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();

        shotPos = findPos(x, y);

        System.out.println(shotPos[0]+ " "+shotPos[1]);
        if (isValidLocation()) {
            if (p2.board[shotPos[0]][shotPos[1]] != null) {
                shot[shotPos[0]][shotPos[1]] = new Ship('x');
                shotDraw.drawImage(shots.loadImage(".\\pics\\hit.png"), (int) positionToDraw().getX(), (int) positionToDraw().getY(), shots);
                shotIsTaken = true;
            } else {
                shot[shotPos[0]][shotPos[1]] = new Ship('m');
                shotDraw.drawImage(shots.loadImage(".\\pics\\miss.png"), (int) positionToDraw().getX(), (int) positionToDraw().getY(), shots);
                shotIsTaken = true;
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
}