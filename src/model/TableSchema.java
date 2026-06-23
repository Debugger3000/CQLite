package src.model;

import java.util.List;
import src.model.Column;

class TableSchema {
    String name;
    List<Column> columns; // list of all columns in
    
}


class Column {
    String name;
    String datatype; // Probably change to enum (int, float, string, character, boolean...)
    boolean nullable;
    boolean isPrimaryKey;
    
}



class Row {
    Object[] values;
    
}
