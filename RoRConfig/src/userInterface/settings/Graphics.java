/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.settings;

import java.awt.GridLayout;
import javax.swing.*;
import userInterface.Constants;
import userInterface.Defaults;

/**
 *
 * @author derby_000
 */
public class Graphics extends JPanel{
    
    public static JComboBox textureFilteringBox;
    
    public Graphics()
    {
        this.setLayout(new GridLayout(25,2));
        
        this.setBackground(Constants.BACKGROUNDBLUE);
        
        textureFilteringBox = new JComboBox(Constants.FILTERINGS);
        
        this.add(new JLabel(Constants.TEXTFILTERING));
        this.add(textureFilteringBox);
        
        for(int i = 2*1; i<25*2; i++)
            this.add(new JLabel(""));
    }
        
}
