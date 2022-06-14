import java.io.File;

public class shipTransparents {
    public static final String airCraftHori = ("./pics/ships/airCraftHori.png");
    public static final String airCraftVert =("./pics/ships/airCraftVert.png");//("./pics/]ships/airCraftVert.png");
    public static final String battleshipHori = ("./pics/ships/battleshipHori.png");
    public static final String battleshipVert = ("./pics/ships/battleshipVert.png");
    public static final String destroyerHori = ("./pics/ships/destroyerHori.png");
    public static final String destroyerVert = ("./pics/ships/destroyerVert.png");
    public static final String subHori = ("./pics/ships/subHori.png");
    public static final String subVert = ("./pics/ships/subVert.png");
    public static final String patrolHori = ("./pics/ships/patrolHori.png");
    public static final String patrolVert = ("./pics/ships/patrolVert.png");
    
    public static String shipsOnBoard(char type, String orientation) {
        String f = "";
        switch (type) {
            case 'a':
                if (orientation.equals("hori"))
                    f = airCraftHori;
                else if(orientation.equals("vert"))
                    f =  airCraftVert;
                break;
            case 'b':
                if (orientation.equals("hori"))
                    f =  battleshipHori;
                else if(orientation.equals("vert"))
                    f =  battleshipVert;
                break;
            case 'd':
                if (orientation.equals("hori"))
                    f =  destroyerHori;
                else if(orientation.equals("vert"))
                    f =  destroyerVert;
                break;
            case 's':
                if (orientation.equals("hori"))
                    f =  subHori;
                else if(orientation.equals("vert"))
                    f =  subVert;
                break;
            case 'p':
                if (orientation.equals("hori"))
                    f =  patrolHori;
                else if(orientation.equals("vert"))
                    f =  patrolVert;
                break;
        }
        return f;
    }
}
