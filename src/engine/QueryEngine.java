package src.engine;

import src.lib.*;

public final class QueryEngine {

    private QueryEngine() {
        throw new AssertionError("No instances allowed");
    }

    // create a database that is given
    public static void createDatabase(String[] parts, CommandUtilObject cmdObject) {

        // grab 

        REPLUtils.parseCommandArguments(parts, cmdObject); // populate string name of database

        // check if the database already exists
        

        // create database if it does not exist


    }
    
}
