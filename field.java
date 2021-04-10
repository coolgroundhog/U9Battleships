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
        printBoard();
    }
}
