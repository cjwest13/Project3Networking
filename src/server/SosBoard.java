package server;

/**
 * Created by cjwest on 11/8/15.
 */
public class SosBoard {
    private String[][] board;
    public SosBoard(String[][] board) {
        this.board = board;
    }

    public String drawBoard() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < board[0].length; i++) {
            string.append("\t  " + i);
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

    public String[][] getBoard() {
        return board;
    }
}
