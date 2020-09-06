// 1. Student Names: Miskaryan, Jacob and Bravo, Erick
// 2. Assignment Description:
//     Lab 6-Chapter 20 Programming Project 20.6
//     1. Input: User inputs login information and tests if their input is correct using the login button
//	   2. Output: Outputs whether the user's input is correct or incorrect
//     3. Processing: This tests the BusinessLogin class

import javax.swing.JFrame;

public class BusinessLoginSampleRun
{
	public static void main(String[] args)
	{
		JFrame frame = new BusinessLogin();
		frame.setTitle("Login");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
}

// 3. Sample Run: In separate document