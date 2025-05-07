/**
 * Class to hold the information about an agent
 *
 * Author: Fatima Navid
 */
public class Agent{
    /**
     * Constant to represent the starting value for agent IDs.
     * First agent has this ID. Every subsequent agents' ID increments by 1.
     */
    private static int FIRST_AGENT_ID = 549321;

    /**
     * Attributes to hold information about agents including name, code name, clearance level, ID and UID
     */
    private String agentName;
    private String codeName;
    private final String UID;
    private final int agentID;
    private Clearance agentClearance;

    /**
     * Default constructor to initialize an agent.
     * Auto generates the agent ID and UID.
     * UID formatted as per specification.
     */
    public Agent() {
        this.agentID = FIRST_AGENT_ID++;
        this.UID = codeName + "@" + agentID;
    }

    /**
     * Constructor to create a new agent with various attributes including agent name and code name.
     * Agent ID is automatically assigned.
     * UID is generated using code name and agent ID.
     *
     * @param agentName, the name for the agent.
     * @param codeName, the code name given to the agent.
     */
    public Agent(String agentName, String codeName) {
        this.agentName = agentName;
        this.codeName = codeName;
        this.agentID = FIRST_AGENT_ID++;
        this.UID = codeName + "@" + agentID;
    }

    /**
     * Constructor to create a new agent with various attributes including name, code name and clearance level.
     * Agent ID is automatically assigned.
     * UID is generated using code name and agent ID.
     *
     * @param agentName, the name for the agent.
     * @param codeName, the code name given to the agent.
     * @param agentClearance, sets the clearance level for the agent.
     *
     */
    public Agent(String agentName, String codeName, Clearance agentClearance) {
        this.agentName = agentName;
        this.codeName = codeName;
        this.agentID = FIRST_AGENT_ID++;
        this.UID = codeName + "@" + agentID;
        this.agentClearance = agentClearance;
    }

    /**
     * Accessor method for all the attributes of Agent class.
     */
    public String getUID() {
        return UID;
    }

    public int getAgentID() {
        return agentID;
    }

    public String getCodeName() {
        return codeName;
    }

    public String getAgentName() {
        return agentName;
    }

    public Clearance getAgentClearance() {
        return agentClearance;
    }

    /**
     * Accessor to return a formatted string with UID and agent clearance
     */
    public String getAgentInfo() {
        return getUID() + " (" + agentClearance + " clearance)";
    }

    /**
     * Mutators for code name and agent name
     */
    public void setCodeName(String codeName) {
        this.codeName = codeName;
    }

    public void setAgentName(String agentName) {
        this.agentName = agentName;
    }

    /**
     * Returns a string with their name and UID.
     *
     * @return formatted string to display agent name and UID:
     */
    @Override
    public String toString() {
        return "Agent name: " + getAgentName() + ", UID: " + getUID();
    }
}
