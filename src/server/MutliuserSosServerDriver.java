package server;
import java.util.Scanner;
public class MutliuserSosServerDriver {

    public static void main(String[] args) {
        //SosBoard board = new SosBoard(3, 3);
        //System.out.println(board.drawBoard());
        Scanner in = new Scanner(System.in);

        int player1= 0;
        int player2= 0;


        Game game = new Game();
        SosBoard board = new SosBoard(game.getBoard());
        //board.drawBoard();
        //game.viewer();
        /* CODE TO VIEW ELEMENETSfor (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {


                System.out.println("These are ele" + board.getBoard()[i][j]);
            }
        }*/
        game.whosTurnAndScore();
       //System.out.println(board.getBoard());
        //System.out.println(game.getBoard());
        //System.out.println(board.drawBoard());
        //System.out.println(board.drawBoard());
        //System.out.println(board.drawBoard(3, 3));
    }
}
