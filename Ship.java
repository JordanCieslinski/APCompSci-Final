import java.io.File;

public class Ship {
    public int leng;
    public char type;
    public File placeLoc;

    public Ship(int len, char c) {
        leng = len;
        type = c;
        switch (type) {
            case 'a':
                placeLoc = new File(".\\pics\\airCraft.jpg");
                break;
            case 'b':
                placeLoc = new File(".\\pics\\battleship.jpg");
                break;
            case 'd':
                placeLoc = new File(".\\pics\\destroyer.jpg");
                break;
            case 's':
                placeLoc = new File(".\\pics\\sub.jpg");
                break;
            case 'p':
                placeLoc = new File(".\\pics\\patrol.jpg");
                break;
        }
    }

    public String toString(){
        return type+"";
    }

}
