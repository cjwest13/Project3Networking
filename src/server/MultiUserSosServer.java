package server;

import client.MultiuserSosClient;
import common.MessageListener;
import common.MessageSource;

import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by cjwest on 11/10/15.
 */
public class MultiUserSosServer implements MessageListener {
    private int port;

    public MultiUserSosServer(int port) {
        this.port = port;
    }

    public void listen() {
        try {
            ServerSocket server = new ServerSocket(port);
            Socket connection = server.accept();
        } catch (Exception e) {

        }

    }

    public void checkCommands(String command) {
            if (command.equals("/connect")) {
                //sends
            } else if(command.equals("/play")) {
                //sent by clients to play sos
                //cant not begin until 2 or more players connected
            } else if(command.equals("/move")) {
                //mooovee around on board
                // [sS|oO] [0-9]+ [0-9]+
            } else if (command.equals("/quit")) {

            }
    }

    public void messageReceived(String message, MessageSource source){}
    public void sourceClosed(MessageSource source){}
}
