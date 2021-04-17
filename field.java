import java.util.Random;
import java.util.Scanner; 

public class field {

    private char[][] gameBoard;
    static char[][] solutionBoard;
    public Ship[] ships;

    /**
     * Instantiate a new Maze object.
     */
    public field() {
        gameBoard = new char[boardSize][boardSize];
        solutionBoard = new char[boardSize][boardSize];
        fillBoard(gameBoard);
        fillBoard(solutionBoard);
    }

    static int boardSize = 10;

    private void fillBoard(char [][] map){
        for(int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				map[i][j] = '-';
			}
		}
    }

    public void printBoard(){
        printBoard(gameBoard);
    }

    public void printSolution(){
        printBoard(solutionBoard);
    }


    public void printBoard(char[][] map){
        
        System.out.print("  ");
        for(int a = 0; a < 10; a++){
            System.out.print(a + " ");
        }
        System.out.println();


        for(int i = 0; i < boardSize; i++) {
            System.out.print(i + " ");
            
            for (int j = 0; j < boardSize; j++) {
				System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    static Random rand = new Random();

    public void implementCruiser(){

        int horizontalOrVertical = rand.nextInt(2);

        System.out.println(horizontalOrVertical);

        if (horizontalOrVertical == 1){
            int destroyerPlacementX = rand.nextInt(10);
            int destroyerPlacementY = rand.nextInt(8) + 2;
            gameBoard[destroyerPlacementX][destroyerPlacementY] = 'C';
            gameBoard[destroyerPlacementX][destroyerPlacementY - 1] = 'C';
            gameBoard[destroyerPlacementX][destroyerPlacementY - 2] = 'C';
        }

        if (horizontalOrVertical == 0){
            int destroyerPlacementX = rand.nextInt(8) + 2;
            int destroyerPlacementY = rand.nextInt(10);
            gameBoard[destroyerPlacementX][destroyerPlacementY] = 'C';
            gameBoard[destroyerPlacementX - 1][destroyerPlacementY] = 'C';
            gameBoard[destroyerPlacementX - 2][destroyerPlacementY] = 'C';
        }

    }

    public static int[][] positionStoring = new int[5][2];

    public static void placeShip(char displayCharacter, int length, int shipOrder){
        
        Random rand = new Random();

        int horizontalOrVertical = rand.nextInt(2);

        int counter = 0;

        if (horizontalOrVertical == 1){

            int placementX = 0;
            int placementY = 0;

            while (counter!=length){
                counter = 0;

                placementX = rand.nextInt(10);
                placementY = rand.nextInt(10-length-1) + length - 1;
    
                for (int i = 0; i < length; i++){
                    if (solutionBoard[placementX][placementY - i] == '-'){
                        //solutionBoard[placementX][placementY - i] = displayCharacter;
                        counter++;
                    }
                } 
                //System.out.println("For " + displayCharacter + ", counter is currently " + counter);
            }

            for (int i = 0; i < length; i++){
                solutionBoard[placementX][placementY - i] = displayCharacter;
                }


            positionStoring[shipOrder][0] = placementX;
            positionStoring[shipOrder][1] = placementY;
        
            }

    
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

            placementX = positionStoring[shipOrder][0];
            placementY = positionStoring[shipOrder][1];

            }
        

    }


    int numberOfMissilesFired = 0;
    int numberOfTimesHit = 0;
    int numberOfShipsSunk = 0;


    int shipsSunk[] = {5, 4, 3, 2};
    



    public void fire(int x, int y){

        if (x>9 || x<0 || y>9 || y<0) {
            System.out.println("Your shot misses since it's outside the board");
        }
        else if (solutionBoard[x][y] == 'A' || solutionBoard[x][y] == 'B' || solutionBoard[x][y] == 'C' || solutionBoard[x][y] == 'D'){
            gameBoard[x][y] = 'X';
            System.out.println("Hit!");
            numberOfTimesHit++;
            

            if (solutionBoard[x][y] == 'A'){
                shipsSunk[0]--;
            }
            else if (solutionBoard[x][y] == 'B'){
                shipsSunk[1]--;
            }
            else if (solutionBoard[x][y] == 'C'){
                shipsSunk[2]--;
            }

        }
        else{
            gameBoard[x][y] = 'O';
        }

        numberOfMissilesFired++;

    }

    public static void countSunkenShips(){
        for(int i = 0; i < boardSize; i++) {

		}
    }

    /*
    static private char[][] myMap;
    private char[][] solution;
    private int row;
    private int col;

    public field() {
        row = 1;
        col = 0;
        myMap = new char[20][20];
        solution = new char[20][20];
        fillMap(myMap);
    }

    private void fillMap(char[][] map) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                map[i][j] = '.';
            }
        }
        myMap[row][col] = 'x';
    }

    private static void printMap(char[][] map) {
        for (int i = 0; i < 20; i++) {
            for (int j = 0; j < 20; j++) {
                System.out.print(map[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    */
    public static void main(String[] args) {
        System.out.println("aDFasdf");
        
        Scanner input = new Scanner(System.in);
        
        fillBoard(gameBoard);
        fillBoard(solutionBoard);


        placeShip('A', 5);
        placeShip('B', 4);
        placeShip('C', 3);
        placeShip('D', 2);
        placeShip('D', 2);

        printBoard(gameBoard);

        int loop = 1;

        while (loop==1){
            String userInput = input.nextLine();
            if (userInput.startsWith("fire")){

                System.out.print("X coordinate: ");
                int xCoordinate = input.nextInt();


                System.out.print("Y coordinate: ");
                int yCoordinate = input.nextInt();

                fire(xCoordinate, yCoordinate);

                printBoard(gameBoard);

            }


            else if (userInput.equals("help")){
                System.out.println("Possible commands: \nview board - displays the user’s board\nview ships - displays the placement of the ships\nfire - fires a missile at chosen cell\nstats - prints out the game statistics\nquit - exits the game");
            }

            else if (userInput.equals("stats")){
                System.out.println("Number of missiles fired: " + numberOfMissilesFired);
                if (numberOfMissilesFired > 0){
                    System.out.println("Hit ratio: " + numberOfTimesHit / numberOfMissilesFired);
                }
                else if (numberOfMissilesFired == 0){
                    System.out.println("Hit ratio: N/A; missles weren't fired");
                }

                for (int i = 0; i<3; i++){
                    if (shipsSunk[i] == 0){
                        numberOfShipsSunk++;
                    }
                }

                System.out.println("Number of ships sunk:" + numberOfShipsSunk);

                for (int i = 0; i<3; i++){
                    System.out.println(shipsSunk[i] + " ");
                }


            }

            else if (userInput.equals("view ships")){
                printBoard(solutionBoard);
            }

            else if (userInput.equals("quit")){
                System.out.println("Bye!");
                loop = 0;
            }

            else {
                System.out.println("Command not found!");
            }


        }



    }
}
