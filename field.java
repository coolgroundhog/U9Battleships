import java.util.Random;
import java.util.Scanner; 

public class field {

    static int boardSize = 10;
    static char[][] gameBoard = new char[boardSize][boardSize];
    static char [][] solutionBoard = new char[boardSize][boardSize];
    
    public static void fillBoard(char [][] map){
        for(int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				map[i][j] = '-';
			}
		}
    }

    public static void printBoard(){
        
        System.out.print("  ");
        for(int a = 0; a < 10; a++){
            System.out.print(a + " ");
        }
        System.out.println();


        for(int i = 0; i < boardSize; i++) {
            System.out.print(i + " ");
            
            for (int j = 0; j < boardSize; j++) {
				System.out.print(gameBoard[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

/*
    public static void implementDestroyer(){
        Random rand = new Random();
        int destroyerPlacementX = rand.nextInt(10);
        int destroyerPlacementY = rand.nextInt(10);

        gameBoard[destroyerPlacementX][destroyerPlacementY] = 'D';


        if (gameBoard[destroyerPlacementX + 1][destroyerPlacementY] == '-'){
            gameBoard[destroyerPlacementX + 1][destroyerPlacementY] = 'D';
        }
        else if (gameBoard[destroyerPlacementX - 1][destroyerPlacementY] == '-'){
            gameBoard[destroyerPlacementX - 1][destroyerPlacementY] = 'D';
        }
        else if (gameBoard[destroyerPlacementX][destroyerPlacementY + 1] == '-'){
            gameBoard[destroyerPlacementX][destroyerPlacementY + 1] = 'D';
        }
        else if (gameBoard[destroyerPlacementX][destroyerPlacementY -1] == '-'){
            gameBoard[destroyerPlacementX][destroyerPlacementY -1] = 'D';
        }
    }

        */

    static Random rand = new Random();
    public static void implementCruiser(){

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

    public static void placeShip(char displayCharacter, int length){
        Random rand = new Random();

        int horizontalOrVertical = rand.nextInt(2);

        if (horizontalOrVertical == 1){
            int placementX = rand.nextInt(10);
            int placementY = rand.nextInt(8) + length - 1;

            int counter = 0;

            for (int i = 0; i < length; i++){
                if (solutionBoard[placementX][placementY - i] == '-'){
                    solutionBoard[placementX][placementY - i] = displayCharacter;
                }
                else {
                    
                }
            }
        }

        else if (horizontalOrVertical == 0){
            int placementX = rand.nextInt(8) + length - 1;
            int placementY = rand.nextInt(10);

            for (int i = 0; i < length; i++){
                solutionBoard[placementX - i][placementY] = displayCharacter;
            }
        }

    }


    static int numberOfMissilesFired = 0;
    static int numberOfTimesHit = 0;
    static int numberOfShipsSunk = 0;
    static int hitRatio = 0;

    public static void fire(int x, int y){

        if (x>9 || x<0 || y>9 || y<0) {
            System.out.println("Your shot misses since it's outside the board");
        }
        else if (solutionBoard[x][y] == 'A' || solutionBoard[x][y] == 'B' || solutionBoard[x][y] == 'C' || solutionBoard[x][y] == 'D'){
            gameBoard[x][y] = 'X';
            System.out.println("Hit!");
            numberOfTimesHit++;
        }
        else{
            gameBoard[x][y] = 'O';
        }

        numberOfMissilesFired++;

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
        Scanner input = new Scanner(System.in);
        
        fillBoard(gameBoard);
        fillBoard(solutionBoard);


        placeShip('A', 5);
        placeShip('B', 4);
        placeShip('C', 3);
        placeShip('D', 2);
        placeShip('D', 2);

        printBoard();

        while (1==1){
            String userInput = input.nextLine();
            if (userInput.startsWith("fire")){

                System.out.print("X coordinate: ");
                int xCoordinate = input.nextInt();


                System.out.print("Y coordinate: ");
                int yCoordinate = input.nextInt();

                fire(xCoordinate, yCoordinate);

                printBoard();

            }


            else if (userInput.equals("help")){
                System.out.println("Possible commands: \n view board - displays the user’s board\nview ships - displays the placement of the ships\nfire - fires a missile at chosen cell\nstats - prints out the game statistics\nquit - exits the game");
            }

            else if (userInput.equals("stats")){
                System.out.println("Number of missiles fired: " + numberOfMissilesFired);
                System.out.println("Hit ratio: " + hitRatio);
                System.out.println("Number of ships sunk:" + numberOfShipsSunk);
            }
        }



    }
}
