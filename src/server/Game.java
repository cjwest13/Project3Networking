package server;
import java.util.Scanner;
import java.util.HashMap;
/**
 * This is the Game class that will contain the logic of the game as well as being able to run the game as well
 *
 * @author Tommy Ho and Clifton West
 * @version 11/18/2015
 *
 */
public class Game {
    /**2D array baord for the SOS board*/
    private String[][] board;
    /**SOS class that contains the drawn board for the game logic*/
    private SosBoard b;
    /**These are used as counters in order to prevent wrong incrementataion in checking win rows*/
    private int rowj = -1;
    /**These are used as counters in order to prevent wrong incrementataion in checking win rows*/
    private int rowk = -1;
    /**These are used as counters in order to prevent wrong incrementation in checking win columns*/
    private int colj = -1;
    /**These are used as counters in order to prevent wrong incrementation in checking win columns*/
    private int colk = -1;
    /**These are used as counters in order to prevent wong incrementation in checking diagonal left to right wins*/
    private boolean diagonal1 = false;
    /**These are used as counters in order to prevent wong incrementation in checking diagonal right to left wins*/
    private boolean diagonal2 = false;
    /**This is the size of the board which will represent sizexsize or 3x3 or 4x4 etc.*/
    private int size;
    /**This is a parameter that will be used to determine how many players the game will have*/
    private int numOfPlayLength;
    /**A HashMap that will hold the players that will be in the game and the score of what the players get*/
    private HashMap<String, Integer> numOfPlayers;
    /**This is the number that will be used in the constructor in order to see what player's turn it is present*/
    int playerNum = 0;

    /**
     * This is the constructor that will hold the
     * @param size - This is the size of dimensions of what the board will be
     * @param numOfPlay - This is the number of players that the game will have in a instance
     */
    public Game (int size, int numOfPlay) {
        this.board = new String[size][size];
        this.b = new SosBoard(getBoard());
        this.size = size;
        this.numOfPlayLength = numOfPlay;
        numOfPlayers = new HashMap<String, Integer>(numOfPlayLength);

        /**This fills up how many players that we have in a HashMap*/
        while(playerNum < numOfPlayLength) {
            numOfPlayers.put("Player " + playerNum, 0);
            playerNum++;
        }

        /**Using the board as it is, this will fill the empty board with empty spaces*/
        for (int i = 0; i < this.size; i++) {
            for (int j = 0; j < this.size; j++) {
                board[i][j] = " ";
            }
        }
    }

    /**
     * This is the play method that will be used to run in order to play the game.
     */
    public void play() {
        int playerTurn = 0;
        int i = 0;
        /**This will be used to draw the board onto the screen*/
        System.out.println(b.drawBoard());

        /**
         * This will run a loop where it will increment through the number of players and then
         * do their move and then check to see if they win a pattern of SOS for the current Player
         * if they have won a pattern, then the current player will get a point for the combo
         */
        while(isEmpty()) {
            playerTurn = playerTurn % this.numOfPlayLength;
            if(playerTurn == i) {
                System.out.println("Player " + playerTurn + "'s turn");
                move();
                if (isWinner()) {
                    numOfPlayers.put("Player " +
                            playerTurn, numOfPlayers.get("Player " + playerTurn)+1);
                }
                i++;
                if(i == this.numOfPlayLength) {
                    i = 0;
                }
            }
            playerTurn++;
        }
        /**This will print the final score onto the screen once the board has been filled*/
        finalScore();
    }

