/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erickbravo
 */
public class Zipcode
{
  private final int conversionChoice;
  private String userInput;
  
  
  public Zipcode(int menuSelected)
  {
    	conversionChoice = menuSelected;
  }
  
  public void conversionChoice(int conversion)
  {
  }
  // this takes a number and returns a "barcode" representation
  public String convertBarcode(int digit) 
    {
    	String temp = "";
    	switch(digit)
        {
          case 1: temp = ":::||"; break;
          case 2: temp = "::|:|"; break;
          case 3: temp = "::||:"; break;
          case 4: temp = ":|::|"; break;
          case 5: temp = ":|:|:"; break;
          case 6: temp = ":||::"; break;
          case 7: temp = "|:::|"; break;
          case 8: temp = "|::|:"; break;
          case 9: temp = "|:|::"; break;
          
        }
        
        return temp;
    }
  
  public void setUserInput(String userInput)
  {
    this.userInput = userInput;
  }
  
  public String getUserInput(String userInput)
  {
    return userInput;
  }
}
