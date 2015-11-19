package client;

import java.io.IOException;
import java.io.PrintStream;
import java.net.InetAddress;

/**
 * The TCP client driver.
 * @author Tommy Ho & Clifton West
 * @version 11/5/2015
 */
public class MultiUserSosClientDriver {
    /**This is the max number of arguments*/
    private static final int MAX_ARGS = 3;

    /** String containing the username entered */
    private static String username;
    /**
     * This is a usage statement that will be used if the input is wrong on the
     * terminal
     */
    private static void usage() {
        System.out.println("usage: java MultiUserSosClientDriver " +
                "<hostname|IP> <port#> username");
    }

    /**Main method that will be used to check the arguments and start up
     * the UDP and TCP clients for Chargen
     * @param args - <hostname|IP> <port#> username
     */
    public static void main(String[] args) {
        if (args.length < 2 || args.length > MAX_ARGS) {
            usage();
            System.exit(1);
        }
        try {
            String hostname = args[0];
            int port = Integer.parseInt(args[1]);
            username = args[2];
            InetAddress host = InetAddress.getByName(hostname);
            PrintStream print = new PrintStream(System.out);
            System.setOut(print);
            MultiUserSosClient client = new MultiUserSosClient(host, port, username);
            client.printToStream(print);
        } catch (NumberFormatException nfe) {
            System.out.println("The port has to be a number.");
            System.exit(1);
        } catch (IOException ioe) {
            System.out.println("Error while connecting to the host");
            System.exit(1);
        } catch (Exception e) {
        System.out.println("Server closed");
        System.exit(1);
        }
    }

    /**
     *
     * @return username The username selected.
     */
    protected static String getUsername() {
        return username;
    }
}