package server;

/**
 * Created by cjwest on 11/8/15.
 */
public class Game {
    private String[][] board;
    public Game (String[][] board) {
        this.board = board;
    }
    public void viewer() {

        //board.drawBoard(3, 3);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                board[i][j] = "haaaaaa";
            }
        }

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.println(board[i][j]);
            }
        }
    }
}
