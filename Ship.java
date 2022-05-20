public class Ship {
    private char[] shipArr;
    private char shipType;

    public Ship(int len, char c){
        shipArr = new char[len];
        
        switch(len){
            case 2:
                shipType = 'd'; //destroyers
            case 3:
                shipType = 'c'; //cruisers
            case 4:
                shipType = 'b'; //battleships
            case 5:
                shipType = 'a'; //aircraft carrier

        }
        for(int i = 0; i < shipArr.length; i++){
            shipArr[i] = shipType;
        }
   }


    public void shipHit(){
        
   }
}
