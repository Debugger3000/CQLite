package src;


import java.util.Scanner;
import src.const_enum.*;
import src.lib.CommandUtilObject;
import src.lib.REPLUtils;
// name this files package ?



// Run Command
// 

/**
 * Storage - 
 * 
 * 
 * 
 */



public class Main {

    
    
// main - entry point 
public static void main(String[] args) {

    System.out.println("CQL Database started.");

    // storage engine
    // interaction layer with database
    // 

    // run server and begin REPL Loop
    replServer();
    
}

// Main CLI loop function...
private static void replServer() {

    Scanner scanner = new java.util.Scanner(System.in);
    System.out.println("Welcome to CQLite !");

    CommandUtilObject cmdObject = new CommandUtilObject();

    // interactive environment loop
    while(true) {
        // grab user input into cli
        
        String line = scanner.nextLine().trim();
        // if no user input, continue
        if (line.isEmpty()) continue;

        // line input exists so we create a index for grabbing keywords
        //int userInputIndex = 0;

        // break cli input into chunks by spaces
        String[] parts = line.split("\\s+", 3);
        // grab main command keyword which is first word
        // 'use', 'exit', 'select'
        // String command = parts[userInputIndex].toLowerCase();

        // Commands cmd = Commands.fromString(command); // throws if invalid
        
        REPLUtils.parseCommand(parts, cmdObject);

        switch (cmdObject.command) {
                case CREATE -> {
                    System.out.println("create command issued.");
                    // userInputIndex++;
                    
                    // String commandArg = parts[1].toLowerCase();
                    // Commands cmdArg = Commands.fromString(commandArg);
                    REPLUtils.parseCommand(parts, cmdObject);
                    // userInputIndex = cmdObject.commandLineIndex;
                    if(cmdObject.errorFlag){
                        REPLUtils.errorLog(line, cmdObject.errorMessage);
                        break;
                    }
                    System.out.println(cmdObject.command);
                    System.out.println(cmdObject.commandLineIndex);
                    

                    // databse as secondary command,
                    // Create a database... 
                    if(cmdObject.command == Commands.DATABASE){
                        // userInputIndex++;
                        //String databaseName = parts[2].toLowerCase();
                        REPLUtils.parseCommandArguments(parts, cmdObject);
                        // userInputIndex = cmdObject.commandLineIndex;
                        if(cmdObject.errorFlag){
                            REPLUtils.errorLog(line, cmdObject.errorMessage);
                            break;
                        }
                        System.out.println("create database command issued...");
                        System.out.println(cmdObject.stringContent);

                    }
                    else if(cmdObject.command == Commands.TABLE){
                        // userInputIndex++;

                    }

                    // grab database name - Should always be index 2
                    //String databaseName = parts[2].toLowerCase();

                    // database functions call

                    // 

                    break; // break loop
                    
                }
                case USE -> {
                    System.out.println("use command issued.");
                    break; // break loop
                    
                }
                case EXIT -> {
                    System.out.println("Exiting CQLite.");
                    scanner.close();
                    return;
                }
                default -> REPLUtils.errorLog(line,cmdObject.errorMessage);
            }
    }

}

}
