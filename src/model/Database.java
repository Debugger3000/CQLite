package src.model;

import java.util.Map;
import java.util.HashMap;

public class Database {
    private String name;
    private Map<String,Table> tables; // list of all tables in the database



    public Database (String name) {
        this.name = name;
        tables = new HashMap<>();

    }

    // Getters
    public String getName() {
        return name;
    }

    @Override
    public String toString(){
        StringBuilder sb = new StringBuilder();
        sb.append("Database: ").append(name).append("\n");
        sb.append("Tables:");

        if (tables.isEmpty()) {
            sb.append(" (none)");
        } else {
            for (String tableName : tables.keySet()) {
                sb.append("\n  - ").append(tableName);
            }
        }
        return sb.toString();
    }

}
