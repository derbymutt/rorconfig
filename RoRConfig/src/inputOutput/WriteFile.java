/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package inputOutput;

import core.Console;
import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.io.Writer;
import javax.swing.JOptionPane;

/**
 *
 * @author derby_000
 */
public class WriteFile {
    
    
    public static void save(String filePath, String output)
    {
        Console.writeln("Starting save process...");
        try (Writer writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filePath), "utf-8"))) {
            writer.write(output);
            writer.close();
            Console.writeln("Wrote to "+filePath+".");
        }
        catch(Exception ex)
        {
            JOptionPane.showMessageDialog(null, "Cannot find file \""+filePath+"\".");
            Console.writeln("Caught Exception.");
            
        }
    }
    
}
