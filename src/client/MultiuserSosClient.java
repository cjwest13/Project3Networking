package client;

import common.MessageListener;
import common.MessageSource;
import common.NetworkInterface;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetAddress;
import java.net.Socket;

/**
 * Created by cjwest on 11/8/15.
 */
public class MultiuserSosClient implements MessageListener {
    private InetAddress host;
    private int port;
    private String username;
    private NetworkInterface talk;

    public MultiuserSosClient(InetAddress host, int port, String username) {
        this.host = host;
        this.port = port;
        this.username = username;
        talk = new NetworkInterface();
    }

    public void start() {
        try {
            Socket socket = new Socket(host, port);
            socket.setSoTimeout(7000);
            //sends "/connect" with username immediately after it connects
            DataOutputStream output = new DataOutputStream(socket.getOutputStream());
            BufferedReader input = new BufferedReader(new InputStreamReader(socket.getInputStream()));


        } catch (IOException ioe) {
            System.out.println("Error while making connection");
        }
    }


    public void messageReceived(String message, MessageSource source) {
    }

    public void sourceClosed(MessageSource source) {
    }
}