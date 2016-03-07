/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import core.Console;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.InputEvent;
import java.io.IOException;
import java.net.URL;
import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.event.HyperlinkEvent;
import javax.swing.event.HyperlinkListener;

/**
 *
 * @author derby_000
 */
public class Network extends JPanel{
    
    
    private java.net.URL rorServerList;
    private JPanel settingPane;
    
    private JButton refreshButton;
    
    public static JTextArea serverName;
    public static JTextArea serverPort;
    public static JTextArea serverPass;
    public JEditorPane editorPane = new JEditorPane();
    
    
    public Network()
    {
        this.setBackground(Constants.BACKGROUNDBLUE);
        
        editorPane.setEditable(false);
        editorPane.addHyperlinkListener(new LinkListener());
        
        refreshButton = new JButton("Refresh");
        refreshButton.addActionListener(new RefreshListener());
        
        serverName = new JTextArea();
        serverName.setBorder(BorderFactory.createBevelBorder(1));
        serverPort = new JTextArea();
        serverPort.setBorder(BorderFactory.createBevelBorder(1));
        serverPass = new JTextArea();
        serverPass.setBorder(BorderFactory.createBevelBorder(1));
        
        settingPane = new JPanel(new GridLayout(1,3));
        settingPane.setSize(500,100);
        JPanel Pane1 = new JPanel(new GridLayout(3,1));
        JPanel Pane2 = new JPanel(new GridLayout(3,1));
        JPanel Pane3 = new JPanel(new GridLayout(1,1));
        
        Pane1.add(new JLabel(Constants.SERVER_HOSTNAME));
        Pane1.add(new JLabel(Constants.SERVER_PORT));
        Pane1.add(new JLabel(Constants.SERVER_PASSWORD));
        Pane1.setBackground(Constants.BACKGROUNDBLUE);
        Pane1.setBorder(BorderFactory.createTitledBorder(" "));
        
        Pane2.add(serverName);
        Pane2.add(serverPort);
        Pane2.add(serverPass);
        Pane2.setBackground(Constants.BACKGROUNDBLUE);
        Pane2.setBorder(BorderFactory.createTitledBorder(" "));
        
        Pane3.add(refreshButton);
        Pane3.setBackground(Constants.BACKGROUNDBLUE);
        Pane3.setBorder(BorderFactory.createTitledBorder(" "));
        
        settingPane.add(Pane1);
        settingPane.add(Pane2);
        settingPane.add(Pane3);
        
        settingPane.setBorder(BorderFactory.createTitledBorder("Network Settings"));
        settingPane.setBackground(Constants.BACKGROUNDBLUE);
        
        
        try{
           rorServerList = new URL("http://api.rigsofrods.com/serverlist/?version=RoRnet_2.37");
           if (rorServerList != null) {
            try {
                editorPane.setPage(rorServerList);
            } catch (IOException e) {
                Console.writeln("Attempted to read a bad URL: " + rorServerList);
            }
            } else {
                Console.writeln("Couldn't find file: http://api.rigsofrods.com/serverlist/?version=RoRnet_2.37");
            }
        }
        catch(Exception ex)
        {
            Console.writeln("Could not create URL");
        }
        

        //Put the editor pane in a scroll pane.
        JScrollPane editorScrollPane = new JScrollPane(editorPane);
        editorScrollPane.setVerticalScrollBarPolicy(
                        JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
        editorScrollPane.setPreferredSize(new Dimension(250, 145));
        editorScrollPane.setMinimumSize(new Dimension(10, 10));
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(editorScrollPane);
        this.add(settingPane);
    }
    
    //gets rorserver://ror.alliedgaming.net:12019/
    private class LinkListener implements HyperlinkListener
    {
        public void hyperlinkUpdate(HyperlinkEvent e)
        {
            try{
                if(e.getDescription() != null && e.getEventType() == HyperlinkEvent.EventType.ACTIVATED);
                {
                    String text = e.getDescription();
                    Console.writeln("Got URL "+text+" from click.");
                }
            } catch(NullPointerException ex)
            {
                Console.writeln("Failed");
            }
        }
    }
    
    private class RefreshListener implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            try{
                Console.writeln("User clicked refresh");
               java.net.URL rorServerList = new URL("http://api.rigsofrods.com/serverlist/?version=RoRnet_2.37");
               if (rorServerList != null) {
                try {
                    editorPane.setPage("http://api.rigsofrods.com/serverlist/");
                    
                } catch (IOException ex) {
                    Console.writeln("Attempted to read a bad URL: " + rorServerList);
                }
                try {
                    editorPane.setPage(rorServerList);
                }  catch (IOException ex) {
                    Console.writeln("Attempted to read a bad URL: " + rorServerList);
                }
                } else {
                    Console.writeln("Couldn't find file: http://api.rigsofrods.com/serverlist/?version=RoRnet_2.37");
                }
            }
            catch(Exception ex)
            {
                Console.writeln("Could not create URL");
            }
            
        }
    }
}
