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
    private int rowj = -1;
    private int rowk = -1;
    private int colj = -1;
    private int colk = -1;
    private boolean diagonal1 = false;
    private boolean diagonal2 = false;

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
        while(row > board.length) {
            System.out.println("Not valid man try again.");
            System.out.println("Please enter a row num");
            row = input.nextInt();
        }
        System.out.println("Please enter a column num");
        int col = input.nextInt();
        while(col > board[0].length) {
            System.out.println("Not valid man try again.");
            System.out.println("Please enter a column num");
            col = input.nextInt();
        }
        input.nextLine();
        System.out.println("Enter S or O: ");
        String res = input.nextLine();
        String result = res.toUpperCase().trim();
        if(!result.equals("S") && !result.equals("O") ) {
            System.out.println("YOU HAVE INPUTTED SOMETHING ELSE BESIDES S AND O....BITCH");
        } else if(board[row][col].equals("S") || board[row][col].equals("O")) {
            System.out.println("BITCH WHO SAID YOU CAN CHEAT?");
        } else {
            board[row][col] = result.toUpperCase();
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


        //Check the row
        for(int i = 0; i<board[0].length; i++) {
            if(board[i][0].equals("S") && board[i][1].equals("O") &&
                    board[i][2].equals("S")) {
                if (rowj == -1 ) {
                    result = true;
                    rowj = i;
                    System.out.println("Row WIN!");
                    return result;
                } else if (rowj == i || rowk == i) {
                    continue;
                } else {
                    result = true;
                    rowk = i;
                    System.out.println("Row WIN!");
                    return result;
                }
            }
        }
        //Check Col
        for(int i = 0; i< board.length; i++) {
            if(board[0][i].equals("S") && board[1][i].equals("O") &&
                    board[2][i].equals("S")) {
                if (colj == -1) {
                    result = true;
                    colj = i;
                    System.out.println("Col WIN!");
                    return result;
                } else if (colj == i || colk == i) {
                    continue;
                } else {
                    result = true;
                    colk = i;
                    System.out.println("Col WIN!");
                    return result;
                }
            }
        }
        //Check for diagonal left to right
        if((board[0][0].equals("S") && board[1][1].equals("O") &&
                board[2][2].equals("S")) && !diagonal1) {
            result = true;
            diagonal1 = true;
            System.out.println("FIrst Diagonal win");
            return result;
        }
        //Check for second diagonal right to left
        if((board[0][2].equals("S") && board[1][1].equals("O") &&
                board[2][0].equals("S")) && !diagonal2) {
            result = true;
            diagonal2 = true;
            System.out.println("Second Diagonal win");
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
                }
            }
        }
        return result;
    }


    public String[][] getBoard() {
        return board;
    }
}
