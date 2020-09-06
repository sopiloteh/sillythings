/******************************************************************************
CS003B Java
Erick Bravo
07/11/20
P20.01 rectangles
*******************************************************************************/

import java.awt.BorderLayout;
import javax.swing.JFrame;
import javax.swing.JSlider;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;



public class Frame extends JFrame
{
    //variable holders
   private RectangleMover rectHolder;
   private JSlider slider;
   
   public Frame()
   {
       // sets the rectangles postions on the jframe
       rectHolder = new RectangleMover();
       add(rectHolder, BorderLayout.CENTER);
       
       //positions the slider and adds a listner to notice the movement
       slider = new JSlider (1, 100, 1);
       slider.addChangeListener(new SliderListener());
       
       //puts the slider at the bottom
       add(slider, BorderLayout.SOUTH);
   }
   
   // allows the slider to be listend to, a class in a class
   class SliderListener implements ChangeListener
   {
       @Override
       public void stateChanged(ChangeEvent e)
       {
           // slider increments turn to values
           int value = ((JSlider)e.getSource()).getValue();
           rectHolder.setRectangle(value);
       }
   }
}
