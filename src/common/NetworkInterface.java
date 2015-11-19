package common;

import server.Game;

/**
 * Created by cjwest on 11/10/15.
 */
public class NetworkInterface extends MessageSource implements Runnable {
    private int count;
    private int size;
    public NetworkInterface() {
    }

    public void talkToServer() {

    }

    public void talkToClient() {

    }

    public void run() {
        //addMessageListener("hi");

    }

    public void commands() {
        //int data = in.read();
        //String aData = (String) data;
        this.count = 0;
        //Not surewhile(server.isClosed()) {
            //if (aData.equals("/connect" +)) {
            //    count ++;
            //}
        //}

        //if (aData.equals("/play")) {
          //  if(count >=2) {
            //    Game game = new Game(size, count);
              //  game.play();
            //}
        //}

        //if(aData.equals("/move")) {

        //}

        //if(aData.equals("/quit")) {
          //  socket.close();

        //}


    }

}
