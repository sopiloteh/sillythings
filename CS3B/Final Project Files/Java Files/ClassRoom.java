import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
/**
 * This portion of the code will create a houseable classroom to house
 *  events in the college building, Tuesday edit, most likley wouldnt
 * need this class after all since College building does most of the visual
 * work for this
 * @author erickbravo
 */
public class ClassRoom extends CollegeBuilding
{
   private JFrame frame;
   private JLabel headerLabel;
   private JLabel statusLabel;
   private JPanel controlPanel;

    /**
     * pulls in from Amenities to see if any items are needed
     * @param extras calls from radio buttons
     */
    public void checkAmenities(Amenities extras)
    {
        //CollegeBuilding check = new CollegeBuilding();
        //check.checkBtn();
    }
    
    /**
     * checks to see if cushions are needed
     * @param chair calls from radio buttons
     */
    public void checkSeats(Seats chair)
    {
        
    }

    

    
}
