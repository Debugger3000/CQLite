package src;


import java.util.Scanner;
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

private static void replServer() {

    Scanner scanner = new java.util.Scanner(System.in);
    System.out.println("Welcome to CQLite !");

    // interactive environment loop
    while(true) {
        // grab user input into cli
        
        String line = scanner.nextLine().trim();
        // if no user input, continue
        if (line.isEmpty()) continue;

        // break cli input into chunks by spaces
        String[] parts = line.split("\\s+", 3);
        // grab main command keyword which is first word
        // 'use', 'exit', 'select'
        String command = parts[0].toLowerCase();

        switch (command) {
                case "use" -> {
                    System.out.println("use command issued.");
                    break; // break loop
                    
                }
                case "exit" -> {
                    System.out.println("Exiting CQLite.");
                    scanner.close();
                    return;
                }
                default -> System.out.println("Unknown command: " + command);
            }
    }

}

}
