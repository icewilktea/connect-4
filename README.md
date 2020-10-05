# connect-4
This is a txt based connect 4 game


methods:

    setup():
        makes a two dimensional string array called grid.
        The first index is the row, the second is the collum.
        
    input():
        takes input from the players and returns them in an array.
        
    output():
        prints the grid, with spaces added in between each item.
    
    checkForWin():
        looks through grid for a four in a row.
        
    update():
        Uses the returned value from input() to update the grid.
        
    gameLoop():
        runs input, output, update, and check for win. It is a 
        recursive method that reccurses every turn
