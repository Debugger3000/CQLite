package src.const_enum;

public enum Commands {
        CREATE,
        USE,
        EXIT,
        DATABASE,
        TABLE,
        ERROR;

        // takes string, and compares to list of command enums
        // if one is found we return that enum...
        // if no match then we throw error
        public static Commands fromString(String input) {
        try {
            return Commands.valueOf(input.toUpperCase());
        } catch (IllegalArgumentException e) {
                //     throw new IllegalArgumentException("Unknown command - no ENUM match: " + input);
                return ERROR;
        }
    }
} 
    

