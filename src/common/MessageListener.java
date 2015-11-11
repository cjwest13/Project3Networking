package common;

/**
 * Created by cjwest on 11/8/15.
 */
public interface MessageListener {
    public void messageReceived(String message, MessageSource source);
    public void sourceClosed(MessageSource source);
}
