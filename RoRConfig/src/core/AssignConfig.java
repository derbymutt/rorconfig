/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.util.Scanner;
import userInterface.Network;
import userInterface.settings.Gameplay;

/**
 *
 * @author derby_000
 */
public class AssignConfig {
    
    
    
    public static void UpdateUI()
    {
        String str = Definitions.currentInputFile;
        str = str.replaceAll("=", " = ");
        Scanner scan = new Scanner(str);
        int count = 0;
        
        Console.writeln("Starting config cycle loop...");
        while(scan.hasNext())
        {
            String temp = scan.next();
            count ++;
            if(temp.equalsIgnoreCase("ArcadeControls"))
            {
                scan.next();
                temp = scan.next();
                if(temp.equalsIgnoreCase("Yes"))
                    Gameplay.arcadeControlsBox.setSelected(true);
                else
                    Gameplay.arcadeControlsBox.setSelected(false);
                Console.writeln("Assigned Arcade Controls to "+Gameplay.arcadeControlsBox.isSelected());
            }
            if(temp.equalsIgnoreCase("Language"))
            {
                if(scan.next().equalsIgnoreCase("="))
                {
                    temp = scan.nextLine();
                    Console.writeln("Assigned Language to "+temp);
                    Gameplay.languageSelection.setSelectedItem(temp);
                }
            }
            if(temp.equalsIgnoreCase("Server"))
            {
                temp = scan.next();
                if(temp.equalsIgnoreCase("name"))
                {
                    scan.next();
                    temp = scan.nextLine();
                    Console.writeln("Assigned server name "+temp);
                    Network.serverName.setText(temp);
                }
                if(temp.equalsIgnoreCase("port"))
                {
                    scan.next();
                    temp = scan.nextLine();
                    Console.writeln("Assigned server port "+temp);
                    Network.serverPort.setText(temp);
                }
                if(temp.equalsIgnoreCase("password"))
                {
                    scan.next();
                    temp = scan.nextLine();
                    Console.writeln("Assigned server password "+temp);
                    Network.serverPass.setText(temp);
                }
            }
            if(temp.equalsIgnoreCase("Creak"))
            {
                if(scan.next().equalsIgnoreCase("sound"))
                {
                    scan.next();
                    temp = scan.nextLine();
                    if(temp.equalsIgnoreCase("Yes"))
                        Gameplay.creakSoundBox.setSelected(true);
                    else
                        Gameplay.creakSoundBox.setSelected(false);
                    Console.writeln("Assigned Creak sound to "+Gameplay.creakSoundBox.isSelected());
                }
            }
        }
        Console.writeln("Finished config cycle in "+count+" steps.");
        
    }
    
    
}
