/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package core;

import java.awt.Color;
import java.awt.Font;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author derby_000
 */
public class InfoBuilder {
    
    public static final Font LARGE = new Font(Font.SANS_SERIF,1,16);
    public static final Font SMALL = new Font(Font.SANS_SERIF,1,12);
    
    private static JPanel tempInfoPane;
    private static Color tempBackgroundColor;
    
    public static final int STYLE_TABBED = 0;
    //public static final int STYLE_INLINE = 1;
    public static final int STYLE_CENTERED = 2;
    public static final int STYLE_LEFT = 3;
    
    public static void newInfoPane( )
    {
        tempInfoPane = new JPanel();
        tempInfoPane.setLayout(new BoxLayout(tempInfoPane, BoxLayout.Y_AXIS));
    }
    
    public static void setPaneColor( Color color )
    {
        tempBackgroundColor = color;
        tempInfoPane.setBackground(tempBackgroundColor);
    }
    
    public static void addHeading(String str, int style)
    {
        JLabel temp = new JLabel(str);
        temp.setFont(LARGE);
        switch(style)
        {
            case 0:
                temp.setText("     "+str);
                temp.setAlignmentX(JLabel.LEFT_ALIGNMENT);
                break;
            case 2:
                temp.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                break;
            case 3:
                temp.setText(" "+str);
                temp.setAlignmentX(JLabel.LEFT_ALIGNMENT);
                break; 
        }
        tempInfoPane.add(temp);
    }
    
    public static void addText(String str, int style)
    {
        JLabel temp = new JLabel(str);
        temp.setFont(SMALL);
        switch(style)
        {
            case 0:
                temp.setText("     "+str);
                temp.setAlignmentX(JLabel.LEFT_ALIGNMENT);
                break;
            case 2:
                temp.setAlignmentX(JLabel.CENTER_ALIGNMENT);
                break;
            case 3:
                temp.setText(" "+str);
                temp.setAlignmentX(JLabel.LEFT_ALIGNMENT);
                break; 
        }
        tempInfoPane.add(temp);
    }
    
    public static JPanel getInfoPane()
    {
        return tempInfoPane;
    }
}
