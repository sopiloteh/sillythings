/******************************************************************************
CS003B Java
Erick Bravo
07/07/20
P8.03 Combo Lock
*******************************************************************************/

import javax.swing.JButton;

public class tileGame extends JButton
{
    private int id;
    private boolean match = false;


    private void setId(int id)
    {
        this.id = id;
    }

    private int getId()
    {
        return this.id;
    }
    
    public void setMatch(boolean match)
    {
        this.match = match;
    }
    
    public boolean getMatch()
    {
        return this.match;
    }
    
    public void showText()
    {
        this.setText(String.valueOf(id));
    }
}