 import static java.lang.System.out;

import java.util.Scanner; // Import the Scanner class
/*TODO
update
checkForWin
*/

public class Main {

    // makes the grid
    static int gameOver = 0;
    static String[][] setUp() {
        // This sets up the grid, first row, then collum.
        String[][] grid = { { "_", "_", "_", "_", "_", "_", "_" }, { "_", "_", "_", "_", "_", "_", "_" },
                { "_", "_", "_", "_", "_", "_", "_" }, { "_", "_", "_", "_", "_", "_", "_" },
                { "_", "_", "_", "_", "_", "_", "_" }, { "_", "_", "_", "_", "_", "_", "_" } };

        return grid;
    }

    // prints the grid with spaces in between each character
    static void output(String[][] grid) {

        for (int i = 0; i < grid.length; ++i) {
            String total = "";
            for (int j = 0; j < grid[i].length; ++j) {
                total += grid[i][j] + " ";
            }
            System.out.println(total);
        }
    }

    // takes the user input
    static int[] input(Scanner userInput) {
        // takes both user inputs
        out.println("column number can be from 0-6");
        // User inputs, takes row and collum for each player
        out.println("Player 1, input location, with a number for a col Example: 1");
        int player1Row = userInput.nextInt();

        out.println("Player 2, input location, with a number for a col. Example: 1");
        int player2Row = userInput.nextInt();
        
        // the array that the values will be returned in
        // This also takes care of dealing with index 0 stuff
        int[] returnedVal = {player1Row-1, player2Row-1};
        return returnedVal;
    }

    //takes the return from input and updates the grid with it
    static String[][] updateGrid(String[][] grid, int []playerRows){
        int col1 = playerRows[0];
        int col2 = playerRows[1];
        int cnt =0;
        for(int i =grid.length-1;i>=0;i--){
            if(grid[i][col1] == "_") {
                grid[i][col1] = "X";
                if(cnt==3){
                    out.println("Player 1  WON!");
                    gameOver = 1;
                    return grid;
                   
                }
                break;
            }
            else cnt++;

        }
        cnt =0;
        for(int i =grid.length-1;i>=0;i--){
            if(grid[i][col2] == "_") {
                grid[i][col2] = "Y";
                if(cnt==3){
                    out.println("Player 2  WON!");
                    gameOver = 1;
                    return grid;
                }
                break;
            }
            else cnt++;

        }
        return grid;
    }

    // looks through grid for 4 in a row
    // static String checkForWin(String[][] grid){}

    // recursively calls itself till the game is over
    static void gameLoop(String[][] grid, Scanner userInput){


        // takes the player input
        while(gameOver==0){
            int[] playerRows = input(userInput);
            updateGrid(grid, playerRows);
            output(grid);
            gameLoop(grid,userInput);
        }
        
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
