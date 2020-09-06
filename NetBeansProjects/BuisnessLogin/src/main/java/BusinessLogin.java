// 1. Student Names: Miskaryan, Jacob and Bravo, Erick
// 2. Assignment Description:
//     Lab 6-Chapter 20 Programming Project 20.6
//     1. Input: No user input  (input occurs in BusinessLoginSampleRun.java)
//	   2. Output: No output from this part of the program
//     3. Processing: This contains the BusinessLogin class, its instance variables and methods for logging into a business account

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;


import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.ArrayList;

/**
	A class for logging into a business account
*/
public class BusinessLogin extends JFrame
{
    private static final int FRAME_WIDTH = 250;
    private static final int FRAME_HEIGHT = 135;
    
    private CardLayout cardLayout;
    
    private JPanel containerPanel;
    private JPanel loginPanel;
    private JPanel welcomePanel;
    
    private JTextField usernameTextField;
    private JTextField passwordTextField;
    
    private JButton loginButton;

    private ArrayList<String> usernames;
    private ArrayList<String> passwords;
    
    /**
    	Sets size of the JFrame and displays compiled product
    */
    public BusinessLogin()
    {
    	setSize(FRAME_WIDTH, FRAME_HEIGHT);
        compilePanels();
    }
    
    /**
    	Compiles all created panels
    */
    private void compilePanels()
    {
    	loadUsernamesAndPasswords();
    	
        loginPanel = constructLoginPanel();
        
        welcomePanel = constructWelcomePanel();
        
        containerPanel = new JPanel(new CardLayout());
        containerPanel.add(loginPanel, "LoginPanel");
        containerPanel.add(welcomePanel, "WelcomePanel");
        
        cardLayout = (CardLayout) containerPanel.getLayout();
        cardLayout.show(containerPanel, "LoginPanel");
        add(containerPanel);
    }
    
    /**
    	Constructs the login panel for the user to input their login information and test if its correct using the login button
    	Displays message stating "Incorrect Login Information" if information is not inputted correctly upon login button press
    	Displays welcome panel upon login button press if login information is inputted properly
    	@return the constructed login panel
    */
    private JPanel constructLoginPanel()
    {
        JPanel panel = new JPanel(new GridLayout(3, 1));
        
        usernameTextField = new JTextField(12);
        passwordTextField = new JPasswordField(12);
        
        loginButton = new JButton("Login");
        loginButton.addActionListener(new ActionListener()
        {
        	private int remainingAttempts = 3;
        	public void actionPerformed(ActionEvent arg0)
        	{
        		boolean loggedIn = false;
        		String inputtedUsername = usernameTextField.getText().toLowerCase();
        		String inputtedPassword = passwordTextField.getText();
        		if (remainingAttempts == 1)
        		{
        			JOptionPane.showMessageDialog(null, "Maximum number of login attempts met; login window will now close.", "Incorrect Login Information", JOptionPane.ERROR_MESSAGE);
        			System.exit(1);
        		}
        		int index = -1;
        		for (int i = 0; i < usernames.size(); i++)
        		{
        			if(usernames.get(i).equalsIgnoreCase(inputtedUsername))
        			{
        				index = i;
        			}
        		    
        		}
        		if (index > -1 && passwords.get(index).equals(inputtedPassword))
    		    {
    		    	cardLayout.show(containerPanel, "WelcomePanel");
    		    	setSize(FRAME_WIDTH, FRAME_HEIGHT*2);
    		    	loggedIn = true;
    			}
        		if (!loggedIn) 
        		{
        			remainingAttempts -= 1;
        			String incorrectInputMessage;
        			if(remainingAttempts == 1)
        			{
        				incorrectInputMessage = "The inputted information is incorrect. You have " + remainingAttempts + " attempt remaining to input the information correctly.";
        			}
        			else
        			{
        				incorrectInputMessage = "The inputted information is incorrect. You have " + remainingAttempts + " attempts remaining to input the information correctly.";
        			}
        			JOptionPane.showMessageDialog(null, incorrectInputMessage, "Incorrect Login Information", JOptionPane.ERROR_MESSAGE);
        		}
        	}
        });
        
        JPanel usernamePanel = new JPanel();
        usernamePanel.add(new JLabel("Username:"));
        usernamePanel.add(usernameTextField);
        
        JPanel passwordPanel = new JPanel();
        passwordPanel.add(new JLabel("Password:"));
        passwordPanel.add(passwordTextField);
        
        panel.add(usernamePanel);
        panel.add(passwordPanel);
        panel.add(loginButton);
        
        return panel;
    }
    
    /**
    	Constructs the welcome panel for when the user has logged in
    	@return the constructed welcomePanel
    */
    private JPanel constructWelcomePanel()
    {
    	JPanel loginSuccessPanel = new JPanel();
    	loginSuccessPanel.add(new JLabel("Login successful."), BorderLayout.CENTER);
    	
    	JPanel welcomeToAccountPanel = new JPanel();
    	welcomeToAccountPanel.add(new JLabel("Welcome to your account."));
    	
    	JPanel welcomePanel = new JPanel(new GridLayout(3,1));
    	welcomePanel.add(new JPanel());
    	welcomePanel.add(loginSuccessPanel);
    	welcomePanel.add(welcomeToAccountPanel);
        return welcomePanel;
    }
    
    /**
    	Loads usernames and passwords from users.txt (displays warning if not located)
    */
    private void loadUsernamesAndPasswords()
    {
        usernames = new ArrayList<>();
        passwords = new ArrayList<>();
        try
        {
            Scanner fileScanner = new Scanner(new File("users.txt"));
            while (fileScanner.hasNextLine())
            {
            	String[] line = fileScanner.nextLine().split(" ");
            	usernames.add(line[0]);
            	passwords.add(line[1]);
            }
            fileScanner.close();
        } 
        catch (FileNotFoundException e)
        {
        	JOptionPane.showMessageDialog(null, "Warning: users.txt file was not found.", "WARNING", JOptionPane.WARNING_MESSAGE);
        }
    }  
}

// 3. Sample Run: In separate document