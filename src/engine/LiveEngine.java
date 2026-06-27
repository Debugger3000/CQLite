package src.engine;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import src.const_enum.*;
import src.lib.ParserException;
import src.model.Database;
// import src.lib.ParserException;

public class LiveEngine {

    private Map<String, Database> databases = new HashMap<>(); // keep record of current databases in memory

    private Database currentDatabase; // current database in use
    //private String currentDatabaseName;
    private Path currentDatabasePath;

    // class level consts
    private static final String DB_DIR = "src/database/";
    private static final String DB_EXT = ".db";


    // constructor
    // create as blank with properties as set by default
    public LiveEngine() {
    }


    // GETTERS / SETTERS
    //
    // current database name GET and SET
    public Database getCurrentDatabase(){
        return currentDatabase;
    }
    public void setCurrentDatabase(String databaseName){
        Database db = databases.get(databaseName);
        if(db == null) throw new ParserException("Cannot set. Database does not exist.");
            
             
        
            // throw new RuntimeException("Database does not exist: " + databaseName);
        this.currentDatabase = db;
        System.out.println("---CurrentDatabase---\n" + currentDatabase); // print toString to show database info...
    }
    
    // ---
    public Path getCurrentDatabasePath(){
        return currentDatabasePath;
    }
    public void setCurrentDatabasePath(String databaseName){
        Path path = Paths.get(DB_DIR, databaseName + ".db");
        this.currentDatabasePath = path;
    }

    // ---

    // Check if database exists
    // if it exists we throw error
    public boolean doesDatabaseExist(String databaseName) {
        Database db = databases.get(databaseName);
        if(db != null) {
            throw new ParserException("Database already exists." + databaseName); 
        }
            // throw new RuntimeException("Database does not exist: " + databaseName);
        else{
            return false;
        }
    }

    // if it does not exist, we need to throw error
    public boolean needDatabaseExist(String databaseName) {
        System.out.println("Database name given to needDatabaseExist: " + databaseName);
        Database db = databases.get(databaseName);
        if(db != null) {
            return false;
        }
            // throw new RuntimeException("Database does not exist: " + databaseName);
        else{
            throw new ParserException("Database does not exist. " + databaseName); 
        }
    }

    // Add a database to databases
    public void addDatabase(Database database, String databaseName) {
        // if() {
        //     throw new ParserException("Failed to add database to im memory liveEngine." + databaseName); 
        // }
        // else{
        //     System.out.println("database added i think ???");
        // }
        databases.put(databaseName, database);
    }
    
}
