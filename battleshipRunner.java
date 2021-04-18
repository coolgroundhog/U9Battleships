import java.util.Random;
import java.util.Scanner; 

public class battleshipRunner {

    public static field myMap = new field();

    //Allows for user input for commands
    static Scanner input = new Scanner(System.in);


    public static void main(String[] args) {

        //Creates object of field

        myMap.printSolution();

        //ship placement
        myMap.placeShip('A', 5, 0);
        myMap.placeShip('B', 4, 1);
        myMap.placeShip('C', 3, 2);
        myMap.placeShip('D', 2, 3);
        myMap.placeShip('D', 2, 4);

        myMap.printBoard();


        int loop = 1;

        //loop to keep asking user what they want to do
        while (loop==1){
            String userInput = input.nextLine();

            //firing ship
            if (userInput.startsWith("fire")){

                System.out.print("X coordinate: ");
                int xCoordinate = input.nextInt();


                System.out.print("Y coordinate: ");
                int yCoordinate = input.nextInt();

                myMap.fire(xCoordinate, yCoordinate);//fire method from field.java

                myMap.printBoard();

            }

            //print list of commands
            else if (userInput.equals("help")){
                System.out.println("Possible commands: \nview board - displays the user’s board\nview ships - displays the placement of the ships\nfire - fires a missile at chosen cell\nstats - prints out the game statistics\nquit - exits the game");
            }


            //game statistics
            else if (userInput.equals("stats")){

                //Number of missiles fired
                System.out.println("Number of missiles fired: " + myMap.numberOfMissilesFired);


                //Hit ratio
                if (myMap.numberOfMissilesFired > 0){
                    System.out.println("Hit ratio: " + myMap.numberOfTimesHit / myMap.numberOfMissilesFired);
                }

                //condition needed bc if number of missiles fired = 0, you can't divide by 0
                else if (myMap.numberOfMissilesFired == 0){
                    System.out.println("Hit ratio: N/A; missiles weren't fired");
                }


                //Number of ships sunk
                for (int i = 0; i<3; i++){
                    if (myMap.shipsSunk[i] == 0){//checks if shipsSunk array element = 0. If it is (explained in field.java lines 154-171)
                        myMap.numberOfShipsSunk++;
                    }
                }

                System.out.println("Number of ships sunk:" + myMap.numberOfShipsSunk);

            }

            else if (userInput.equals("view ships")){
                myMap.printSolution();
            }

            else if (userInput.equals("quit")){
                System.out.println("Bye!");
                loop = 0;
            }


            //Specific info about ships
            else if (userInput.equals("info aircraft")){
                aircraftCarrier aCarrier = new aircraftCarrier(myMap.positionStoring[0][0], myMap.positionStoring[0][1]);//takes parameter for ship location. For myMap.positionStoring[X][Y], X corresponds to type of ship (0=aircraft). Y corresponds to X/Y coordinate

                //Methods taken from ship superclass
                System.out.println("Length: " + aCarrier.length);
                System.out.println("Total cost: " + aCarrier.getCost());
                System.out.println("Weaponry: " + aCarrier.weaponry);
                System.out.println("Hint of location: the X coordinate * Y coordinate of one of the ship locations is: "  + aCarrier.getProduct());

            }


            //everything below is same as aircraft but calls on diff. subclasses
            else if (userInput.equals("info battleship")){
                battleship bShip = new battleship(myMap.positionStoring[1][0], myMap.positionStoring[1][1]);

                System.out.println("Length: " + bShip.length);
                System.out.println("Total cost: " + bShip.getCost());
                System.out.println("Weaponry: " + bShip.weaponry);
                System.out.println("Hint of location: the X coordinate * Y coordinate of one of the ship locations is: "  + bShip.getProduct());
            }


            else if (userInput.equals("info cruiser")){
                cruiser cShip = new cruiser(myMap.positionStoring[2][0], myMap.positionStoring[2][1]);

                System.out.println("Length: " + cShip.length);
                System.out.println("Total cost: " + cShip.getCost());
                System.out.println("Weaponry: " + cShip.weaponry);
                System.out.println("Hint of location: the X coordinate * Y coordinate of one of the ship locations is: "  + cShip.getProduct());
            
            }

            else if (userInput.equals("info destroyer 1")){
                destroyer dShip1 = new destroyer(myMap.positionStoring[3][0], myMap.positionStoring[3][1]);

                System.out.println("Length: " + dShip1.length);
                System.out.println("Total cost: " + dShip1.getCost());
                System.out.println("Weaponry: " + dShip1.weaponry);
                System.out.println("Hint of location: the X coordinate * Y coordinate of one of the ship locations is: "  + dShip1.getProduct());
            
        
            }

            else if (userInput.equals("info destroyer 2")){
                destroyer dShip2 = new destroyer(myMap.positionStoring[4][0], myMap.positionStoring[4][1]);

                System.out.println("Length: " + dShip2.length);
                System.out.println("Total cost: " + dShip2.getCost());
                System.out.println("Weaponry: " + dShip2.weaponry);
                System.out.println("Hint of location: the X coordinate * Y coordinate of one of the ship locations is: "  + dShip2.getProduct());
            
        
            }

            else {
                System.out.println("Command not found!");
            }


        }

    }
}
