/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package userInterface.controls;

import core.Definitions;
import inputOutput.WriteFile;
import java.awt.GridLayout;
import javax.swing.JCheckBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import static jdk.nashorn.internal.objects.NativeJava.type;
import userInterface.ConfigUI;
import userInterface.Constants;

/**
 *
 * @author derby_000
 */
public class ForceFeedback extends JPanel{
    
    public JCheckBox ffbBox;
    public JSlider ffbOverall;
    public JSlider ffbSteering;
    public JSlider ffbCentering;
    public JSlider ffbInertia;
    
    private JLabel ffbOverallText = new JLabel("100%");
    private JLabel ffbSteeringText = new JLabel("100%");
    private JLabel ffbCenteringText = new JLabel("50%");
    private JLabel ffbInertiaText = new JLabel("0%");
    
    public ForceFeedback()
    {
        this.setLayout(new GridLayout(25,3));
        
        this.setBackground(Constants.BACKGROUNDBLUE);
        
        ffbBox = new JCheckBox("Enable Force Feedback");
        ffbBox.setBackground(Constants.BACKGROUNDBLUE);
        
        ffbOverall = new JSlider(0, 1000, 100);
        ffbOverall.setBackground(Constants.BACKGROUNDBLUE);
        ffbOverall.addChangeListener(new ffbChangeListener());
        ffbOverall.setMinorTickSpacing(5);
        ffbOverall.setMajorTickSpacing(100);
        ffbOverall.setPaintTicks(false);
        ffbOverall.setSnapToTicks(true);
        ffbOverall.setPaintLabels(false);
        
        ffbSteering = new JSlider(0, 4000, 100);
        ffbSteering.setBackground(Constants.BACKGROUNDBLUE);
        ffbSteering.addChangeListener(new ffbChangeListener());
        ffbSteering.setMinorTickSpacing(10);
        ffbSteering.setMajorTickSpacing(400);
        ffbSteering.setPaintTicks(false);
        ffbSteering.setSnapToTicks(true);
        ffbSteering.setPaintLabels(false);
        
        ffbCentering = new JSlider(0, 4000, 50);
        ffbCentering.setBackground(Constants.BACKGROUNDBLUE);
        ffbCentering.addChangeListener(new ffbChangeListener());
        ffbCentering.setMinorTickSpacing(10);
        ffbCentering.setMajorTickSpacing(400);
        ffbCentering.setPaintTicks(false);
        ffbCentering.setSnapToTicks(true);
        ffbCentering.setPaintLabels(false);
        
        ffbInertia = new JSlider(0, 1000, 0);
        ffbInertia.setBackground(Constants.BACKGROUNDBLUE);
        ffbInertia.addChangeListener(new ffbChangeListener());
        ffbInertia.setMinorTickSpacing(5);
        ffbInertia.setMajorTickSpacing(100);
        ffbInertia.setPaintTicks(false);
        ffbInertia.setSnapToTicks(true);
        ffbInertia.setPaintLabels(false);
        ffbInertia.setEnabled(false);
        
        this.add(new JLabel(""));
        this.add(ffbBox);
        this.add(new JLabel(""));
        
        this.add(new JLabel("Overall Force Level:"));
        this.add(ffbOverall);
        this.add(ffbOverallText);
        
        this.add(new JLabel("Steering Feedback Level:"));
        this.add(ffbSteering);
        this.add(ffbSteeringText);
        
        this.add(new JLabel("Self-centering Level:"));
        this.add(ffbCentering);
        this.add(ffbCenteringText);
        
        this.add(new JLabel("Inertia Feedback Level:"));
        this.add(ffbInertia);
        this.add(ffbInertiaText);
        
        for(int i = 3*5; i<25*3; i++)
            this.add(new JLabel(""));
    }
    
    private class ffbChangeListener implements ChangeListener
    {
        public void stateChanged(ChangeEvent e)
        {
            if(e.getSource() == ffbOverall)
            {
                ffbOverallText.setText("    "+ffbOverall.getValue()+"%");
            }
            if(e.getSource() == ffbSteering)
            {
                ffbSteeringText.setText("    "+ffbSteering.getValue()+"%");
            }
            if(e.getSource() == ffbCentering)
            {
                ffbCenteringText.setText("    "+ffbCentering.getValue()+"%");
            }
            if(e.getSource() == ffbInertia)
            {
                ffbInertiaText.setText("    "+ffbInertia.getValue()+"%");
            }
        }
        
    }
}
