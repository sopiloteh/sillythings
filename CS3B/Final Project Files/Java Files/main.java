/******************************************************************************
CS003B Java
Erick Bravo
07/20/20
Final Project Planner
*******************************************************************************/

import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

/**
 * This portion of the class will create a gui to allow user clicks
 * @author erickbravo
 */
public class main extends JFrame
{
    private JFrame frame;
    private JPanel controlPanel;
    private JLabel statusLabel;
    private JLabel headerLabel;
    
    

    /**
     * draws the visual components for GUI
     */
    public main()
    {  
      initComponents();
      
    }
    
    
     /**
     * Where it all begins, will contain a reader for text file
     * @param args main program starter
     */
    public static void main(String[] args)
    {
        main demo = new main();
        demo.RoomBtn();
        demo.ScheduleBtn();
        demo.ExitBtn();
        
    }
    
   
    /**
     *  main code for GUI
     */
    private void initComponents()
    {
      
      frame = new JFrame("Room Scheduler");
      frame.setSize(200,200);
      frame.setLayout(new GridLayout(3,1));
      frame.addWindowListener(new WindowAdapter() {
          @Override
          public void windowClosing(WindowEvent windowEvent){
              System.exit(0);
          }
      });
      
      headerLabel = new JLabel("", JLabel.CENTER);
      statusLabel = new JLabel("",JLabel.CENTER);
      statusLabel.setSize(250,100);
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      frame.add(headerLabel);
      frame.add(controlPanel);
      frame.add(statusLabel);
      frame.setVisible(true);
         
    }

    
     /**
     * Draws the exit button and exits the program
     */
    private void ExitBtn()
    {
        JButton exitBtn = new JButton("Exit");
        exitBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             System.exit(0);   
            }
        });
        
        controlPanel.add(exitBtn,BorderLayout.SOUTH);
        frame.setVisible(true);        
    }

    /**
     * Draws the room button and calls up requster
     */
    private void RoomBtn()
    {
        JButton roomsBtn = new JButton("Rooms");
        roomsBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
            
                CollegeBuilding RoomGui = new CollegeBuilding();
                RoomGui.ClassRoomGui();
                RoomGui.EventBtn();
                RoomGui.TimeBtn();
                RoomGui.LengthBtn();
                RoomGui.SeatBtn();
                RoomGui.checkBtn();
                RoomGui.SaveBtn();
                RoomGui.ExitABtn();
                

            
            }
        });
        controlPanel.add(roomsBtn,BorderLayout.NORTH);
        frame.setVisible(true);
    }
    
     /**
     * Draws the schedule button and calls the schedule view
     */
    private void ScheduleBtn()
    {
        JButton scheduleBtn = new JButton("Schedule");
        scheduleBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
                Scheduable ViewGui = new Scheduable();
                ViewGui.ScheduableGUI();
                ViewGui.ScheduleBtn();
                ViewGui.ExitBBtn();
            }
        });
        
        controlPanel.add(scheduleBtn,BorderLayout.CENTER);
        frame.setVisible(true);
        
    }
         

}
