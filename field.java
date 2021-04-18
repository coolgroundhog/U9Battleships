import java.util.Random;
import java.util.Scanner; 

public class field {

    private char[][] gameBoard;
    static char[][] solutionBoard;
    public Ship[] ships;

    /**
     * Instantiate a new field object.
     */
    public field() {
        gameBoard = new char[10][10];
        solutionBoard = new char[10][10];
        fillBoard(gameBoard);
        fillBoard(solutionBoard);
    }


    //Fills board with '-' (blanks)
    private void fillBoard(char [][] map){
        for(int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				map[i][j] = '-';
			}
		}
    }


    //PRINTING THE BOARD
    public void printBoard(){
        printBoard(gameBoard);
    }

    public void printSolution(){
        printBoard(solutionBoard);
    }


    public void printBoard(char[][] map){
        
        System.out.print("  "); //for the small space in the top left of board
        for(int a = 0; a < 10; a++){
            System.out.print(a + " ");//for top row label that goes from 0-9
        }
        System.out.println();


        //two for loops to iterate through the field
        for(int i = 0; i < 10; i++) {
            System.out.print(i + " ");//at beginning of every row, print the row number
            
            for (int j = 0; j < 10; j++) {
				System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }


    static Random rand = new Random();//for randomly generating ship position

    public static int[][] positionStoring = new int[5][2];//stores ship positions (used in inheritance)

    public static void placeShip(char displayCharacter, int length, int shipOrder){
        
        Random rand = new Random();

        int horizontalOrVertical = rand.nextInt(2);//generate random number from 0-1

        int counter = 0;

        if (horizontalOrVertical == 1){//if random number = 1, ship is horizontal

            int placementX = 0;
            int placementY = 0;


            //while loop checks if there is nothing blocking the ship when it is placed
            while (counter!=length){
                counter = 0;

                placementX = rand.nextInt(10);
                placementY = rand.nextInt(10-length-1) + length - 1;//starts ship placement well within field according to length, so that the ship doesn't hang off edge
    
                for (int i = 0; i < length; i++){
                    if (solutionBoard[placementX][placementY - i] == '-'){//if spot is free
                        counter++;//counter increases for every free spot for the ship. If this variable = ship length, you know all the spots are free for the ship
                    }//if counter ≠ shiplength, this while loop happens again. The ship gets a new randomized position
                } 
            }

            //For loop to actually fill the field with ship
            for (int i = 0; i < length; i++){
                solutionBoard[placementX][placementY - i] = displayCharacter;
                }

            //stores ship placement. shipOrder parameter is just to be able to log multiple ship locations in same array
            positionStoring[shipOrder][0] = placementX;
            positionStoring[shipOrder][1] = placementY;
        
            }

        //same thing but for vertical ship placement
        else if (horizontalOrVertical == 0){
            int placementX = 0;
            int placementY = 0;
    
            while (counter!=length){
                counter = 0;
                placementX = rand.nextInt(10-length-1) + length - 1;
                placementY = rand.nextInt(10);

                for (int i = 0; i < length; i++){
                    if (solutionBoard[placementX - i][placementY] == '-'){
                        counter++;
                        System.out.println(solutionBoard[placementX - i][placementY]);
                    }
                }

            }
            for (int i = 0; i < length; i++){
                solutionBoard[placementX - i][placementY] = displayCharacter;
                }

            positionStoring[shipOrder][0] = placementX;
            positionStoring[shipOrder][1] = placementY;

            }
        

    }


    int numberOfMissilesFired = 0;
    int numberOfTimesHit = 0;
    int numberOfShipsSunk = 0;


    int shipsSunk[] = {5, 4, 3, 2, 2};//this array's elements count down when a specific ship is hit
    


    //firing missiles at ships
    public void fire(int x, int y){

        //ensures that shot is within the board
        if (x>9 || x<0 || y>9 || y<0) {
            System.out.println("Your shot misses since it's outside the board");
        }

        //if it hits a ship:
        else if (solutionBoard[x][y] == 'A' || solutionBoard[x][y] == 'B' || solutionBoard[x][y] == 'C' || solutionBoard[x][y] == 'D'){
            gameBoard[x][y] = 'X';
            System.out.println("Hit!");
            numberOfTimesHit++;
            
            //depending on which ship is hit, the shipSunk array element decreases. when array element is 0, it corresponds to a ship that's completely sunk
            if (solutionBoard[x][y] == 'A'){
                shipsSunk[0]--;//shipsSunk[0] = 5. so if aircraft gets hit 5 times, shipsSunk[0] = 0, which registers the ship to have completely sunk
            }
            else if (solutionBoard[x][y] == 'B'){
                shipsSunk[1]--;//same for battleship
            }
            else if (solutionBoard[x][y] == 'C'){
                shipsSunk[2]--;//and cruiser
            }

        }

        //if missile hits nothing
        else{
            gameBoard[x][y] = 'O';
        }

        numberOfMissilesFired++;

    }

}