package common;

import java.util.ArrayList;
import java.util.List;

/**
 * An abstracts that classes who are subjects extend.
 * @author Tommy Ho & Clifton West
 * @version 11/5/2015
 */
public abstract class MessageSource {
    /** Array list of MessageListeners */
    private List<MessageListener> messageListeners;

    /** Constructor for MessageSource class */
    public MessageSource() {
        this.messageListeners = new ArrayList<MessageListener>();
    }
    // Precondition: listener must not be null
    public void addMessageListener(MessageListener listener) {
        messageListeners.add(listener);
    }

    /**
     * Remove MessageListener from arraylist.
     * @param listener MessageListener that needs to be removed.
     */
    public void removeMessageListener(MessageListener listener) {
        messageListeners.remove(listener);
    }

    /**
     * Sending a message to all of the message listeners.
     * @param message String to send.
     */
    protected void notifyReceipt(String message) {
        for (MessageListener listener :
                new ArrayList<MessageListener>(messageListeners)) {
            // We wrap this in a try/catch block so that just in case
            // one of our observers screws up, we don’t want to stop
            // notifying other observers.
            try {
                listener.messageReceived(message, this);
            } catch (RuntimeException ex) {
                ex.printStackTrace();
            }
        }
    }

    /**
     * Close a MessageSource.
     */
    protected void closeMessageSource() {
        // Here we need to iterate over a *copy* of our messageListeners list.
        // The reason is because if the listener’s ’sourceClosed’ method
        // removes that listener from this subject, we’d get a
        // ConcurrentModificationException if we were iterating over the
        // original list.
        for (MessageListener listener :
                new ArrayList<MessageListener>(messageListeners)) {
            try {
                listener.sourceClosed(this);
            } catch (RuntimeException ex) {
                // Ignore any exceptions encountered when trying to close
                // a source. There’s a similar rationale here as we had
                // with ignoring exceptions when we tried to close streams.
            }
        }
        messageListeners.clear();
    }
}
