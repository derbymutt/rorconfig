/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package rorconfig;
import core.Console;
import core.Definitions;
import inputOutput.ParseConfig;
import javax.swing.JOptionPane;
import userInterface.ConfigUI;
import userInterface.Constants;
/**
 *
 * @author derby_000
 */
public class RoRConfig {
    
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Console console = new Console();;
        try{
           
            
            
            
            Console.writeln();
            Console.writeln("Console started.");
        }
        catch(Exception ex)
        {
            console.hideInstance();
            JOptionPane.showMessageDialog(null, "Could not start backend.\nAttempting to start without it.");
            Console.canUseConsole = false;
            
        }
        try{
            ParseConfig configuration = new ParseConfig();
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Could not configure software.");
            if(Console.canUseConsole = true)
                Console.writeln("Failed to configure.");
        }
        try{
            
            Console.writeln("Starting User Interface...");
            
            ConfigUI UserInterface = new ConfigUI();

            Console.writeln("User Interface started.");
            if(Console.canUseConsole)
                console.hideInstance();
        }catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Failed to start.\nException "+ex.getMessage());
            System.exit(0);
        }
        
    }
}