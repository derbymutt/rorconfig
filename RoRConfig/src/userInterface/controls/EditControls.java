/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.controls;

import core.Definitions;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import userInterface.Constants;
import userInterface.button.LoadButton;
import userInterface.button.SaveButton;

/**
 *
 * @author derby_000
 */
public class EditControls extends JPanel{
    
    private static String display = "";
    private static String lastInput = "";
    public static JTextArea textDisplay;
    private static JScrollPane textPane;
    private static JPanel textPanel;
    
    
    public EditControls()
    {
        this.setLayout(new GridLayout(2,1));
        this.setBackground(Constants.BACKGROUNDBLUE);
        JPanel panel = new JPanel(new BorderLayout());
        panel.setMaximumSize(new Dimension(800,200));
        panel.setBackground(Constants.BACKGROUNDBLUE);
        
        textDisplay = new JTextArea();
        textDisplay.setRows(0);
        textDisplay.setColumns(128);
        textDisplay.setRows(0);
        textDisplay.setBackground(Color.WHITE);
        textPane = new JScrollPane(textDisplay);
        textPanel = new JPanel();
        textPanel.setBorder(BorderFactory.createTitledBorder("Control Re-Mapping"));
        textPanel.setBackground(Constants.BACKGROUNDBLUE);
        textDisplay.setSize(400,800);
        textPanel.setSize(400,500);
        
        JPanel bar = new JPanel();
        textDisplay.setPreferredSize(new Dimension(800,240));
        textPane.setSize(200,300);
        textPanel.setLayout(new GridLayout(1,1));
        textPanel.setPreferredSize(new Dimension(200,450));
        textPanel.add(textPane);
        panel.add(textPanel, BorderLayout.CENTER);
        
        
        //bar.setSize(800,100);
        bar.setBackground(Constants.BACKGROUNDBLUE);
        bar.add(new LoadButton("Load Input Map for Selected RoR Version", Constants.FILE_MAPPING));
        bar.add(new SaveButton("Save", Constants.FILE_MAPPING));
        panel.add(bar, BorderLayout.SOUTH);
        
        this.add(panel);
    }
    
    public static void update()
    {
        textDisplay.setText(Definitions.currentInputMap);
        textDisplay.setRows(Definitions.inputmaplength+2);
    }
    
}
