package server;

public class MutliuserSosServerDriver {

    public static void main(String[] args) {
        SosBoard board = new SosBoard(3, 3);
        //board.drawBoard();
        Game game = new Game(board.getBoard());
        game.viewer();
        //System.out.println(board.drawBoard(3, 3));
    }
}
