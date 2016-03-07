/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

/**
 *
 * @author derby_000
 */

import core.Console;
import core.Definitions;
import core.InfoBuilder;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.*;
import userInterface.button.CancelButton;
import userInterface.button.LoadButton;

public class ConfigUI extends JFrame implements ItemListener
{
    private JPanel mainPane;
    private JLabel header;
    private ImageIcon headerImage;
    
    private JComboBox mainSections;
    private final String SETTINGSTEXT = "Settings";
    private final String CONTROLSTEXT = "Controls";
    private final String NETWORKTEXT = "Network";
    private final String ABOUTTEXT = "About";
    
    private final String[] PANELS = { SETTINGSTEXT, CONTROLSTEXT, NETWORKTEXT, ABOUTTEXT };
    
    private JTabbedPane cards;
    private JPanel cardSettings;
    private JPanel cardControls;
    private JPanel cardNetwork;
    private JPanel cardAbout;
    private JPanel cardPane;
    private JPanel cardConsole;
    
    private JPanel tools;
    private JButton toolRestoreDefaults;
    private JButton toolSaveAndPlay;
    private JButton toolSaveAndQuit;
    private JButton toolCancel;
    
    private final int WIDTH = 500;
    private final int HEIGHT = 600;
    
    public static JComboBox versionSelection;
    private JPanel heading;
    
    private JButton loadVersionButton;
    
    
    public ConfigUI()
    {
        initializePanes();
        this.add(mainPane);
        
        this.setSize(WIDTH,HEIGHT);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setUndecorated(false);
        this.setResizable(false);
        
        this.setTitle(Constants.SOFTWARETITLE);
        this.setVisible(true);
    }
    
    private void initializePanes()
    {
        mainPane = new JPanel();
//        mainPane.setLayout(new BoxLayout(mainPane,BoxLayout.Y_AXIS));
        mainPane.setLayout(new BorderLayout());
        initializeCards();
        cardPane = new JPanel(new GridLayout(1,1));
        cardPane.setBorder(BorderFactory.createTitledBorder("Configuration"));
        
        cards = new JTabbedPane();
        cards.setSize(480,500);
        cards.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        cards.addTab(SETTINGSTEXT, cardSettings);
        cards.addTab(CONTROLSTEXT, cardControls);
        cards.addTab(NETWORKTEXT, cardNetwork);
        cards.addTab(ABOUTTEXT, cardAbout);
        cards.addTab("Console",cardConsole);
        cardPane.add(cards);
        
        initializeMainComponents();
        initializeTools();
        
        addComponents();
        
    }
    
    private void initializeTools()
    {
        tools = new JPanel(new GridLayout(1,4));
        
        toolRestoreDefaults = new JButton("Restore Defaults");
        toolSaveAndPlay = new JButton("Save and Play");
        toolSaveAndQuit = new JButton("Save and Quit");
        toolCancel = new CancelButton("Cancel");
        
        tools.add(toolRestoreDefaults);
        tools.add(toolSaveAndPlay);
        tools.add(toolSaveAndQuit);
        tools.add(toolCancel);
    }
    
    private void addComponents()
    {
        mainPane.add(heading, BorderLayout.NORTH);
        mainPane.add(cardPane, BorderLayout.CENTER);
        mainPane.add(tools, BorderLayout.SOUTH);
    }
    
    private void initializeCards()
    {
        
        InfoBuilder.newInfoPane();
        InfoBuilder.setPaneColor(Constants.BACKGROUNDBLUE);
        InfoBuilder.addHeading("Author:", InfoBuilder.STYLE_LEFT);
        InfoBuilder.addText("Alexander Scheiner (derbymutt)",InfoBuilder.STYLE_TABBED);
        InfoBuilder.addHeading("Version Information:", InfoBuilder.STYLE_LEFT);
        InfoBuilder.addText("Build Date: 8/20/2015",InfoBuilder.STYLE_TABBED);
        InfoBuilder.addText("Core Version: "+Console.getVersion(),InfoBuilder.STYLE_TABBED);
        InfoBuilder.addText("Java Version: 1.8",InfoBuilder.STYLE_TABBED);
        InfoBuilder.addText("Compiled in: NetBeans 8.0.2",InfoBuilder.STYLE_TABBED);
        
        
        cardSettings = new Settings();
        
        cardControls = new Controls();
        
        cardNetwork = new Network();
        
        cardAbout = InfoBuilder.getInfoPane();
        if(Console.canUseConsole)
            cardConsole = Console.getConsole();
        else
        {
            cardConsole = new JPanel();
            cardConsole.add(new JLabel("Backend error!"));
        }
//        cardAbout.setBackground(Constants.BACKGROUNDBLUE);
//        cardAbout.add(new JLabel("Author: Alexander Scheiner (derbymutt)"));
    }
    
    private void initializeMainComponents()
    {
        headerImage = new ImageIcon( getClass().getResource("Header.png"));
        header = new JLabel();
        header.setIcon(headerImage);
        header.setSize(480,100);
        header.setText("Rigs of Rods");
        header.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        
        JPanel versions = new JPanel();
        versions.setLayout(new BoxLayout(versions,BoxLayout.X_AXIS));
        versions.setBorder(BorderFactory.createTitledBorder("Versions"));
        
        versionSelection = new JComboBox(Definitions.versionNames.toArray());
        versions.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        
        loadVersionButton = new LoadButton("Load Config", Constants.FILE_CONFIG);
        
        versions.add(new JLabel("Rigs of Rods Version: "));
        versions.add(versionSelection);
        versions.add(loadVersionButton);
        
        
        heading = new JPanel();
        heading.setLayout(new BoxLayout(heading,BoxLayout.Y_AXIS));
        heading.add(header);
        heading.add(versions);
        
        
        
        mainSections = new JComboBox(PANELS);
        mainSections.setEditable(false);
        mainSections.addItemListener(this);
        mainSections.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        
        
    }
    
    public void itemStateChanged(ItemEvent evt) {
        CardLayout cl = (CardLayout)(cards.getLayout());
        cl.show(cards, (String)evt.getItem());
    }
    
    
}
