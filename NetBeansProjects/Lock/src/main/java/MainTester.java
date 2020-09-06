/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erickbravo
 */

import javax.swing.JFrame;
public class MainTester 
{
    // main caller for the gui to the user
    public static void main(String[] args)
    {
        JFrame loginFrame = new Login();
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setTitle("AUTHENTICATE");
        loginFrame.setVisible(true);
    }
    
}