    /**
     * This is the move method that will be used in order to see where the player will place there S or O
     * onto the board.
     */
    public void move() {
        Scanner input = new Scanner(System.in);
        System.out.println(numOfPlayers);
        System.out.println();
        System.out.println("______________________________");
        /**Gets row number from the current player*/
        System.out.println("Please enter a row num");
        int row = input.nextInt();
        /**A check to make sure that it is a valid row number*/
        while(row >= board.length || row < 0) {
            System.out.println("Not valid row number try again.");
            System.out.println("Please enter a row num");
            row = input.nextInt();
        }
        /**Gets the column number from the current player*/
        System.out.println("Please enter a column num");
        int col = input.nextInt();
        /**A check to see if that is a valid column number*/
        while(col >= board[0].length || col < 0) {
            System.out.println("Not valid column number try again.");
            System.out.println("Please enter a column num");
            col = input.nextInt();
        }

        input.nextLine();
        /**This will get either an S or O from the current player*/
        System.out.println("Enter S or O: ");
        String res = input.nextLine();

        /**This will make all letters that are S or O become uppercase even when lower case*/
        String result = res.toUpperCase().trim();

        /**
         *  This will make sure that the player does type a S or O as well as check to make sure
         *  that the current player does not overwrite a S or O that is currently on the board.
         */
        if(!result.equals("S") && !result.equals("O") ) {
            System.out.println("Try again, that is not a S or O");
        } else if(board[row][col].equals("S") || board[row][col].equals("O")) {
            System.out.println("That spot is already filled");
        } else {
            board[row][col] = result.toUpperCase();
        }

        /**Draws the board again*/
        System.out.println(b.drawBoard());
    }

    /**
     * This is a boolean method that will return true or false when checking to see if the current player
     * has a row of SOS a col of SOS a left to right diagonal of SOS and a right to left diagonal of SOS
     * (This is currently broken since there are still bugs within the code)
     * @return result- this returns the result of true or false whether a current player recieved a winning pattern
     */
    public boolean isWinner() {
        boolean result = false;

        /**This is the logic used to check the row for SOS patterns*/
        for(int i = 0; i<board.length; i++) {
            for(int j = 0; j<board.length -2; j++) {
                if (board[i][j].equals("S") && board[i][j + 1].equals("O") &&
                        board[i][j + 2].equals("S") && i < board.length && j < board.length) {
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
        }

        /**This is the logic used to check to see if the column has SOS patterns*/
        for(int i = 0; i< board.length; i++) {
            for(int j = 0; j<board.length ; j++) {
                if ((i < i+2) &&board[i][j].equals("S") && board[i+1][j].equals("O") &&
                        board[i+2][j].equals("S")) {
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
        }

        /**This is used to see if the left to right diagonal has SOS patterns*/
        for(int i = 0; i < board.length-1; i++) {
            if ((board[i][i].equals("S") && board[i+1][i+1].equals("O") &&
                    board[i+2][i+2].equals("S")) && !diagonal1 && i < board.length) {
                result = true;
                diagonal1 = true;
                System.out.println("First Diagonal win");
            }
        }

        /**This is used to see if the right to left diagonal has SOS patterns*/
        for(int i = 0; i < board.length-1; i++) {
            for(int j = board.length -1 ; j >0; j--) { //-1
                if ((board[i][j].equals("S") && board[i+1][j-1].equals("O") &&
                        board[i+2][j-2].equals("S")) && !diagonal2 && i < board.length && j < board.length) {
                    result = true;
                    diagonal2 = true;
                    System.out.println("Second Diagonal win");
                    return result;
                }
            }
        }
        return result;

    }

    /**
     * This is a method that will print out the final scores for the participating players within the game
     */
    public void finalScore() {
        int playerNumber = 0;
        System.out.println("Score:");
        while(playerNumber < this.numOfPlayLength) {
            System.out.println("Player " + playerNumber + " = " +
                    numOfPlayers.get("Player " + playerNumber));
            playerNumber++;
        }
    }

    /**
     * This is a boolean method that will return to see whether the game board was empty or not
     */
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

    /**
     * This is a getter method in order to get the board for other classes
     */
    public String[][] getBoard() {
        return board;
    }

    /**
     * This is the main method that will be used to prompt user
     * for the dimensions of the board and how many players
     * Also this will be used to run the game as well
     * @param args - none
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        System.out.println("Put in the dimension of the board");
        int size = in.nextInt();
        System.out.println("Put how many players in the game");
        int players = in.nextInt();
        Game game = new Game(size, players);
        SosBoard board = new SosBoard(game.getBoard());
        game.play();
    }
}
