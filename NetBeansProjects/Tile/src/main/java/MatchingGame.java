/******************************************************************************
CS003B Java
Erick Bravo
07/08/20
P8.03 Tile
*******************************************************************************/

import java.awt.Dimension;
import javax.swing.JFrame;


public class MatchingGame
{
    public static void main(String[] args)
    {
        Grid b = new Grid();
        b.setPreferredSize(new Dimension(500,500)); 
        b.setLocation(500, 250);
        b.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        b.pack();
        b.setVisible(true);
    }   
}