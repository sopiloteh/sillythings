/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erickbravo
 */

import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class Login extends JFrame implements ActionListener
{
    
    //variables
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    private JLabel userLabel;
    private JLabel passLabel;
    private JTextField userField;
    private JPasswordField passField;
    private JButton loginBtn;
    
    private ArrayList usernames;
    private ArrayList passwords;
    private int attempts;
    
    public Login()
    {
        super("Login Here");
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        initUIComponents();
        
        usernames = new ArrayList<>();
        passwords = new ArrayList<>();
        attempts = 3;
        
        loadUsersData();
    }
    
    private void initUIComponents()
    {
        userLabel = new JLabel("Username");
        passLabel = new JLabel("Password");
        userField = new JTextField(15);
        passField = new JPasswordField(15);
        
        loginBtn = new JButton("Login");
        loginBtn.addActionListener(new LoginButtonListener());
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx = 0;
        c.gridy = 0;
        
        c.insets = new Insets(10,10,10,10);
        c.fill = GridBagConstraints.NONE;
        
        add(userLabel, c);
        c.gridx = 1;
        
        add(passLabel, c);
        c.gridx = 1;
        c.gridy = 1;
        
        add(passField, c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        
        add(loginBtn, c);
        
    }
    
    private void loadUsersData()
    {
        
        try
        {
            File file = new File("/Users/erickbravo/NetBeansProjects/testtesttest/Login/src/main/java");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            String line;
            String words[];
            
            while((line = reader.readLine()) != null)
            {
                words = line.split(" ");
                usernames.add(words[0].toLowerCase());
                passwords.add(words[1]);
            }
        }
        
        catch (IOException e)
        {
JOptionPane.showMessageDialog(Login.this,"users.txt couldnt be found Please create the file.","NOT FOUND!", JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }
    
    class LoginButtonListener 
    {
        
        public void actionPreformed(ActionEvent e)
        {
            String username = userField.getText().toLowerCase();
            String password = new String(passField.getPassword());
        }
    }

    
}
