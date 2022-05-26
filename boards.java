public class boards {
    public static Ship[][] player1_Ships;
    public static Ship[][] player2_Ships;

    public boards() {
        player1_Ships = new Ship[10][10];
        player2_Ships = new Ship[10][10];
    }

    public static void placeShip(int player, Ship type, char r, int c) {
        int row = 0;
        int col = c - 1;

        char[] chars = { 'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j' };
        for (int i = 0; i < chars.length; i++) {
            if(chars[i] == r){
                row = i;
                break;
            }
        }

        if(player == 1){
            player1_Ships[row][col] = type;
        }
        else{
            player2_Ships[row][col] = type;
        }
        

    }
}
