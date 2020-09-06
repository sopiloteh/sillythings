/******************************************************************************
CS003B Java
Erick Bravo
07/07/20
P8.03 Combo Lock
*******************************************************************************/
import javax.swing.*;
import java.awt.*;
import java.util.*;

public class Grid extends JFrame
{
    private List<tileGame>tiles;
    private tileGame selectedCard;
    private tileGame c1;
    private tileGame c2;
    private Timer t;
    
    public Grid()
    {
        int pairs = 10;
        List<tileGame>tilesList = new ArrayList<tileGame>();
        List<Integer> tileGameVals = new ArrayList<Integer>();
        
        for (int i = 0; i < pairs; i++)
        {
            tileGameVals.add(i);
            tileGameVals.add(i);
        }
        
        Collections.shuffle(cardVals);
        
        for (int val : cardVals)
        {
            tileGame c = new tileGame(val);
            c.addActionListener(new ActionListender())
                    {
                        public void action
                    }
        }
        
    }
    
    
}
