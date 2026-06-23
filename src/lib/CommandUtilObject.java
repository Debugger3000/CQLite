package src.lib;

import src.const_enum.Commands;


// Basic return object for certain REPL helper functions
public class CommandUtilObject {
    public int commandLineIndex;
    public String fullCommandLine;
    public Commands command;
    public String stringContent;
    public boolean errorFlag;
    public String errorMessage;

    public CommandUtilObject() {
        commandLineIndex = 0;
        this.errorFlag = false;
        this.errorMessage = "";
        this.stringContent = "";
    }

    public CommandUtilObject(boolean errorFlag, String errorMessage, int index, Commands command, String stringContent, String fullCommandLine){
        commandLineIndex = index;
        this.command = command;
        this.errorFlag = errorFlag;
        this.errorMessage = errorMessage;
        this.stringContent = stringContent;
        this.fullCommandLine = fullCommandLine;
    
    } 
    
}
