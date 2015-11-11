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
        System.out.println("Player 1 : " + player1);
        System.out.println("Player 2 : " + player2);
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
            isWinner();
        }
    }

    public void isWinner() {
        //Check the row
        for(int i = 0; i<board[0].length; i++) {
            if(board[i][0].equals("S") && board[i][1].equals("O") &&
                    board[i][2].equals("S")) {
                System.out.println("Row WIN!");
            }
        }

        for(int i = 0; i<board.length; i++) {
            if(board[0][i].equals("S") && board[1][i].equals("O") &&
                    board[2][i].equals("S")) {
                System.out.println("Col win");
            }
        }

        if(board[0][0].equals("S") && board[1][1].equals("O") &&
                board[2][2].equals("S")) {
            System.out.println("FIrst Col win");
        }

        if(board[0][2].equals("S") && board[1][1].equals("O") &&
                board[2][0].equals("S")) {
            System.out.println("Second Col win");
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
