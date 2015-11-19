package client;

import common.MessageListener;
import common.MessageSource;
import common.NetworkInterface;
import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

/**
 * The TCP client.
 * @author Tommy Ho & Clifton West
 * @version 11/5/2015
 */
public class MultiUserSosClient extends MessageSource implements MessageListener {
    private InetAddress host;
    private int port;
    private String username;

    /**
     * The constructor fo the MultiUserSosServer class
     * @param host      holds the hostname
     * @param port      holds the port number
     * @param username  holds the username
     */
    public MultiUserSosClient(InetAddress host, int port, String username) {
        this.host = host;
        this.port = port;
        this.username = username;
    }

    /**
     * The method that
     */
    public void printToStream(PrintStream print) throws Exception {

        String username = MultiUserSosClientDriver.getUsername();
        Socket socket = new Socket(host, port);
        socket.setSoTimeout(7000);
        NetworkInterface nf = new NetworkInterface(socket);
        nf.addMessageListener(this);
        DataOutputStream output = new DataOutputStream(socket.getOutputStream());
        BufferedReader receive = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
        output.writeBytes("/connect " + username + "\n");
        print.println(receive.readLine());
        String in;
        Boolean flag = true;
        while (flag) {
            in = input.readLine();
            output.writeBytes(in + "\n");
            String msg = receive.readLine();
            if (msg.equals("--->Bye")) {
                flag = false;
            }
            print.println(msg);
        }
        output.close();
        receive.close();
        input.close();
        socket.close();
    }

    /** Receives message from subject */
    public void messageReceived(String message, MessageSource source) {
        System.out.println(message);
    }

    /** Receives source closing from subject */
    public void sourceClosed(MessageSource source) {
    }
}