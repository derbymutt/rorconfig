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
public class Gameplay extends JPanel{
    

    
    public static JComboBox languageSelection;
    public static JComboBox gearboxSelection;
    
    public static JTextArea fovInternalEntry;
    public static JTextArea fovExternalEntry;
    public static JTextArea userTokenEntry;
    
    public static JCheckBox cameraPitchingBox;
    public static JCheckBox arcadeControlsBox;
    public static JCheckBox creakSoundBox;
    
    public JButton getTokenButton;
    
    public Gameplay()
    {
        this.setLayout(new GridLayout(25,2));
        
        this.setBackground(Constants.BACKGROUNDBLUE);
        
        languageSelection = new JComboBox(Constants.LANGUAGES);
        
        gearboxSelection = new JComboBox(Constants.GEARBOXES);
        
        fovInternalEntry = new JTextArea(" "+Defaults.DEFAULT_FOVINT);
        fovInternalEntry.setBorder(BorderFactory.createBevelBorder(1));
        
        fovExternalEntry = new JTextArea(" "+Defaults.DEFAULT_FOVEXT);
        fovExternalEntry.setBorder(BorderFactory.createBevelBorder(1));
        
        cameraPitchingBox = new JCheckBox(Constants.TEXTCAMERAPITCH, Defaults.DEFAULT_CAMERA);
        cameraPitchingBox.setBackground( Constants.BACKGROUNDBLUE);
        
        arcadeControlsBox = new JCheckBox(Constants.TEXTARCADE, Defaults.DEFAULT_ARCADE);
        arcadeControlsBox.setBackground( Constants.BACKGROUNDBLUE);
        
        creakSoundBox = new JCheckBox(Constants.TEXTCREAKSOUND, Defaults.DEFAULT_CREAK);
        creakSoundBox.setBackground( Constants.BACKGROUNDBLUE);
        
        getTokenButton = new JButton(Constants.TEXTGETUSERTOKEN);
        
        JPanel tokenFrame = new JPanel(new GridLayout(1,2));
        tokenFrame.setBackground(Constants.BACKGROUNDBLUE);
        
        tokenFrame.add(new JLabel(Constants.TEXTUSERTOKEN));
        tokenFrame.add(getTokenButton);
        
        userTokenEntry = new JTextArea("");
        userTokenEntry.setBorder(BorderFactory.createBevelBorder(1));
        
        this.add(new JLabel(Constants.TEXTLANGUAGE));
        this.add(languageSelection);
        
        this.add(new JLabel(Constants.TEXTGEARBOX));
        this.add(gearboxSelection);
        
        this.add(new JLabel(Constants.TEXTFOVINT));
        this.add(fovInternalEntry);
        
        this.add(new JLabel(Constants.TEXTFOVEXT));
        this.add(fovExternalEntry);
        
        this.add(tokenFrame);
        this.add(userTokenEntry);
        
        this.add(new JLabel(""));
        this.add(cameraPitchingBox);
        
        this.add(new JLabel(""));
        this.add(arcadeControlsBox);
        
        this.add(new JLabel(""));
        this.add(creakSoundBox);
        

        
        for(int i = 2*8; i<25*2; i++)
            this.add(new JLabel(""));
        
       
    }
    
}
