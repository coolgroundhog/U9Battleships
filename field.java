import java.util.Random;

public class field {

    static int boardSize = 10;
    static char[][] gameBoard = new char[boardSize][boardSize];
    
    public static void fillBoard(){
        for(int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				gameBoard[i][j] = '-';
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

        
    public static void implementCruiser(){
        Random rand = new Random();

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

            for (int i = 0; i < length; i++){
                gameBoard[placementX][placementY - i] = displayCharacter;
            }
        }

        else if (horizontalOrVertical == 0){
            int placementX = rand.nextInt(8) + length - 1;
            int placementY = rand.nextInt(10);

            for (int i = 0; i < length; i++){
                gameBoard[placementX - i][placementY] = displayCharacter;
            }
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
        fillBoard();
        implementDestroyer();
        //implementCruiser();

        placeShip('C', 3);

        printBoard();
    }
}
