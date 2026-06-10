package src.engine;

import java.nio.file.Path;
import java.nio.file.Paths;

public class LiveEngine {

    // private Database currentDatabase;
    private String currentDatabaseName;
    private Path currentDatabasePath;

    // class level consts
    private static final String DB_DIR = "src/database/";
    private static final String DB_EXT = ".db";


    // GETTERS / SETTERS
    //
    // current database name GET and SET
    public String getCurrentDatabaseName(){
        return currentDatabaseName;
    }
    public void setCurrentDatabaseName(String databaseName){
        this.currentDatabaseName = databaseName;
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
