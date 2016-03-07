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

import javax.swing.*;
import userInterface.settings.*;
public class Settings extends JPanel
{
    private JTabbedPane cards;
    
    private JPanel cardRenderSystem;
    private JPanel cardGraphics;
    private JPanel cardGameplay;
    private JPanel cardAdvanced;
    private JPanel cardDebug;
    
    public Settings()
    {
        this.setBackground(Constants.BACKGROUNDBLUE);
        
        cardRenderSystem = new JPanel();
        cardGraphics = new Graphics();
        cardGameplay = new Gameplay();
        cardAdvanced = new JPanel();
        cardDebug = new JPanel();
        
        cards = new JTabbedPane();
        cards.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        cards.setTabLayoutPolicy(JTabbedPane.HORIZONTAL);
        cards.addTab("Render System", cardRenderSystem);
        cards.addTab("Graphics", cardGraphics);
        cards.addTab("Gameplay", cardGameplay);
        cards.addTab("Advanced", cardAdvanced);
        cards.addTab("Debug", cardDebug);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(cards);

    }
}
