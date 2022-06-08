public class boards {
    public static Ship[][] player1_Ships = new Ship[10][10];
    public static Ship[][] player2_Ships = new Ship[10][10];

    public static void placeShip(int player, Ship type, int rC, int cC, int rR, int cR) {

        // 0, 0
        // 4, 0
        if (rC == rR) {
            for (int i = cC; i <= cR; i++) {
                if (player == 1 && player1_Ships[rC][i] == null) {
                    player1_Ships[rC][i] = type;
                } else if (player == 2 && player2_Ships[rC][i] == null) {
                    player2_Ships[rC][i] = type;
                } else {
                    // PUT TRY AGAIN SCREEN
                    System.out.println("Try again");
                    player_2.counter--;
                }

            }
        } else if (cC == cR) {
            for (int i = rC; i <= rR; i++) { //!FIX MAYBE? GOING OUT OF BOUNDS, THEN JUMPING BACK TO airCraft ? ITS BECAUSE ITS LOOPING THROUGH ELSE CLAUSE MULTIPLE TIMES
                if (player == 1 && player1_Ships[i][cC] == null) {
                    player1_Ships[i][cC] = type;
                    if(i == rR)
                        player_2.gShip.drawImage(player_2.shipFrame.loadImage(), 0, 0, player_2.shipFrame); //!MAybe move loops and ifs so that it will only draw once when it finishes

                } else if (player == 2 && player2_Ships[i][cC] == null) {
                    player2_Ships[i][cC] = type;
                } else {
                    //! PUT TRY AGAIN SCREEN
                    System.out.println("Try again");
                    player_2.counter--;
                }

            }
        }

    }
}
