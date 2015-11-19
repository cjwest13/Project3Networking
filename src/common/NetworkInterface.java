package common;

import server.MultiUserSosServer;
import java.io.*;
import java.net.Socket;
import java.util.ArrayList;


/**
 * This class allows that the Clients and the Server to talk to one another.
 * @author Tommy Ho & Clifton West
 * @version 11/5/2015
 */
public class NetworkInterface extends MessageSource implements Runnable {
    /** Socket used for communicating between socket and client */
    private Socket socket;
    /** The buffered reader for the socket's input stream */
    private BufferedReader in;
    /** The PrintStream for the socket's output stream */
    private PrintStream out;

    /**
     * The constructor fo the NetworkInterface class
     * @param socket        Socket used for communicating between socket and client
     * @throws IOException  IOExpection
     */
    public NetworkInterface(Socket socket) throws IOException {
        this.socket = socket;
        in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        out = new PrintStream(socket.getOutputStream(), true);
    }

    /**
     * Run method for the threading.
     */
    public void run() {
       try {
           String msg;
           while ((msg = in.readLine()) != null) {
               String command = checkCommands(msg);
               if (command == null) {
                   out.println("--->" + command);
                   break;
               }
               out.println("--->" + command);
           }
           in.close();
           out.close();
           socket.close();
        } catch (IOException ioe) {}
    }

    /**
     * Method to check the commands of the user input.
     * @param msg   String that contains the input message of the user.
     * @return      String that contains the output of the command
     */
    public String checkCommands(String msg) {
        String[] msgSplit = msg.trim().split(" ");
        String command = "";
        command = msgSplit[0].trim();
        ArrayList<String> usernames = MultiUserSosServer.getUsernames();
        if (command.equals("/connect")) {
            String username = msgSplit[1].trim();
            if (usernames.isEmpty()) {
                MultiUserSosServer.usernames.add(username);
                 return "Welcome! " + username;
            } else {
                for (String user: usernames) {
                    if (user.equals(username)) {
                        username = username + "1";
                    }
                }
                MultiUserSosServer.usernames.add(username);
                return "Welcome! " + username;
            }
        } else if(command.equals("/play")) {
            if (usernames.size() <= 1) {
                return "Not enough players to play the game";
            } else {
                return "TIME TO PLAY THE GAMEEE MUHAAAAA";
            }
        } else if(command.equals("/move")) {
            if (usernames.size() <= 1) {
                return "cant move bro";
            } else {
                return "time to move!";
            }
        } else if (command.equals("/quit")) {
            return "Bye";
        } else {
            return "Not a proper command";
        }
    }
}
