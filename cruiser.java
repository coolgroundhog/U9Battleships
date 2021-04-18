public class cruiser extends Ship { //subclass of ship

    cruiser(int locationX, int locationY){
        //super keyword to easily call ship superclass
        super(12000, 3, "Explosive shells", locationX, locationY);
    }
}
