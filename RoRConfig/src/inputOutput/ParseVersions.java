/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputOutput;

import core.Console;
import core.Definitions;
import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author derby_000
 */
public class ParseVersions {
    
    private Scanner scan;
    
    
    
    public ParseVersions()
    {
        scan = new Scanner( getClass().getResourceAsStream("Versions.txt"));
        Console.writeln("Parsing version definitions.");
        
        String temp = "";
        
        while(scan.hasNext())
        {
            temp = scan.next();
            
            if(temp.equalsIgnoreCase(Definitions.DEF_VERSION))
            {
                Definitions.versionNames.add(scan.nextLine());
                Console.writeln("Found Definition for Rigs of Rods Version "+Definitions.versionNames.get(Definitions.versionNames.size()-1));
            }
            
            if(temp.equalsIgnoreCase(Definitions.DEF_VERSIONPATH))
            {
                try{
                    String temp1 = scan.nextLine();
                    temp1 = temp1.substring(1,temp1.length()-1);
                    Definitions.versionPaths.add(temp1);
                    Console.writeln("Found Definition for Rigs of Rods path "+Definitions.versionPaths.get(Definitions.versionPaths.size()-1));
                }
                catch(Exception ex)
                {
                    Console.writeln("Caught Exception");
                }
            }
            
        }
            
        
    }
    
}
