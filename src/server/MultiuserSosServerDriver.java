package server;
import java.util.Scanner;
public class MultiuserSosServerDriver {
    private static final int DEFAULT_PORT = 8888;
    private static final int MAX_ARGS = 2;

    private static void usage() {
        System.out.println("Usage: java MultiSosServerDriver [port#] [size#]");
    }
    public static void main(String[] args) {
        //Scanner in = new Scanner(System.in);
        int port = DEFAULT_PORT;
        int size = 3;
        if(args.length < 1 || args.length > MAX_ARGS) {
            usage();
            System.exit(1);
        }
        if(args.length == 1) {
            port = Integer.parseInt(args[0]);
            size = 3;
        } else if(args.length == 2) { //2
            port = Integer.parseInt(args[0]);
            size = Integer.parseInt(args[1]);
        }



    }
}
