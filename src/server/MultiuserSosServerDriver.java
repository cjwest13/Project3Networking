package server;
import java.io.IOException;
import java.util.Scanner;
public class MultiuserSosServerDriver {
    /**This is the magic number that contains the maximum number of arguments*/
    private static final int MAX_ARGS = 2;
    /** Default Board Size */
    private static final int boardSize = 3;

    /**
     * This is a usage statement that will be used if the input is wrong on the
     * terminal
     */
    private static void usage() {
        System.out.println("usage: java MultiuserSosServerDriver <port#> [size of board] ");
    }

    /**
     * The entry point into the application
     * @param args
     */
    public static void main(String[] args) {
        if (args.length < MAX_ARGS || args.length > MAX_ARGS) {
            usage();
            System.exit(1);
        }
        try {
            int port = Integer.parseInt(args[0]);
            int board = Integer.parseInt(args[1]);
            MultiUserSosServer sos = new MultiUserSosServer(port, board);
            sos.listen();
        } catch (NumberFormatException nfe) {
            System.out.println("The port has to be a number.");
            System.exit(1);
        } catch (IOException ioe) {
            System.out.println("Error while connecting to the host");
            System.exit(1);
        }
    }
}
