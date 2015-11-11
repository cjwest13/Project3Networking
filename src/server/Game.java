package server;
import java.util.Scanner;
/**
 * Created by cjwest on 11/8/15.
 */
public class Game {
    private String[][] board;
    private SosBoard b;
    private int player1;
    private int player2;

    public Game () {
        this.board = new String[3][3];
        this.b = new SosBoard(getBoard());
        this.player1 = 0;
        this.player2 = 0;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
    }

    public void move() {
        Scanner input = new Scanner(System.in);
        System.out.println(b.drawBoard());
        while (isFull()) {
            System.out.println("Please enter a row num");
            int row = input.nextInt();
            System.out.println("Please enter a column num");
            int col = input.nextInt();
            input.nextLine();
            System.out.println("Enter S or O: ");
            String result = input.nextLine();
            board[row][col] = result;
            System.out.println(b.drawBoard());
        }
    }



    public boolean isFull() {
        boolean result = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == " ")
                    result = true;
            }
        }
        return result;
    }



    public String[][] getBoard() {
        return board;
    }
}
