import java.io.File;

public class shipTransparents {
    public File shipLoc;
    // ! NEED TO CHECK WHICH SHIP TO ADD DEPENDING ON WHERE IT IS IN LOOP
    public static final File airCraftHori = new File(".\\pics\\ships\\airCraftHori.png");
    public static final File airCraftVertical = new File(".\\pics\\ships\\airCraftVertical.png");
    public static final File battleshipHori = new File(".\\pics\\ships\\battleshipHori.png");
    public static final File battleshipVertical = new File(".\\pics\\ships\\battleshipVertical.png");
    public static final File destroyerHori = new File(".\\pics\\ships\\destroyerHori.png");
    public static final File destroyerVertical = new File(".\\pics\\ships\\destroyerVertical.png");
    public static final File subHori = new File(".\\pics\\ships\\subHori.png");
    public static final File subVertical = new File(".\\pics\\ships\\subVertical.png");
    public static final File patrolHori = new File(".\\pics\\ships\\patrolHori.png");
    public static final File patrolVertical = new File(".\\pics\\ships\\patrolVertical.png");
    
    public static File shipsOnBoard(char type, String orientation) {
        File f = new File("");
        switch (type) {
            case 'a':
                if (orientation.equals("horizontal"))
                    f =  airCraftHori;
                f =  airCraftVertical;
                break;
            case 'b':
                if (orientation.equals("horizontal"))
                    f =  battleshipHori;
                f =  battleshipVertical;
                break;
            case 'd':
                if (orientation.equals("horizontal"))
                    f =  destroyerHori;
                f =  destroyerVertical;
                break;
            case 's':
                if (orientation.equals("horizontal"))
                    f =  subHori;
                f =  subVertical;
                break;
            case 'p':
                if (orientation.equals("horizontal"))
                    f =  patrolHori;
                f =  patrolVertical;
                break;
        }
        return f;
    }
}
