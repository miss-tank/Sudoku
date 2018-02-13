# CS342_Project3

Sudoku is a logic-based, combinatorial number-placement puzzle. The objective is to fill a 9×9 grid with digits
so that each column, each row, and each of the nine 3×3 sub grids that compose the grid (also called "boxes",
"blocks", or "regions") contains all of the digits from 1 to 9. The puzzle setter provides a partially completed
grid, which for a well-posed puzzle has a single solution.

The purpose of this project is to help the user solve a sudoku game. Users are provided with hints if they are
having a hard time moving forward with the game.  There are various functions and algorithms included in the
game. 

The algorithms in the game are: Single Alg, Hidden Alg, Naked Pair Alg, Locked Candidate Alg.
This project includes 6 classes :

Cell.java
This class contains information about a cell’s value and whether it is an original value in the puzzle.

Grid.java
This class consists of a 9x9 grid of cells and a 9x9 grid of candidate values for those cells.

GameView.java
This class makes the front end GUI of the project and includes tiles, buttons, and menu options. It’s purpose is
to display information and receive user input.

GamePresenter.java
This class handles actions passed to it from GameView by consulting the model and updating the GameView with the
result.

GameModel.java
This is a simple class which creates the instance of the grid each time it is updated. It also supports the
functionality of getting the status of the board.

Sudoku.java	
This class contains the main method of the project. It instantiates the GameView and GamePresenter.
