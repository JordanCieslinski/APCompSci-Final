public class Ship {
    private char[] shipArr;
    private char shipType;

    public Ship(int len, char c){
        shipArr = new char[len];
        
        switch(len){
            case 2:
                shipType = 'd';
            case 3:
                shipType = 'c';
            case 4:
                shipType = 'b';
            case 5:
                shipType = 'a';

        }
        for(int i = 0; i < shipArr.length; i++){
            shipArr[i] = shipType;
        }
   }

}
