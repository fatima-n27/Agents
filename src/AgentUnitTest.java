/**
 * Unit test class for the agent class.
 *
 * Author: Fatima Navid
 */
public class AgentUnitTest {
    public static void main(String[] args) {
        testConstructorAndGetters();
        System.out.println(" ");

        testSetters();
        System.out.println(" ");

        testAgentIDs();
        System.out.println(" ");

        testToString();
    }

    /**
     * Tests a constructor and various getters from the agent class.
     */
    public static void testConstructorAndGetters() {
        Agent a1 = new Agent("Fatima", "Alpha");
        System.out.println("Expected output: " + "Alpha@549321");
        System.out.println("Real output: " + a1.getUID());

        System.out.println("Expected output: " + "549321");
        System.out.println("Real output: " + a1.getAgentID());

        System.out.println("Expected output: Fatima");
        System.out.println("Real output: " + a1.getAgentName());

        System.out.println("Expected output: Alpha");
        System.out.println("Real output: " + a1.getCodeName());
    }

    /**
     * Tests the mutator method for agent name and code name from the agent class
     */
    public static void testSetters() {
        Agent a1 = new Agent();
        a1.setAgentName("Fatima");
        a1.setCodeName("Alpha");

        System.out.println("Expected output: " + "Fatima");
        System.out.println("Real output: " + a1.getAgentName());

        System.out.println("Expected output: " + "Alpha");
        System.out.println("Real output: " + a1.getCodeName());

    }

    /**
     * Tests if the updating of agent IDs works from the agent class
     */
    public static void testAgentIDs() {
        Agent a1 = new Agent("Jane", "Alpha");
        Agent a2 = new Agent("John", "Beta");
        Agent a3 = new Agent("Alice", "Gamma");

        System.out.println("Expected output: Jane: 549323, John: 549324, Alice: Gamma@549325");
        System.out.println("Actual output: " + a1.getAgentName() + ": " + a1.getAgentID()
                + ", " + a2.getAgentName() + ": " + a2.getAgentID()
                + ", " + a3.getAgentName() + ": " + a3.getUID());
    }

    /**
     * Tests the output from the toString method from the agent class.
     */
    public static void testToString() {
        Agent a1 = new Agent("Afifa", "Sigma");

        System.out.println("Expected output: " + "Agent name: Afifa, UID: Alpha@549326");
        System.out.println("Actual output: " + "Agent name: " + a1.getAgentName() + ", UID: " + a1.getUID());
    }
}
