package src.parser;

import src.engine.LiveEngine;
import src.lib.CommandUtilObject;

public final class SQLParser {
 
    
    private SQLParser() {
        throw new AssertionError("No instances allowed for SQLParser Class.");
    }


    public static void parseGrabBracketContent(String[] parts, CommandUtilObject cmdObject, LiveEngine liveEngine){

        // use line because parts is split by spaces already...
        // String line = cmdObject.fullCommandLine;

        // String[] parts = line.split("\\s+", 3);

        

    }

}
