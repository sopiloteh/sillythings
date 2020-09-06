/******************************************************************************
CS003B Java
Erick Bravo
07/10/20
P20.06 log in
*******************************************************************************/

 
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
import javax.swing.JTextField;
        


 class SignOn extends JFrame implements ActionListener
{
    // variables
    private static final int FRAME_WIDTH = 300;
    private static final int FRAME_HEIGHT = 200;
    public JLabel username;
    public JLabel password;
    public JTextField userField;
    public JTextField passField;
    public JButton loginBtn;
    public ArrayList usernames;
    public ArrayList passwords;
    public int Attempts;
    
    // allows the log in prompt to appear, constructor
    public SignOn()
    {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setResizable(false);
        setLocationRelativeTo(null);
        
        usernames = new ArrayList<>();
        passwords = new ArrayList<>();
        
        Attempts = 3;
        
        UsersData();
    }
    
    private void UIComponents()
    {
        username = new JLabel("Username");
        password = new JLabel("Password");
        userField = new JTextField(15);
        passField = new JTextField(15);
        
        //loginBtn.addActionListener(new Login());
        
        
        setLayout(new GridBagLayout());
        GridBagConstraints c = new GridBagConstraints();
        
        c.gridx =0;
        c.gridy = 0;
        
        c.insets = new Insets(10,10,10,10);
        c.fill = GridBagConstraints.NONE;
        
        add(username, c);
        c.gridx = 1;
        
        add(userField, c);
        c.gridx = 0;
        c.gridy = 1;
        
        add(password, c);
        c.gridx = 1;
        c.gridy = 1;
        
        add(passField, c);
        c.gridx = 0;
        c.gridy = 2;
        c.gridwidth = 2;
        c.anchor = GridBagConstraints.CENTER;
        
        add(loginBtn, c);        
    }
    
    private void UsersData()
    {
        try
        {
            File file = new File ("/Users/erickbravo/NetBeansProjects/testtesttest/Login/src/main/java/users.txt");
            BufferedReader reader = new BufferedReader(new FileReader(file));
            
            String line;
            String words[];
            
            while ((line = reader.readLine()) != null)
            {
                words = line.split(" ");
                usernames.add(words[0].toLowerCase());
                passwords.add(words[1]);
            }
        }
        
        catch (IOException e)
        {
            JOptionPane.showMessageDialog(SignOn.this, 
                    "users.txt could not be found. Please create the file"
            +" and enter some users and passwords.","Not found!!!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }

    //@Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
  
class Login 
{

        public void actionPreformed(ActionEvent e)
        {
            String  username = userField.getText().toLowerCase();
            String password = passField.getText();
            
            for (int i = 0; i <username.length(); i++)
            {
                if (usernames.get(i).equals(username))
                {
                    if (passwords.get(i).equals(password))
                    {
                        setVisible(false);
                        (new Success()).setVisible(true);
                        return;
                    }
                }
            }
            Attempts--;
            JOptionPane.showMessageDialog(SignOn.this,
                    "Invalid username password combonation. You have "
            +Attempts+" attempts left.","\nTry Again!"
                    ,JOptionPane.ERROR_MESSAGE);
            
            if (Attempts <= 0)
            {
                System.exit(0);
            }
        }
    }


    
    
    
}
