import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;


public class LoginWindow extends JFrame implements ActionListener
{

private static final String userName = "user";
//private static final String pass = "password";        
private JTextField userId;
private JPasswordField password;
private JButton loginButton;
private ArrayList usernames;
private ArrayList passwords;
private int attemptCount = 0;
    
    public LoginWindow()
    {

    super("Login Here");
    

    Container con = getContentPane();
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setSize(200, 200);

    JPanel pane1 = new JPanel();
    JPanel pane2 = new JPanel();
    JPanel pane3 = new JPanel();
    
    con.setLayout(new FlowLayout());
    con.add(pane1);
    con.add(pane2);
    con.add(pane3);

    JLabel usernames = new JLabel("UserId: ");
    pane1.add(usernames);

    userId = new JTextField(6);
    pane1.add(userId);
    JLabel password = new JLabel("Password: ");
    pane2.add(password);

    this.password = new JPasswordField(5);
    pane2.add(this.password);
    loginButton = new JButton("Login");
    pane3.add(loginButton);
    this.setVisible(true);

//adding listener

    loginButton.addActionListener(this);
    

    }

@Override

public void actionPerformed(ActionEvent e) 
{
UsersData();
Object action = e.getSource();

    if(action.equals(loginButton))
    {

    attemptCount++;

    String userNameEntered = userId.getText();
    String passwordEnterd = password.getText();

        try
        {

            if(userNameEntered.equalsIgnoreCase(userName) && passwordEnterd.equals(pass))
            {

            this.setVisible(false);
            JOptionPane.showMessageDialog(this, "Welcome", "Welcome!!", JOptionPane.INFORMATION_MESSAGE);
            
            this.userId.setText("");
            this.password.setText("");
            this.setVisible(true);

            }

            else if(attemptCount == 3)
            {

            JOptionPane.showMessageDialog(this, "Invalid username or password", "Alert!!", JOptionPane.WARNING_MESSAGE);
            JOptionPane.showMessageDialog(this, "Too many wrong entries, exiting", "Alert!!", JOptionPane.WARNING_MESSAGE);

            System.exit(0);

            }

            else
            {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Alert!!", JOptionPane.WARNING_MESSAGE);
            }

        }   

        catch(Exception ex)
        {

        JOptionPane.showMessageDialog(this, "Please enter all the fields", "Alert!!", JOptionPane.WARNING_MESSAGE);

        }

    }

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
            JOptionPane.showMessageDialog(LoginWindow.this, 
                    "users.txt could not be found. Please create the file"
            +" and enter some users and passwords.","Not found!!!",JOptionPane.ERROR_MESSAGE);
            System.exit(0);
        }
    }


public static void main(String[] args) 
{

LoginWindow login = new LoginWindow();

}


}

