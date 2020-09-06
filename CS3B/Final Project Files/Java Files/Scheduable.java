/******************************************************************************
CS003B Java
Erick Bravo
07/20/20
Final Project Planner
*******************************************************************************/

import java.util.*;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.print.*; 
import java.awt.*;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import javax.swing.*;

/**
 * This checks the event created to see if it is able to be created
 * it is also a super class to ScheduleItem
 * @author erickbravo
 */
public class Scheduable extends JFrame
{
    private JFrame frame;
    private JPanel controlPanel;
    private JLabel statusLabel;
    private JLabel headerLabel;
    private JButton exitBBtn;
    private JTextArea display;
    

    private boolean Scheduable;
    /**
     * this checks to see if the event is free to write
     * @return  checks file to verify if the event can be put down
     */
    public boolean chkScheduable()
    {
      return Scheduable;  
    }
    
    /**
     * sets up the foundation so that the text area and exit button can be 
     * seen
     */
    public void ScheduableGUI()
    {
      frame = new JFrame("Schedule View");
      frame.setSize(600,600);
      frame.setLayout(new GridLayout(3,1));
      frame.setVisible(true);
      frame.addWindowListener(new WindowAdapter() {
         public void windowClosing(WindowEvent windowEvent){
           
         }
      });
      headerLabel = new JLabel("", JLabel.CENTER);
      statusLabel = new JLabel("",JLabel.CENTER);
      statusLabel.setSize(200,200);
      controlPanel = new JPanel();
      controlPanel.setLayout(new FlowLayout());
      frame.add(headerLabel);
      frame.add(controlPanel);
      frame.add(statusLabel);
      frame.add(controlPanel);
    }
    
    /**
     * creates a view for a document by importing it 
     */
    public void ScheduleBtn()
    {
        CollegeBuilding save = new CollegeBuilding();
        save.EventBtn();
        JTextArea area = new JTextArea();
        JScrollPane scrollPane = new JScrollPane(area);
        //IDE mentions void cannot be drefrenced, another way of 
        // possibly going this would be to include this all in one class
        //sans voids
        //area.setText(area.getText()+"Test class: "+save.EventBtn().getText()+"\n");


        
        area.setBounds(50,50,50,50);
        frame.add(area);
        frame.setVisible(true);
    }
    
    public void PrintBtn()
    {
        JButton printBtn = new JButton("Print");
        printBtn.addActionListener( 
            new ActionListener() { 
                @Override
                public void actionPerformed( 
                    ActionEvent e) 
                { 
                    //area.print(); 
                } 
            });
    }
    
    /**
     *creates an exit button to well exit
     */
    public void ExitBBtn()
    {
        JButton exitBBtn = new JButton("Exit");
        exitBBtn.addActionListener(new ActionListener(){
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
            }
        });
        
        controlPanel.add(exitBBtn,BorderLayout.SOUTH);
        frame.setVisible(true);        
    }
   
}
