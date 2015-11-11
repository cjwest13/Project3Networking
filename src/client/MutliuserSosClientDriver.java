package client;

import java.io.IOException;
import java.net.Inet4Address;
import java.net.InetAddress;

/**
 * Created by cjwest on 11/10/15.
 */
public class MutliuserSosClientDriver {
    /**This is the max number of arguments*/
    private static final int MAX_ARGS = 3;
    /**
     * This is a usage statement that will be used if the input is wrong on the
     * terminal
     */
    private static void usage() {
        System.out.println("usage: java MutliuserSosClientDriver " +
                "<hostname|IP> <port#> username");
    }

    /**Main method that will be used to check the arguments and start up
     * the UDP and TCP clients for Chargen
     * @param args - <hostname|IP> <port#> username
     */
    public static void main(String[] args) {
        if (args.length > MAX_ARGS || args.length < MAX_ARGS) {
            usage();
            System.exit(1);
        }
        try {
            String hostname = args[0];
            int port = Integer.parseInt(args[1]);
            String username = args[2];
            InetAddress host = InetAddress.getByName(hostname);

            MultiuserSosClient client = new MultiuserSosClient(host, port, username);
        } catch (NumberFormatException nfe) {
            System.out.println("The port has to be a number.");
            System.exit(1);
        } catch (IOException ioe) {
            System.out.println("Error while connecting to the host");
            System.exit(1);
        }

    }
}