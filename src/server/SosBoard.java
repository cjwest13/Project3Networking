package server;

/**
 * Created by cjwest on 11/8/15.
 */
public class SosBoard {
    public String drawBoard() {
        String[][] board = new String[3][3];
        for(int col=0; col<board[0].length; col++)
        {
            for(int row=0; row<board.length; row++)
            {
                board[col][row] = "\t";
                //your code to access display[row][col]
            }
        }
        StringBuilder string = new StringBuilder("Game Board\n");
        string.append("\t\t0\t1\t2\n");
        string.append("\t+---+----+----+\n");
        for (int i = 0; i < 3; i++) {
            string.append(i+"\t");
            for (int j = 0; j < 3; j++) {
                string.append("[" + board[i][j] + "]");
            }
            string.append("\n");
        }
        return string.toString();
    }
}
