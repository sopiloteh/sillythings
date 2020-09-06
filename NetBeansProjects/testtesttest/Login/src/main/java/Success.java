/******************************************************************************
CS003B Java
Erick Bravo
07/10/20
P20.06 log in
*******************************************************************************/
import java.awt.BorderLayout;
import java.awt.Font;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Success extends JFrame
{
    //variables
    private static final int FRAME_WIDTH = 500;
    private static final int FRAME_HEIGHT = 200;
    
    // shows after user logs in correctly
    public Success()
    {
        setSize(FRAME_WIDTH, FRAME_HEIGHT);
        setTitle("Welcome Screen");
        
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        
        JLabel label = new JLabel("Login Successful");
        label.setFont(new Font("Serif", 0,30));
        add(label, BorderLayout.CENTER);
        
        
    }
    
}
