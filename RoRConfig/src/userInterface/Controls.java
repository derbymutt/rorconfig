/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import userInterface.controls.EditControls;
import userInterface.controls.ForceFeedback;

/**
 *
 * @author derby_000
 */
public class Controls extends JPanel{
    private JTabbedPane cards;
    
    private JPanel cardInfo;
    private JPanel cardForceFeedback;
    
    public Controls()
    {
        this.setBackground(Constants.BACKGROUNDBLUE);
        
        cardInfo = new EditControls();
        cardForceFeedback = new ForceFeedback();
        
        cards = new JTabbedPane();
        cards.setAlignmentX(JPanel.LEFT_ALIGNMENT);
        cards.setTabLayoutPolicy(JTabbedPane.HORIZONTAL);
        cards.addTab("Info", cardInfo);
        cards.addTab("Force Feedback", cardForceFeedback);
        this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
        this.add(cards);

    }
}
