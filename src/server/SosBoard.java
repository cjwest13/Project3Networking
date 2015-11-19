package server;

/**
 * This is the class that will contain the drawn board for the game
 * depending on the size
 * @author Tommy Ho & Clifton West
 * @version 11/18/2015
 */

public class SosBoard {
    /**This is the 2d array that will be used in order to draw the board*/
    private String[][] board;

    /**
     * This is the constructor that will be used in order to give
     * the Game class a board to put things on
     * @param board - This will be a parameter used by the Game class
     *                in order to put the board for Game to use
     */
    public SosBoard(String[][] board) {
        this.board = board;
    }

    /**
     * This is the method that will be used in order to draw the
     * board using the StringBuilder class
     * @return string.toString() - used to print out the contents
     *         of the board
     */
    public String drawBoard() {
        StringBuilder string = new StringBuilder();
        string.append("\t  " + 0);
        for (int i = 1; i < board[0].length; i++) {
            string.append("    " + i);
        }
        string.append("\n\t"); 
        for (int i = 0; i < board[0].length; i++) {
            string.append("+---");
        }
        string.append("+\n");

        for (int i = 0; i < board.length; i++) {
            string.append(i+"\t");
            for (int j = 0; j < board[0].length; j++) {
                string.append("|  " + board[i][j]);
            }
            string.append("|\n\t");
            for (int k = 0; k < board[0].length; k++) {
                string.append("+---");
            }
            string.append("+\n");
        }
        return string.toString();
    }

    /**
     * Getter method that is used in order to get the board
     * for other classes
     * @return - this.board - this is the board used to
     *                        put elements in
     */
    public String[][] getBoard() {
        return board;
    }
}
