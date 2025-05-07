/**
 * Subclass of agent used for every agent's private inbox.
 * Checks security clearance levels.
 *
 * Author: Fatima Navid
 */
public class SecretAgent extends Agent {
    public static final int MAX_CLEARANCE_DIFFERENCE = 1;
    private Inbox inbox = new Inbox();

    /**
     * Constructor for a SecretAgent with their name, code name and clearance level.
     * @param name, agent's name
     * @param codeName agent's code name
     * @param clearance agent's clearance level
     */
    public SecretAgent(String name, String codeName, Clearance clearance) {
        super(name, codeName, clearance);
    }

    /**
     * Method to encrypt messages and send to receiver, if it passes 3 checks.
     * If all three are passed, message is encrypted and sent to the receiver's inbox.
     * Otherwise, which ever check is failed, the error message for it is printed.
     *
     * @param receiver, agent to send the message to.
     * @param msg, Message to send.
     * @param key, key for encryption.
     */
    public void send(SecretAgent receiver, Message msg, int key) {
        // Check One: Sender and calling agent match.
        //If the test is passed, move on to check two.
        if(!(msg.getFrom().getAgentName().equals(getAgentName()))) {
            System.out.println("Sender does not match.");
        } else {
            //Check Two: Receiver matches target agent
            //If the test is passed, move on to check three.
            if(!(msg.getTo().getAgentName().equals(receiver.getAgentName()))) {
                System.out.println("Receiver does not match.");
            } else {
                // Check Three: Receiver can only be one security level clearance above sender max.
                if(hierarchyVal(receiver.getAgentClearance()) > MAX_CLEARANCE_DIFFERENCE) {
                    System.out.println("Sender has insufficient clearance.");
                } else {
                    //Encrypts and sends the message
                    msg.encrypt(key);
                    receiver.getInbox().receive(msg);
                }
            }
        }
    }

    /**
     * Method to decrypt all the messages in the inbox.
     * If insufficient keys are provided, only those messages are decrypted.
     *
     * @param keys, array of integers used for decryption.
     */
    public void decryptAll(int[] keys) {
        decryptAllRec(inbox.getRecent(), keys, 0);
    }

    /**
     * Recursive method to decrypt all the messages in the inbox (recent to oldest).
     * If insufficient keys are provided, an error message is printed.
     *
     * @param current, the message being decrypted.
     * @param keys, array for the keys used in decryption.
     * @param index, int to keep track of the key being used for decryption.
     */
    public void decryptAllRec(Message current, int[] keys, int index) {
        //Base case to stop recursion if no more messages are left in the inbox.
        if(current == null) {
            return;
        }

        // If the keys are not enough, error message is printed and exits method.
        if(index>=keys.length) {
            System.out.println("Not enough keys supplied!");
            return;
        }

        //If the sender's clearance level is sufficient, decrypt the message.
        if(!(hierarchyVal(current.getFrom().getAgentClearance()) > MAX_CLEARANCE_DIFFERENCE)) {
            current.decrypt(keys[index]);
        }

        //Recursive call for the next message in inbox.
        decryptAllRec(current.getNext(), keys, index+1);
    }

    /**
     * Method to calculate the hierarchy difference between agents' clearance levels.
     *
     * @param clearanceLevel, the clearance level to compare against sender's.
     * @return an int representing the difference between the two agents' clearance levels.
     */
    public int hierarchyVal(Clearance clearanceLevel) {
        return clearanceLevel.getHierarchy() - this.getAgentClearance().getHierarchy();
    }

    /**
     * Getter and setter for the inbox.
     */
    public Inbox getInbox() {
        return inbox;
    }

    public void setInbox(Inbox inbox) {
        this.inbox = inbox;
    }
}
