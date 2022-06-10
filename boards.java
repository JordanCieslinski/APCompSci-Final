public class boards {
    public static Ship[][] player1_Ships = new Ship[10][10];
    public static Ship[][] player2_Ships = new Ship[10][10];
    private static int row1;
    private static int col1;
    private static int row2;
    private static int col2;

    private static int player;

    private static int start;
    private static int end;

    private static Ship type;

    public boards(int p, Ship t, int r1, int c1, int r2, int c2) {
        row1 = r1;
        col1 = c1;
        row2 = r2;
        col2 = c2;
        player = p;
        type = t;
    }
    public static void placeShips(){
        System.out.println(row1 + " " + col1);
        System.out.println(row2 + " " + col2);

        Ship[][] shipsToChange = (player == 1) ? player1_Ships : player2_Ships;


        if(isValidLocation() == true){
            if(orientation() == "hori"){
                for (int i = start; i <= end; i++) {
                    shipsToChange[row1][i] = type;
                }
            }
            else if(orientation() == "vert"){
                for (int i = start; i <= end; i++) {
                    shipsToChange[i][col1] = type;
                }
            }
        }
    }

    public static String orientation() {
        String str = "";
        if (row1 == row2) {
            str = "hori";
            start = Math.min(col1, col2);
            end = Math.max(col1, col2);
        } else if (col1 == col2) {
            str = "vert";
            start = Math.min(row1, row2);
            end = Math.max(row1, row2);
        }
        return str;
    }

    public static boolean isValidLocation() {
        Ship[][] arr = (player == 1) ? player1_Ships : player2_Ships;

        if (orientation() == "hori") {
            for (int i = start; i <= end; i++) {
                if (arr[row1][i] == null)
                    return false;
            }
            return true;
        } else if (orientation() == "vert") {
            for (int i = start; i <= end; i++) {
                if (arr[i][col1] == null)
                    return false;
            }
            return true;
        } else {
            System.out.println("Invalid Location");
            return false;
        }

    }
}
