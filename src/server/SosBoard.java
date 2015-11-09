package server;

/**
 * Created by cjwest on 11/8/15.
 */
public class SosBoard {
    private String[][] board;
    public String drawBoard(int row, int col) {
        board = new String[row][col];
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                board[i][j] = "\t";
            }
        }
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < col; i++) {
            string.append("\t  " + i);
        }
        string.append("\n\t");
        for (int i = 0; i < col; i++) {
            string.append("+---");
        }
        string.append("+\n");

        for (int i = 0; i < row; i++) {
            string.append(i+"\t");
            for (int j = 0; j < col; j++) {
                string.append("|" + board[i][j]);
            }
            string.append("|\n\t");
            for (int k = 0; k < col; k++) {
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
