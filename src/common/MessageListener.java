package common;

/**
 * An interface that classes who are observers implement.
 * @author Tommy Ho & Clifton West
 * @version 11/5/2015
 */
public interface MessageListener {
    /** Receives message from subject */
    public void messageReceived(String message, MessageSource source);
    /** Receives source closing from subject */
    public void sourceClosed(MessageSource source);
}
