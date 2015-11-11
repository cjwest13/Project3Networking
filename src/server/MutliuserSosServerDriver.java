package server;

public class MutliuserSosServerDriver {

    public static void main(String[] args) {
        //SosBoard board = new SosBoard(3, 3);
        //System.out.println(board.drawBoard());
        Game game = new Game();
        game.viewer();
        SosBoard board = new SosBoard(game.getBoard());
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {

                System.out.println(board.getBoard()[i][j]);
            }
        }
       //System.out.println(board.getBoard());
        //System.out.println(game.getBoard());
        //System.out.println(board.drawBoard());
        System.out.println(board.drawBoard());
        //System.out.println(board.drawBoard(3, 3));
    }
}
