public class boards {
    public static Ship[][] player1_Ships = new Ship[10][10];
    public static Ship[][] player2_Ships = new Ship[10][10];

    //wits until the locaion is valid
    public static boolean isvalidLocation1 = false;
    public static boolean isvalidLocation2 = false;

    public static void placeShip(int player, Ship type, int rowClicked, int colClicked, int rowReleased,
            int colReleased, String orientation) {
        System.out.println(rowClicked+" "+colClicked);
        System.out.println(rowReleased+" "+colReleased);
        // 0, 0
        // 4, 0
        // HORIZONTAL
        int min;
        int max;
        boolean invalidLoc = false;
        

        if (orientation.equals("horizontal")) {
            min = Math.min(colClicked, colReleased);
            max = Math.max(colClicked, colReleased);
            System.out.println("minmax: "+min+" "+ max);
            for (int i = min; i <= max; i++) {
                if (player == 1 && player1_Ships[rowClicked][i] != null) {
                    invalidLoc = true;
                    break;
                } else if (player == 2 && player2_Ships[rowClicked][i] != null) {
                    invalidLoc = true;
                    break;
                }
            }
            if (invalidLoc == false) {
                for (int i = min; i <= max; i++) {
                    if (player == 1) {
                        player1_Ships[rowClicked][i] = type;
                        isvalidLocation1 = true;

                    } else if (player == 2) {
                        player2_Ships[rowClicked][i] = type;
                        isvalidLocation2 = true;
                        
                    }
                }
                player_2.gShip.drawImage(player_2.shipFrame.loadImage(shipTransparents.shipsOnBoard(type.type, orientation)), 0, 0, player_2.shipFrame);
            }
        } else if (orientation.equals("vertical")) {
            min = Math.min(rowClicked, rowReleased);
            max = Math.max(rowClicked, rowReleased);
            for (int i = min; i <= max; i++) {
                if (player == 1 && player1_Ships[rowClicked][i] != null) {
                    invalidLoc = true;
                    break;
                } else if (player == 2 && player2_Ships[rowClicked][i] != null) {
                    invalidLoc = true;
                    break;
                }
            }
            if (invalidLoc == false) {
                for (int i = min; i <= max; i++) {
                    if (player == 1) {
                        player1_Ships[rowClicked][i] = type;
                        
                    } else if (player == 2) {
                        player2_Ships[rowClicked][i] = type;
                        
                    }

                }
            }
        }
        player_2.alreadyAShip = invalidLoc;
    }
}
