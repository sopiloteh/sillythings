/******************************************************************************
CS003B Java
Erick Bravo
07/07/20
P8.03 Combo Lock
*******************************************************************************/

import java.awt.*;
import javax.swing.*;

public class tileGameTest 
{
    public static void main(String[] args)
    {
        // pulls in the game board so that one can play it 
        Grid b = new Grid();
        // sets in the size of the board
        
        b.setPreferredSize(new Dimension(500,500));
        
        // starting location
        b.setLocation(500,250);
        
        // closes the game when the x is pressed
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
        b.setVisible(true);
    }
    
}
