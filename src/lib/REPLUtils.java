package src.lib;

import src.const_enum.*;
import src.lib.CommandUtilObject;
import src.lib.ParserException;

public final class REPLUtils {
    
    private REPLUtils() {
        throw new AssertionError("No instances allowed");
    }

    // 
    public static void parseCommand(String[] commandParts, CommandUtilObject cmdObject){
        if(cmdObject.commandLineIndex >= commandParts.length){
            cmdObject.errorFlag = true;
            cmdObject.errorMessage = "Missing necessary arguments.";
            throw new ParserException("Missing neccessary arguments.");
            // return;
        }
        String commandArg = commandParts[cmdObject.commandLineIndex].toLowerCase();
        Commands cmdArg = Commands.fromString(commandArg);
        // index++;
        cmdObject.command = cmdArg;
        cmdObject.commandLineIndex++;
        return;
    }

    // Method to grab non sql based command keywords such as table_name, database_name, etc..
    public static void parseCommandArguments(String[] commandParts, CommandUtilObject cmdObject){
        if(cmdObject.commandLineIndex >= commandParts.length){
            cmdObject.errorFlag = true;
            cmdObject.errorMessage = "Missing necessary arguments.";
            throw new ParserException("Missing neccessary arguments.");
            // return;
        }
        String databaseName = commandParts[cmdObject.commandLineIndex].toLowerCase();
        cmdObject.stringContent = databaseName;
        cmdObject.commandLineIndex++;
        return;
    }

    // error output function controller
    public static void errorLog(String userInput, String errorMessage) {
        System.out.println("Error: " + errorMessage + " - For Command: '" + userInput + "'");
    }

}
