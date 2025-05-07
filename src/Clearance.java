/**
 * Enumerated data type to represent security clearance levels for all agents.
 * Helps manage the security of agent communications.
 *
 * Author: Fatima Navid
 */
public enum Clearance {
        LEVEL_1A(1),
        LEVEL_1B(2),
        LEVEL_2(3),
        LEVEL_3(4);

        /**
         * hierarchy value to help compare each level.
         */
        private final int hierarchy;

        /**
         * Constructor to give each level a hierarchy value.
         *
         * @param hierarchy, integer to represent the clearance levels.
         */
        private Clearance(final int hierarchy) {
                    this.hierarchy = hierarchy;
        }

        /**
         * Getter for the hierarchy value.
         */
        public int getHierarchy() {
                return hierarchy;
        }
}
