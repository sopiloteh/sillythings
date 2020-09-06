/******************************************************************************
CS003B Java
Erick Bravo
07/10/20
P20.06 log in
*******************************************************************************/
import javax.swing.JFrame;

public class SignOnTester 
{
    public static void main(String[] args)
    {
        JFrame loginFrame = new SignOn();
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setTitle("Authenticate");
        loginFrame.setVisible(true);
    }
    
}
