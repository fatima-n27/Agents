/**
 * Class to represent inboxes, used to help store messages.
 * Messages are stored as linked lists in an inbox.
 * 
 * Author: Fatima Navid
 */
public class Inbox {
    private Message recent;

    /**
     * Method to add a message to the inbox.
     * The message is added to the end of the list as it is the most recent one.
     *
     * @param message, message to add to the inbox.
     */
    public void receive(Message message) {
        if(recent != null) {
            message.setNext(recent);
        }
        recent = message;
    }

    /**
     * Method to read messages from the inbox (recent to oldest).
     * A message is deleted from the inbox once read.
     *
     * @return the most recent message received.
     */
    public Message read() {
        while(recent == null) {
            System.out.println("No message to read.");  //Print out an error message if inbox is empty.
            return null;
        }

        Message messageToRead = recent; //Retried the most recent message from the inbox.

        delete(recent);
        recent = recent.getNext();  //Moves to the next message in the list

        return messageToRead;
    }

    /**
     * Method to remove a message from the inbox.
     *
     * @param message, the message to delete from the inbox
     */
    public void delete(Message message) {
        Message currentMessage = recent.getNext();  //attribute to keep track of the message to delete
        Message previousMessage = recent;   //attribute to keep track of the next message in the list

        /**
         * Loop to delete the currentMessage as long as it exists.
         */
        while(currentMessage != null) {
            previousMessage.setNext(previousMessage.getNext());

            previousMessage = currentMessage;
            currentMessage = currentMessage.getNext();
        }
    }

    /**
     * Prints out the content of all the messages in the inbox (recent to oldest).
     * If there are no messages to read, prints out a message.
     */
    public void printAll() {
        if(recent == null) {
            System.out.println("<no more messages>");
        }

        //Calls a recursive method to print the contents.
        printAllRec(recent);
    }

    /**
     * Recursive method to print all the contents in the inbox.
     *
     * @param currentMessage, message to print the contents of.
     */
    private void printAllRec(Message currentMessage) {
        System.out.println(currentMessage.getContent());

        /**
         * if there is a message to print after the current one, method is recursively called.
         * Otherwise, a message is printed to the console.
         */
        if(currentMessage.getNext() != null) {
            printAllRec(currentMessage.getNext());
        } else {
            System.out.println("<no more messages>");
        }
    }

    /**
     * Accessor for the most recent message.
     */
    public Message getRecent() {
        return recent;
    }
}
