/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputOutput;

import core.*;
import java.io.File;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import userInterface.controls.EditControls;

/**
 *
 * @author derby_000
 */
public class ParseConfig {
    
    
    
    public ParseConfig()
    {
        Definitions.userPath = System.getProperty("user.home");
        
        Definitions.userDocuments = new JFileChooser().getFileSystemView().getDefaultDirectory().toString();
        
        Console.writeln("User's home path is "+Definitions.userPath);
        
        ParseVersions versions = new ParseVersions();
    }
    
    public static void parse(String filename,int i)
    {
        Console.writeln("Attempting to read config file");
        try{
            Scanner scan = new Scanner(new File(Definitions.userDocuments+Definitions.versionPaths.get(i)+"\\"+filename));
            Definitions.currentInputFile = "";
            while(scan.hasNext())
            {
                Definitions.currentInputFile = Definitions.currentInputFile+scan.nextLine()+"\n";
            }
            //Console.writeRule(125);
            //Console.write(Definitions.currentInputFile);
            //Console.writeRule(125);
            Console.writeln("Parsed config file successfully.");
            Console.writeln("Attempting to update UI...");
            AssignConfig.UpdateUI();
            Console.writeln("Updated UI successfully.");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Cannot find file \""+Definitions.userDocuments+Definitions.versionPaths.get(i)+"\\"+filename+"\".");
            Console.writeln("Caught Exception");
                    
        }
        
    }
    
    public static void parseInputMap(String filename, int i)
    {
        Console.writeln("Attempting to read input mapping file");
        Definitions.inputmaplength = 0;
        try{
            Scanner scan = new Scanner(new File(Definitions.userDocuments+Definitions.versionPaths.get(i)+"\\"+filename));
            Definitions.currentInputMap = "";
            while(scan.hasNext())
            {
                Definitions.currentInputMap = Definitions.currentInputMap+scan.nextLine()+"\n";
                Definitions.inputmaplength++;
            }
            //Console.writeRule(125);
            //Console.write(Definitions.currentInputMap);
            EditControls.update();
            //Console.writeRule(125);
            Console.writeln("Parsed input mapping file successfully.");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Cannot find file \""+Definitions.userDocuments+Definitions.versionPaths.get(i)+"\\"+filename+"\".");
            Console.writeln("Caught Exception");
                    
        }
    }
    
}
