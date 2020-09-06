/******************************************************************************
CS003B Java
Erick Bravo
07/20/20
Final Project Planner
*******************************************************************************/

import java.util.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


/**
 * This portion of the code houses the classroom and is a super class
 * to Amenitites, ClassRoom and Seats.
 * @author erickbravo
 */
public class CollegeBuilding extends JFrame
{
    private JFrame frame;
    private JPanel controlPanel;
    private JLabel statusLabel;
    private JLabel headerLabel;
    private JLabel exitALabel;
    private JLabel eventLabel;
    private JLabel timeLabel;
    private JLabel lengthLabel;
    private JButton exitABtn;
    private JComboBox<String> eventBtn;
    private JComboBox<String> timeBtn;
    private JComboBox<String> lengthBtn;

    
    /**
     * writes a new file to save whatever changes are diffrent from old file
     * @param Room this is called in from Classroom
     */
    public void Hall(ClassRoom Room)
    {
        
    }
    
        
    /**
     * creates gui for classroom request, it is a JFrame so that it 
     * can expand, it also contains a Jpanel to allow other objects
     * to be added quickly
     */
    public void ClassRoomGui()
    {
      frame = new JFrame("Room Planner");
      frame.setSize(300,300);
      frame.setLocation(0,0);
      frame.setLayout(new GridLayout(0,1));
      frame.setVisible(true);
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
            dispose();
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
      statusLabel = new JLabel("",JLabel.CENTER);
      statusLabel.setSize(200,200);
      controlPanel = new JPanel();
      controlPanel.setLayout(new GridLayout(7,1));
      frame.add(headerLabel);
      frame.add(controlPanel);
      frame.add(statusLabel);
      frame.add(controlPanel);
      controlPanel.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
      

    }
    
    /**
     * creates a drop down for events to be selected by the user
     */
    public void EventBtn()
    {
        JComboBox eventBtn = new JComboBox<>();
        eventBtn.setPreferredSize(new Dimension(100,30));

        eventBtn.setModel(new DefaultComboBoxModel<>(new String[] { "Lecture", "Seminar", "Guest Speaker", "Club" }));
        eventBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        
        controlPanel.add(eventBtn);
        //controlPanel.add(eventBtn,BorderLayout.NORTH);
        frame.setVisible(true);
    }
    
    /**
     * creates a drop down for Time with a dropdown
     */
    public void TimeBtn()
    {
        JComboBox timeBtn = new JComboBox<>();
        timeBtn.setPreferredSize(new Dimension(100,30));
        timeBtn.setModel(new DefaultComboBoxModel<>(new String[] { "6:00", "7:00", "8:00", "9:00", "10:00", "11:00", "12:00", "13:00", "14:00", "15:00", "16:00", "17:00", "18:00", "19:00", "20:00", "21:00", "22:00" }));
        timeBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        controlPanel.add(timeBtn);
        //controlPanel.add(eventBtn,BorderLayout.EAST);
        frame.setVisible(true);
    }
    
    /**
     *  this allows the user to select a length of time for the 
     *  event thats to be planned
     */
    public void LengthBtn()
    {
        JComboBox lengthBtn = new JComboBox<>();
        lengthBtn.setPreferredSize(new Dimension(100,30));
        lengthBtn.setModel(new DefaultComboBoxModel<>(new String[] { "30 min", "60 min", "90 min", "120 min", "150 min", "180 min" }));
        lengthBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                
            }
        });
        controlPanel.add(lengthBtn);
        //controlPanel.add(eventBtn,BorderLayout.WEST);
        frame.setVisible(true);
    }
    
    /**
     * this raido button allows the user to select one of two seat
     * choices, they are not permament but can be switched
     */
    public void SeatBtn()
    {
        JRadioButton comfey = new JRadioButton("Comefy?");
        JRadioButton standing = new JRadioButton("Standing?");
        comfey.setBounds(10,10,100,30);
        standing.setBounds(10,40,100,30);
        ButtonGroup bg = new ButtonGroup();
        bg.add(comfey);
        bg.add(standing);
        controlPanel.add(comfey);
        controlPanel.add(standing);
    }
    
    /**
     * this saves the choices as a toggle button, it also
     * prints a word to the CLI so user knows it was clicked
     */
    public void SaveBtn()
    {
        JToggleButton saveBtn = new JToggleButton("Save?");
        ItemListener itemListener = new ItemListener() 
        { 

            @Override
            public void itemStateChanged(ItemEvent itemEvent) 
            { 

                int state = itemEvent.getStateChange(); 

                if (state == ItemEvent.SELECTED) 
                { 
                    
                    System.out.println("Selected");
                    // add in dump feature to save to file
                } 
                else 
                { 

                    System.out.println("Deselected");
                    // does nothing?
                } 
            } 
        };
        
        saveBtn.addItemListener(itemListener);
        controlPanel.add(saveBtn);
        
    }
    
    public void checkBtn()
    {
        JCheckBox amenitiesBtn = new JCheckBox("3D printer");
        amenitiesBtn.setBounds(200,100,50,50);
        JCheckBox amenitiesBBtn = new JCheckBox("Plotter");
        amenitiesBBtn.setBounds(200,150,50,50);
        JCheckBox amenitiesCBtn = new JCheckBox("Printer");
        amenitiesCBtn.setBounds(200,250,50,50);
        JCheckBox amenitiesDBtn = new JCheckBox("Chalkboard");
        amenitiesDBtn.setBounds(200,300,50,50);
        controlPanel.add(amenitiesBtn);
        controlPanel.add(amenitiesBBtn);
        controlPanel.add(amenitiesCBtn);
        controlPanel.add(amenitiesDBtn);
    }

    /**
     * this closes the entire program with a simple exit command
     */
    public void ExitABtn()
    {
        JButton exitABtn = new JButton("Exit");
        exitABtn.setPreferredSize(new Dimension(100,30));
        exitABtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
             System.exit(0);
            }
        });
        controlPanel.add(exitABtn);
        //controlPanel.add(exitBtn,BorderLayout.SOUTH);
        frame.setVisible(true);        
    }
    
}
