public class boards {
    public static Ship[][] player1_Ships = new Ship[9][9];
    public static Ship[][] player2_Ships = new Ship[9][9];

    public static void placeShip(int player, Ship type, int rowClicked, int colClicked, int rowReleased, int colReleased, String orientation) {

        // 0, 0
        // 4, 0
        //HORIZONTAL
        int min;
        int max;
        if(orientation.equals("horizontal")){
            min = Math.min(colClicked, colReleased);
            max = Math.max(colClicked, colReleased);
            for (int i = min; i < max; i++) {
                if(player1_Ships[rowClicked][i] == null){
                    
                }
            }
        }
        else if(orientation.equals("vertical")){

        }
    }
}
