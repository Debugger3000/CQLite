package src;


import java.util.Scanner;
import src.const_enum.*;
import src.lib.CommandUtilObject;
import src.lib.REPLUtils;
import src.lib.ParserException;
// name this files package ?
import src.engine.LiveEngine;
import src.engine.QueryEngine;



// Run Command
// 

/**
 * Storage - 
 * 
 * 
 * 
 */

// & 'C:\Users\mccau\AppData\Local\Programs\Eclipse Adoptium\jdk-25.0.3.9-hotspot\bin\java.exe' '-XX:+ShowCodeDetailsInExceptionMessages' '-cp' 'C:\Users\mccau\AppData\Roaming\Code\User\workspaceStorage\536fbf6473d73d03a5582eecbb2d5c8c\redhat.java\jdt_ws\CQLBase_a03098a7\bin' 'src.Main'



public class Main {

    
    
// main - entry point 
public static void main(String[] args) {

    System.out.println("CQL Database started.");

    // storage engine
    // interaction layer with database
    // 

    // load .db file or run queries against .db file with cli...

    // when to update .db file ? after each query we update in memory java models ?
    LiveEngine liveEngine = new LiveEngine();

    // run server and begin REPL Loop
    replServer(liveEngine);
    
}

// Main CLI loop function...
private static void replServer(LiveEngine liveEngine) {

    Scanner scanner = new java.util.Scanner(System.in);
    StringBuilder buffer = new StringBuilder(); // to add cli input into
    System.out.println("Welcome to CQLite !");
    String line = "";

    CommandUtilObject cmdObject = new CommandUtilObject();

    // interactive environment loop
    while(true) {
        // grab user input into cli
        line = "";


        // populate line as a String for a multi-line command
        while (scanner.hasNextLine()) {
            String scanLine = scanner.nextLine();
            // String strippedScanLine = scanLine.replaceAll("\n", "");
            // for (char c : scanLine.toCharArray()) {
            //     System.out.print((int) c + " ");
            // }
            // System.out.println();
            if (scanLine.isEmpty()) break; // is empty input we break this scanline loop...
            buffer.append(scanLine).append(" "); // space prevents words from different lines merging


            if (scanLine.trim().endsWith(";")) {
                line = buffer.toString().replaceAll("\\s+", " ").trim();
                cmdObject.fullCommandLine = line; // update new line to current cmdObject
                // ---- process the complete query here ----
                System.out.println("Got query: " + line);
                // tokenize, execute, whatever you need to do with fullQuery

                buffer.setLength(0); // reset for the next query
                // System.out.print("sql> ");
            }
            // else: keep looping silently, still accumulating the paste
        }
        
        // String line = scanner.nextLine().trim();
        
        // if no user input, continue
        if (line.isEmpty()) continue;
        else{
            cmdObject.commandLineIndex = 0;
        }

        // line input exists so we create a index for grabbing keywords
        //int userInputIndex = 0;

        // break cli input into chunks by spaces
        String[] parts = line.split("\\s+", 3);
        System.out.println("parts " + parts );
        // grab main command keyword which is first word
        // 'use', 'exit', 'select'
        // String command = parts[userInputIndex].toLowerCase();

        // Commands cmd = Commands.fromString(command); // throws if invalid

        try {

            REPLUtils.parseCommand(parts, cmdObject);

            // parse base structure of command here so our switch can directly point to a case
            // use database
            // create database
            // create table
            // select from <table>

            System.out.println(line);

            switch (cmdObject.command) {
                case CREATE -> {
                    System.out.println("create command issued.");
                    // userInputIndex++;
                    
                    // String commandArg = parts[1].toLowerCase();
                    // Commands cmdArg = Commands.fromString(commandArg);
                    REPLUtils.parseCommand(parts, cmdObject);
                    // userInputIndex = cmdObject.commandLineIndex;
                    // if(cmdObject.errorFlag){
                    //     REPLUtils.errorLog(line, cmdObject.errorMessage);
                    //     break;
                    // }
                    // System.out.println(cmdObject.command);
                    // System.out.println(cmdObject.commandLineIndex);
                    

                    // databse as secondary command,
                    // Create a database... 
                    if(cmdObject.command == Commands.DATABASE){
                        System.out.println("create database command issued...");
                        // create database
                        // send to create database query engine
                        QueryEngine.createDatabase(parts,cmdObject, liveEngine);
                        
                        // userInputIndex++;
                        //String databaseName = parts[2].toLowerCase();
                        // REPLUtils.parseCommandArguments(parts, cmdObject);
                        // userInputIndex = cmdObject.commandLineIndex;
                        // if(cmdObject.errorFlag){
                        //     REPLUtils.errorLog(line, cmdObject.errorMessage);
                        //     break;
                        // }
                        
                        // System.out.println(cmdObject.stringContent);

                    }
                    else if(cmdObject.command == Commands.TABLE){
                        // userInputIndex++;
                        System.out.println("create table command issued...\n\n" + parts);

                    }

                    // grab database name - Should always be index 2
                    //String databaseName = parts[2].toLowerCase();

                    // database functions call

                    // 

                    break; // break loop
                    
                }
                case USE -> {
                    // System.out.println("use command issued.");

                    QueryEngine.useDatabase(parts, cmdObject, liveEngine);



                    break; // break loop
                    
                }
                case EXIT -> {
                    System.out.println("Exiting CQLite.");
                    scanner.close();
                    return;
                }
                default -> REPLUtils.errorLog(line,cmdObject.errorMessage);
            }

        // catch any thrown errors
        } catch (ParserException  e) {
            REPLUtils.errorLog(line,e.getMessage());
            //System.out.println("Error: " + e.getMessage());
        }

        
        
    }

}

}
