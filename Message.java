/**
 * Data wrapper class to represent messages exchanged between agents.
 * Includes encryption, decryption and encoding of messages for secure communication.
 *
 * Author: Fatima Navid
 */
public class Message{
    private String content;
    private Agent from;
    private Agent to;
    private Message next;

    private int[] encoded;
    private int[] encrypted;
    private int[] decrypted;

    private Clearance secrecy;

    /**
     * Constructor to create a message with specified sender, receiver and content.
     *
     * @param from, the sender
     * @param to, the receiver
     * @param content, message to send.
     */
    public Message(Agent from, Agent to, String content) {
        this.content = content;
        this.from = from;
        this.to = to;
    }

    /**
     * Constructor to create a message with specified sender, receiver, content and clearance level.
     *
     * @param from, the sender
     * @param to, the receiver
     * @param content, message to send.
     * @param secrecy, the clearance level of the message.
     */
    public Message(Agent from, Agent to, String content, Clearance secrecy) {
        this.content = content;
        this.from = from;
        this.to = to;
        this.secrecy = secrecy;
    }

    /**
     * Encodes the message by converting the contents into their ASCII equivalent.
     * Stores the numbers in an encoded array.
     */
    public void encode() {
        if(!content.isEmpty()) {
            encoded = new int[content.length()];
            // Loop to convert each character to its ASCII equivalent.
            for(int i = 0; i< content.length(); i++) {
                encoded[i] = content.charAt(i);
            }
        } else {
            encoded = new int[0];   //Array is empty if the content is empty.
        }
    }

    /**
     * Method to encrypt the contents of the message using caesar cipher.
     * Updates the content of the message with encrypted string.
     * Encodes the message if it hasn't been encoded.
     *
     * @param key, an int added to each character of the encoded text.
     */
    public void encrypt(int key) {
        if (!content.isEmpty()) {
            encrypted = new int[content.length()];
             //Loop through each character and add the key value.
            for(int i = 0; i < content.length(); i++) {
                encrypted[i] = getContent().charAt(i) + key;
            }

            //Encode the message if it is not already encoded.
            if (encoded == null) {
                encode();
            }

            //Updates the content of the message to the encrypted content.
            content = formatContent(encrypted);

        } else {
            encrypted = new int[0];
        }
    }

    /**
     * Method to decrypt the contents of the message with the key provided.
     * Updates the content to decrypted string.
     *
     * @param key, an integer used to decrypt the message
     */
    public void decrypt(int key) {
        //Initialise the size of the array to length of encrypted array
        decrypted = new int[encrypted.length];

        //Loop through each character and subtract the key value.
        for (int i = 0; i<encrypted.length; i++) {
            decrypted[i] = getContent().charAt(i) - key;
        }

        //Update the content of the message with the decrypted message.
        content = formatContent(decrypted);
    }

    /**
     * Helper method for encrypt and decrypt methods.
     * Format the content of the message by converting integers into a string.
     *
     * @param array, the array representing the int equivalent of character values.
     * @return formattedString, a String with the updated content.
     */
    public String formatContent(int[] array) {
        String formattedString = "";
        for (int i : array) {
            formattedString = formattedString + (char) i;   //Cast every integer from the array to character.
        }

        return formattedString;
    }

    /**
     * Accessor methods for next message in list, secrecy level, receiver, sender and contents of the message.
     */
    public Agent getFrom() {
        return from;
    }

    public Agent getTo() {
        return to;
    }

    public String getContent() {
        return content;
    }

    public Message getNext() {
        return next;
    }

    public Clearance getSecrecy() {
        return secrecy;
    }

    /**
     * Accessor for encoded, encrypted and decrypted array.
     *
     * @return "<not encoded>"/"<not encrypted>"/"<not decrypted>" respectively, if encoded array has no values.
     * @return the formated encoded array otherwise.
     */
    public String getEncoded() {
        if(encoded == null) {
            return "<not encoded>";
        } else {
            return "encoded: " + output(encoded);
        }
    }

    public String getEncrypted() {
        if(encrypted == null) {
            return "<not encrypted>";
        } else {
            return "encrypted: " + output(encrypted);
        }
    }

    public String getDecrypted() {
        if(decrypted == null) {
            return "<not decrypted>";
        } else {
            return "decrypted: " + output(decrypted);
        }
    }


    /**
     * Helper method for getEncrypted, getDecrypted and getEncoded methods.
     * Formats the values in an array to a string with [] around each value.
     *
     * @param array, array to format the numbers from.
     * @return concatenatedMessage, a formatted string of the array content.
     */
    public String output(int[] array) {
        String concatenatedMessage = "";
        String thisLetter;
        for (int j : array) {
            thisLetter = "[" + j + "]";
            concatenatedMessage = concatenatedMessage + thisLetter;
        }
        return concatenatedMessage;
    }


    /**
     * Setters for all attributes of the message class.
     */
    public void setFrom(Agent from) {
        this.from = from;
    }

    public void setTo(Agent to) {
        this.to = to;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public void setNext(Message next) {
        this.next = next;
    }

    public void setEncoded(int[] encoded) {
        this.encoded = encoded;
    }

    public void setEncrypted(int[] encrypted) {
        this.encrypted = encrypted;
    }

    public void setDecrypted(int[] decrypted) {
        this.decrypted = decrypted;
    }

    public void setSecrecy(Clearance secrecy) {
        this.secrecy = secrecy;
    }

    /**
     * Method to assist with debugging the program.
     *
     * @return concatenation of toString, encoded, encrypted and decrypted arrays.
     */
    public String debugString() {
        return toString() + "\n" + getEncoded() + "\n" + getEncrypted() + "\n" + getDecrypted();
    }

    /**
     * Method to return formatted message with sender, receiver and contents of the message.
     *
     * @return a formatted string with the receiver and sender's code name and the content of the message.
     */
    @Override
    public String toString() {
        return "Message from " + getFrom().getCodeName() + " to " + getTo().getCodeName() + ":\n" + getContent();
    }
}
