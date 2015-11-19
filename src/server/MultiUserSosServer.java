package server;


import common.MessageListener;
import common.MessageSource;
import common.NetworkInterface;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

/**
 * The TCP server.
 * @author Tommy Ho & Clifton West
 * @version 11/5/2015
 */
public class MultiUserSosServer implements MessageListener {
    /** The port number. */
    private int port;
    /** ArrayList to keep the threads in */
    private ArrayList<Thread> threads;
    /**  ArrayList used to keep all of the usernames in */
    public static ArrayList<String> usernames;
    /** Size of the Board */
    private int board;

    /**
     * The constructor fo the MultiUserSosServer class
     * @param port  Port number.
     */
    public MultiUserSosServer(int port, int board) {
        this.port = port;
        threads = new ArrayList<Thread>();
        usernames = new ArrayList<String>();
        this.board = board;

    }

    /**
     * This is the listen method that will activate the listening for connections
     */
    public void listen() throws IOException {
        ServerSocket server = null;
        //is
        try {
            server = new ServerSocket(port);
            Socket connect = null;
            while (!server.isClosed()) {
                connect = server.accept();
                NetworkInterface nf = new NetworkInterface(connect);
                Thread thread = new Thread(nf);
                threads.add(thread);
                thread.start();
                }
            for (Thread thread : threads) {
                thread.join();
            }
            connect.close();
        } catch (InterruptedException ie) {
        } finally {
            server.close();
        }
    }

    /** Get the arraylist of usernames */
    public static ArrayList<String> getUsernames() {
        return usernames;
    }
    /** Receives message from subject */
    public void messageReceived(String message, MessageSource source){
        System.out.println(message);
    }
    /** Receives source closing from subject */
    public void sourceClosed(MessageSource source){}
}
