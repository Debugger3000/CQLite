package src.parser;

import java.util.ArrayList;

import src.engine.LiveEngine;
import src.lib.CommandUtilObject;
import src.lib.ParserException;

public final class SQLParser {
 
    
    private SQLParser() {
        throw new AssertionError("No instances allowed for SQLParser Class.");
    }


    // just grab all () content and stored as string array
    public static ArrayList<String> parseGrabBracketContent(String line){

        // use line because parts is split by spaces already...
        // String line = cmdObject.fullCommandLine;

        // String[] parts = line.split("\\s+", 3);

        ArrayList<String> bracketContent = new ArrayList<>();

        int searchIndex = 0;
        //boolean bracketToSearchFor = true; // false - '(' ---> true - ')'
        // final char leftBracket = '(';
        // final char rightBracket = ')'; 
        boolean left = true;
        while (left){
            try {
                
                StringBuilder buffer = new StringBuilder(); // final ( content )
                // int leftIndex = 0;
                // int rightIndex = 0;

                if(searchIndex >= line.length()){
                    left = false;
                    continue;
                }
                
                // grab left bracket index
                int leftBracketIndex = line.indexOf('(', searchIndex);
                if (leftBracketIndex == -1) break;

                // grab right bracket index +1 after left bracket found
                int rightBracketIndex = line.indexOf(')', leftBracketIndex+1);
                if (rightBracketIndex == -1) break;

                String content = line.substring(leftBracketIndex, rightBracketIndex+1);

                buffer.append(content);
                bracketContent.add(buffer.toString());
                System.out.println("Bracket list before set length: " + bracketContent );  


                searchIndex = rightBracketIndex+1;
                buffer.setLength(0); // reset buffer

            } catch (Exception e) {
                // handle
                throw new ParserException("Error parsing Bracket content of Query.");
            }
            
        }

        System.out.println("Bracket content: " + bracketContent );  
        return bracketContent;

    }

}
