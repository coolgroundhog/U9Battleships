public class Ship {
    int costPerArea;
    int length;
    int locationX;
    int locationY;
    String weaponry;


    public Ship(int costPH, int len, String weapons, int locX, int locY){
        this.costPerArea = costPH;
        this.length = len;
        this.weaponry = weapons;
        this.locationX = locX;
        this.locationY = locY;

    }


    public int getCost(){
        return costPerArea*length;
    }


    public static void main(String[] args) {
        aircraftCarrier aCarrier = new aircraftCarrier();
    }


}
