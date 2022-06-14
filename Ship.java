import java.io.File;

public class Ship {
    public int leng;
    public char type;
    public String placeLoc;

    public Ship(char c) {
        type = c;
        switch (type) {
            case 'a':
                placeLoc = ("./pics/airCraft.jpg");
                leng = 5;
                break;
            case 'b':
                placeLoc = ("./pics/battleship.jpg");
                leng = 4;
                break;
            case 'd':
                placeLoc = ("./pics/destroyer.jpg");
                leng = 3;
                break;
            case 's':
                placeLoc = ("./pics/sub.jpg");
                leng = 3;
                break;
            case 'p':
                placeLoc = ("./pics/patrol.jpg");
                leng = 2;
                break;
        }
    }

    public String toString(){
        return type+"";
    }

}
