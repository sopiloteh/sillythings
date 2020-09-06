/******************************************************************************
CS003B Java
Gonzalez, Kevin & Bravo, Erick
07/09/20
P8.07 Tile
*******************************************************************************/

import java.util.Scanner;
import static java.lang.System.*; // we gotta flex on dem young coders

public class ZipcodeTester
{
	// main method here
	public static void main(String[] args)
  {
    	String userIn;
      Scanner choice = new Scanner(System.in);
      Zipcode newZip = new Zipcode(menu());
  }
                    
  // this one to actually convert the number to code or do it in main? 
  public int menu() 
  {
    int temp;
  	do
      {
      	out.println("Welcome to the Post Office \n Please choose an option: " + "\nChoose 1 for zipcode, Choose 2 for barcode");
        temp = in.nextInt();
        
      }
      while(!(temp == 1 || temp == 2));
      setMenuOption();
  }
	return temp;
}
  