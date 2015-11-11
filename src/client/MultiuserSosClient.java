package client;

import common.MessageListener;
import common.MessageSource;

import java.net.InetAddress;

/**
 * Created by cjwest on 11/8/15.
 */
public class MultiuserSosClient implements MessageListener {
    private InetAddress host;
    private int port;
    private String username;

    public MultiuserSosClient(InetAddress host, int port, String username) {
        this.host = host;
        this.port = port;
        this.username = username;
    }


    public void messageReceived(String message, MessageSource source){}
    public void sourceClosed(MessageSource source){}

}
