import java.util.Scanner;  // Import the Scanner class
/*TODO
update
checkForWin
*/

public class Main {
    
    // makes the grid
    static String[][] setUp() {
        //This sets up the grid, first row, then collum.
        String[][] grid = {
            {"_", "_", "_", "_", "_", "_", "_"}, 
            {"_", "_", "_", "_", "_", "_", "_"}, 
            {"_", "_", "_", "_", "_", "_", "_"}, 
            {"_", "_", "_", "_", "_", "_", "_"}, 
            {"_", "_", "_", "_", "_", "_", "_"}, 
            {"_", "_", "_", "_", "_", "_", "_"}};

        
        return grid;
    }

    //prints the grid with spaces in between each character
    static void output(String[][] grid){
        
        for (int i = 0; i < grid.length; ++i) {
            String total = "";
            for(int j = 0; j < grid[i].length; ++j) {
                total+=grid[i][j] + " ";
            }
            System.out.println(total);
        }
    }

    // takes the user input
    static int[] input(Scanner userInput){
        // takes both user inputs

        // User inputs, takes row and collum for each player
        System.out.println("Player 1, input location, with a number for a row. Example: 1");
        int player1Row = userInput.nextLine();
        
        System.out.println("Player 1, input location, with a number for a row. Example: 1");
        int player2Row = userInput.nextLine();
        
        // the array that the values will be returned in
        // This also takes care of dealing with index 0 stuff
        int[] returnedVal = {player1Row-1, player2Row-1};
        return returnedVal;
    }

    //takes the return from input and updates the grid with it
    static String[][] updateGrid(String[][] grid, int[] playerRows){

        //goes through all the collums to find the bottom
        for(int i = 0; i < grid.length; i++){
            if(grid[i][playerRows[0]]!="_"){
                grid[i-1][playerRows[0]] = "O";
            }
        for(int i = 0; i < grid.length; i++){
            if(grid[i][playerRows[1]]!="_"){
                grid[i-1][playerRows[1]] = "X";
        
            }    
        }

        return String[][]grid;
    }

    // looks through grid for 4 in a row
    static String checkForWin(String[][] grid){}

    // recursively calls itself till the game is over
    static void gameLoop(String[][] grid, Scanner userInput){


        // takes the player input
        int[] playerRows = input(userInput);

        output(grid);
    }

    public static void main(String[] args) {
        
        // the function that makes the grid
        String[][] grid = setUp();

        //makes the user input object
        Scanner userInput = new Scanner(System.in);

        //starts the recursive game loop
        gameLoop(grid, userInput);
    }
}
