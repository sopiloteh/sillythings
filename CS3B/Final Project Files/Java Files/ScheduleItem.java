/******************************************************************************
CS003B Java
Erick Bravo
07/20/20
Final Project Planner
*******************************************************************************/

/**
 * This class allows the user to pick an event of their choosing
 * It is also a subclass
 * @author erickbravo
 */
public class ScheduleItem extends Scheduable
{
    int startTime;
    int length;
    int Lecture;
    int Club;
    int Seminar;
    int Guest;
    
    /**
     * variables driven from the list selection
     * @param Lecture sets position for event in Schedule
     * @param Club sets position for event in Schedule
     * @param Seminar sets position for event in Schedule
     * @param Guest sets position for event in Schedule
     */
    public ScheduleItem(int Lecture, int Club, int Seminar, int Guest)
    {
        
    }
    
    /**
     * variables driven from the list selection to allow an IF/ELSE check
     * @param Lecture priority 1 event to be written and planned
     * @param Club priority 2 event to be written and planned
     * @param Seminar priority 3 event to be written and planned
     * @param Guest priority 4 event to be written and planned
     */
    public void getPriority(int Lecture, int Club, int Seminar, int Guest)
    {
        
    }
    
    /**
     * writes to the txt file IF event has priority
     * @param check pulls from Scheduable
     */
    public void writeSched(Scheduable check)
    {
        
    }
    
}
