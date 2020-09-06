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
    int choice, userInput;

    out.println("Welcome to the Post Office \n Please choose an option: " + "\nChoose 1 for zipcode, Choose 2 for barcode");
    Scanner temp = new Scanner(System.in);
    choice = temp.nextInt();
    
    if (choice == 1)
    {
    out.println("Pleae enter in the zipcode");
    userInput = temp.nextInt();
    }
    
    else if (choice == 2)
    {
    out.println("Pleae enter in the zipcode");    
    }

    convertBarcode();
  }
}