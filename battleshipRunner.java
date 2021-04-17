import java.util.Random;
import java.util.Scanner; 

public class battleshipRunner {

    public static field myMap = new field();

    //Allows for user input for commands
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        
        //Creates object of field
        
        char [][] gameBoard = new char[10][10];
        char [][] solutionBoard = new char[10][10];

        myMap.printSolution();


        myMap.placeShip('A', 5, 0);
        myMap.placeShip('B', 4, 1);
        myMap.placeShip('C', 3, 2);
        myMap.placeShip('D', 2, 3);
        myMap.placeShip('D', 2, 4);

        myMap.printBoard();


        int loop = 1;

        while (loop==1){
            String userInput = input.nextLine();
            if (userInput.startsWith("fire")){

                System.out.print("X coordinate: ");
                int xCoordinate = input.nextInt();


                System.out.print("Y coordinate: ");
                int yCoordinate = input.nextInt();

                myMap.fire(xCoordinate, yCoordinate);

                myMap.printBoard();

            }


            else if (userInput.equals("help")){
                System.out.println("Possible commands: \nview board - displays the user’s board\nview ships - displays the placement of the ships\nfire - fires a missile at chosen cell\nstats - prints out the game statistics\nquit - exits the game");
            }

            else if (userInput.equals("stats")){
                System.out.println("Number of missiles fired: " + myMap.numberOfMissilesFired);

                if (myMap.numberOfMissilesFired > 0){
                    System.out.println("Hit ratio: " + myMap.numberOfTimesHit / myMap.numberOfMissilesFired);
                }
                else if (myMap.numberOfMissilesFired == 0){
                    System.out.println("Hit ratio: N/A; missles weren't fired");
                }

                for (int i = 0; i<3; i++){
                    if (myMap.shipsSunk[i] == 0){
                        myMap.numberOfShipsSunk++;
                    }
                }

                System.out.println("Number of ships sunk:" + myMap.numberOfShipsSunk);

                for (int i = 0; i<3; i++){
                    System.out.println(myMap.shipsSunk[i] + " ");
                }


            }

            else if (userInput.equals("view ships")){
                myMap.printSolution();
            }

            else if (userInput.equals("quit")){
                System.out.println("Bye!");
                loop = 0;
            }

            else if (userInput.equals("info aircraft")){
                aircraftCarrier aCarrier = new aircraftCarrier(myMap.positionStoring[0][0], myMap.positionStoring[0][1]);

                System.out.println("Length: " + aCarrier.length);
                System.out.println("Cost: " + aCarrier.getCost());
                System.out.println("Weaponry: " + aCarrier.weaponry);
                System.out.println("X-coordinate: "  + aCarrier.locationX);

                System.out.println(myMap.positionStoring[0][0]);
            }




            else {
                System.out.println("Command not found!");
            }


        }

    }
}
