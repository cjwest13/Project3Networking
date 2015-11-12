package server;
import java.util.Scanner;
/**
 * Created by cjwest on 11/8/15.
 * NOTE : Possibly put the if i = 0 and if i = 1 in move function around
 * the junk inside the while might fix the problem and possibly change isWinner
 * to a if statement inside the i = 0 statement
 */
public class Game {
    private String[][] board;
    private SosBoard b;
    private int player0;
    private int player1;
    private int length;
    int j = -1;
    int k = -1;
    int l = -1;
    int m = -1;

    public Game () {
        this.board = new String[3][3];
        this.b = new SosBoard(getBoard());
        this.player0 = 0;
        this.player1 = 0;
        this.length = board.length * board[0].length;
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = " ";
            }
        }
    }

    public void move() {
        Scanner input = new Scanner(System.in);
        System.out.println("Player 0 : " + this.player0);
        System.out.println("Player 1 : " + this.player1);
        System.out.println();
        System.out.println("______________________________");
        System.out.println("Please enter a row num");
        int row = input.nextInt();
        System.out.println("Please enter a column num");
        int col = input.nextInt();
        input.nextLine();
        System.out.println("Enter S or O: ");
        String result = input.nextLine();
        if(board[row][col].equals("S") || board[row][col].equals("O")) {
            System.out.println("BITCH WHO SAID YOU CAN CHEAT?");
        } else {
            System.out.println("IM OVA HERE BITCH");
            board[row][col] = result;
        }
        System.out.println(b.drawBoard());
    }

    public void play() {
        int playerTurn = 0;
        System.out.println(b.drawBoard());
        while(isEmpty()) {
            playerTurn = playerTurn%2;
            System.out.println("Player " + playerTurn%2 + "'s turn");
            if(playerTurn == 0) {
                move();
                if(isWinner()) {
                    player0++;
                }
            } else if (playerTurn == 1) {
                move();
                if(isWinner()) {
                    player1++;
                }
            }
            playerTurn++;
        }
        System.out.println("Final Score!");
        System.out.println("Player 0: " + player0 );
        System.out.println("Player 1: " + player1 );


    }

    public boolean isWinner() {
        boolean result = false;
        boolean row = false;
        boolean col = false;
        boolean diagonal1 = false;
        boolean diagonal2 = false;


        //Check the row
        for(int i = 0; i<board[0].length; i++) {
            if(board[i][0].equals("S") && board[i][1].equals("O") &&
                    board[i][2].equals("S")) {
                if (j == -1 ) {
                    result = true;
                    j = i;
                    System.out.println("Row WIN!");
                    return result;
                } else if (j == i || k == i) {
                    break;
                } else {
                    result = true;
                    k = i;
                    System.out.println("Row WIN!");
                    return result;
                }
            }
        }
        //Check Col
        for(int i = 0; i<board.length; i++) {
            if(board[0][i].equals("S") && board[1][i].equals("O") &&
                    board[2][i].equals("S")) {
                if (l == -1 ) {
                    result = true;
                    l = i;
                    System.out.println("COl WIN!");
                    return result;
                } else if (l == i || m == i) {
                    break;
                } else {
                    result = true;
                    m = i;
                    System.out.println("Col WIN!");
                    return result;
                }
                //result = true;
               // System.out.println("Col win");
                //return result;
            }
        }
        //Check for diagonal left to right
        if(board[0][0].equals("S") && board[1][1].equals("O") &&
                board[2][2].equals("S")) {
            result = true;
            System.out.println("FIrst Col win");
            return result;
        }
        //CHeck for second diagonal right to left
        if(board[0][2].equals("S") && board[1][1].equals("O") &&
                board[2][0].equals("S")) {
            result = true;
            System.out.println("Second Col win");
            return result;
        }
        return result;
    }

    public boolean isEmpty() {
        boolean result = false;
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == " ") {
                    result = true;
                //} else if(board[i][j] != " ") {

                }
            }
        }
        return result;
    }


    public String[][] getBoard() {
        return board;
    }
}
