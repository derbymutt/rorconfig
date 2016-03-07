/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.button;

import core.Definitions;
import inputOutput.WriteFile;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import userInterface.ConfigUI;
import userInterface.Constants;
import userInterface.controls.EditControls;

/**
 *
 * @author derby_000
 */
public class SaveButton extends JButton{
    
    private int type;
    
    
    public SaveButton(String text, int type)
    {
        this.type = type;
        this.addActionListener(new ClickListener());
        this.setText(text);
    }
    
    private class ClickListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            //if(type == Constants.FILE_CONFIG)
                //ParseConfig.parse("RoR.cfg", ConfigUI.versionSelection.getSelectedIndex());
            if(type == Constants.FILE_MAPPING)
            {
                //ParseConfig.parseInputMap("input.map", ConfigUI.versionSelection.getSelectedIndex());
                //EditControls.update();
                WriteFile.save(Definitions.userDocuments+Definitions.versionPaths.get(ConfigUI.versionSelection.getSelectedIndex())+"\\input.map",EditControls.textDisplay.getText());
            }
        }
        
    }
}
