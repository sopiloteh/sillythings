/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.project2_10;

/*
import javax.swing.JComponent;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import java.awt.geom.Line2D;
import java.awt.geom.Line2D.Double;

public class ColorNameComponent extends JComponent
{
    public void paintComponent(Graphics g)
    {
        Color[] colors = 
            { Color.BLACK, Color.BLUE, Color.CYAN, 
            Color.DARK_GRAY, Color.GRAY, Color.GREEN, Color.LIGHT_GRAY, 
            Color.MAGENTA, Color.orange, Color.pink, Color.red, Color.yellow
            };
        
        Graphics2D g2 = (Graphics2D) g;
        
        for (int i = 0; i <colors.length; i++)
        {
            g2.setColor(colors[i]);
            g2.draw(new Line2D.Double(i,0,i,10));
        }            
    }
}
*/
 import javax.swing.JFrame;

 public class ColorNameComponent
 {
 public static void main(String[] args)
 {
 JFrame frame = new JFrame();
 frame.setSize(300, 400);
 frame.setTitle("An empty frame");
 frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
 frame.setVisible(true);
 }
 }
