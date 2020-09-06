/******************************************************************************
CS003B Java
Erick Bravo
07/08/20
P8.03 Tile
*******************************************************************************/

import javax.swing.JButton;

@SuppressWarnings("serial")
public class Tile extends JButton{
    private int id;
    private boolean matched = false;


    public void setId(int id){
        this.id = id;
    }

    public int getId(){
        return this.id;
    }


    public void setMatched(boolean matched){
        this.matched = matched;
    }

    public boolean getMatched(){
        return this.matched;
    } 
        
    public void showText() {
        this.setText(String.valueOf(id));
 }
    
}