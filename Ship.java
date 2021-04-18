public class Ship {
    int costPerArea;
    int length;
    int locationX;
    int locationY;
    String weaponry;

    //each ship has specific cost per area, length, weapons, etc
    public Ship(int costPH, int len, String weapons, int locX, int locY){
        this.costPerArea = costPH;
        this.length = len;
        this.weaponry = weapons;
        this.locationX = locX;
        this.locationY = locY;

    }


    public int getCost(){
        return costPerArea*length;//cost per area * length = total cost
    }

    public int getProduct(){
        return locationX*locationY;//gets product of x,y coordinate of ship
    }

}
