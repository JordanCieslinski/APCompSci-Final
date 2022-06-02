import java.io.File;

public class Ship {
    public int length;
    public char type;
    public File shipLoc;

    public Ship(int len, char c) {
        length = len;
        type = c;
        switch (type) {
            case 'a':
                shipLoc = new File(".\\pics\\airCraft.jpg");
                break;
            case 'b':
                shipLoc = new File(".\\pics\\battleship.jpg");
                break;
            case 'd':
                shipLoc = new File(".\\pics\\destroyer.jpg");
                break;
            case 's':
                shipLoc = new File(".\\pics\\sub.jpg");
                break;
            case 'p':
                shipLoc = new File(".\\pics\\patrol.jpg");
                break;
        }
    }

}
