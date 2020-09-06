/******************************************************************************
CS003B Java
Erick Bravo
07/11/20
P20.01 rectangles
*******************************************************************************/

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Rectangle2D;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import javax.swing.JComponent;

public class RectangleMover extends JComponent
{
    // variable
    private List rectangles;
    private int rCount;
    private Rectangle2D.Double box;
    private static final double BWidth = 20;
    private static final double BHeight = 30;
    
    
    // creates rectangles for display anywhere
    public RectangleMover()
    {
        rectangles = new ArrayList();
        rectangles.add(getRandomRectangle());
        
    }
    
    // this updates the number of rectangles shown on screen
    public void setRectangle (int newCount)
    {
        //re displays the rectangles depending on the slider position
        rCount = newCount;
        repaint();
         
    }
    
    // dumps rectangles on the frame
    private Rectangle getRandomRectangle()
    {
        // sets the size of the rectangles
        Random rect = new Random();
        return new Rectangle(rect.nextInt(2000),rect.nextInt(20), rect.nextInt(40)+10,rect.nextInt(40)+10);
    }
    
    
    @Override
    public void paintComponent(Graphics g)
    {
        // actually draws them
        super.paintComponent(g);
        Graphics2D g2 = (Graphics2D) g;
        Random generator = new Random();
        for (int i = 0; i < rCount ; i++)
        {
            double x = getWidth() * generator.nextDouble();
            double y = getHeight() *generator.nextDouble();
            box = new Rectangle2D.Double (x,y,BWidth, BHeight);
            g2.draw(box);
        }
   
    }
    
    
  
}
