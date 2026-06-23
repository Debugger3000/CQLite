package src.engine;

import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.HashMap;
import java.util.Map;

import src.const_enum.*;
import src.model.Database;

public class LiveEngine {

    private Map<String, Database> databases = new HashMap<>(); // keep record of current databases in memory

    private Database currentDatabase; // current database in use
    //private String currentDatabaseName;
    private Path currentDatabasePath;

    // class level consts
    private static final String DB_DIR = "src/database/";
    private static final String DB_EXT = ".db";


    // GETTERS / SETTERS
    //
    // current database name GET and SET
    public Database getCurrentDatabase(){
        return currentDatabase;
    }
    public void setCurrentDatabase(String databaseName){
        Database db = databases.get(databaseName);
        if(db == null) throw new RuntimeException("Database does not exist: " + databaseName);
        this.currentDatabase = db;
    }
    
    // ---
    public Path getCurrentDatabasePath(){
        return currentDatabasePath;
    }
    public void setCurrentDatabasePath(String databaseName){
        Path path = Paths.get(DB_DIR, databaseName + ".db");
        this.currentDatabasePath = path;
    }
    
}
