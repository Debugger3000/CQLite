package src.engine;

import src.lib.*;
import src.model.Database;
import src.parser.SQLParser;

public final class QueryEngine {

    private QueryEngine() {
        throw new AssertionError("No instances allowed");
    }

    // create a database that is given
    public static void createDatabase(String[] parts, CommandUtilObject cmdObject, LiveEngine liveEngine) {

        // grab 

        REPLUtils.parseCommandArguments(parts, cmdObject); // populate string name of database
        String newDatabaseName = cmdObject.stringContent;

        // check if the database already exists
        // we want false, such that no database of that name exists yet 
        if(!liveEngine.doesDatabaseExist(newDatabaseName)){
            // create database if it does not exist

            // create java in memory model of database
            Database database = new Database(newDatabaseName);
            
            // store it in liveEngine database mapping...
            liveEngine.addDatabase(database, newDatabaseName);



        }
    }

    public static void useDatabase(String[] parts, CommandUtilObject cmdObject, LiveEngine liveEngine) {

        REPLUtils.parseCommandArguments(parts, cmdObject);
        // System.out.println("Within useDatabase QueryEngine: " + cmdObject.stringContent);

        String databaseName = cmdObject.stringContent;

        if(!liveEngine.needDatabaseExist(databaseName)){
            liveEngine.setCurrentDatabase(databaseName);
            // System.out.println("Database exists");
        }

    }

    // query specific functions can control their own parse stages
    // Such that, each function expects a certain structure...

    // Query handling
    public static void createTable(String[] parts, CommandUtilObject cmdObject, LiveEngine liveEngine) {

        // index should be on name now... we can grab that to use...
        REPLUtils.parseCommandArguments(parts, cmdObject); // populate string name of database
        String tableName = cmdObject.stringContent;

        // parse ();
        SQLParser.parseGrabBracketContent(cmdObject.fullCommandLine); // grab all bracket content possible

        // grab "(....) content from input parts" with Query parser

    }
    
}
