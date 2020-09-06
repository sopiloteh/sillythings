/******************************************************************************
CS003B Java
Erick Bravo
07/08/20
P8.03 Tile
*******************************************************************************/

import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;
import info.gridworld.world.World;

import java.awt.Color;

public class TileGame extends World<Tile>
{
   public TileGame()
   {
      Color[] colors = 
         { 
            Color.RED, Color.BLUE, Color.GREEN, Color.CYAN,
            Color.PINK, Color.ORANGE, Color.GRAY, Color.MAGENTA,
            Color.YELLOW
         };
      for (Color color : colors)
      {
         add(getRandomEmptyLocation(), new Tile(color));
         add(getRandomEmptyLocation(), new Tile(color));
      }
      setMessage("Click on the first tile");
      first = true;
   }

   public boolean locationClicked(Location loc)
   {
      Grid<Tile> gr = getGrid();
      Tile t = gr.get(loc);
      if (t != null) 
      { 
         t.flip(); 
         if (first)
         {
            if (firstTile != null) 
            {
               firstTile.flip();
               secondTile.flip();
            }
            firstTile = t;
            setMessage("Click on the second tile");
            first = false;
         }
         else
         {            
            if (firstTile.getColor().equals(t.getColor()))
            {               
               firstTile = secondTile = null; 
            }
            else
               secondTile = t;   
            setMessage("Click on the first tile");
            first = true;
         }                  
      }
      return true;      
   }
   
   public boolean keyPressed(String description, Location loc)
   {
       if (description.equals("SPACE"))      
           return locationClicked(loc);
       else
           return false;
   }
   
   public static void main(String[] args)
   {
      new TileGame().show();
   }
   
   private Tile firstTile;
   private Tile secondTile;
   private boolean first;
}


