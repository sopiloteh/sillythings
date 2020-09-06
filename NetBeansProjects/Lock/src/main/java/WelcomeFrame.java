/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erickbravo
 */

import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class WelcomeFrame extends JFrame
{
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 200;
    
    // only shows it the user was able to get in succesfully
    public WelcomeFrame()
    {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Welcome");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        // welcome message below in stylaized font
        JLabel label = new JLabel("Welcome You have Haxord!");
        label.setFont(new Font("Times New Roman", 0,30));
        add(label, BorderLayout.CENTER);
        
    }
}
