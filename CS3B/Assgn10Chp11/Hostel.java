/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erickbravo
 */

import java.io.*;
import java.util.*;


public class Hostel
{
    public static void main(String[] args) throws IOException
    {
        String File, line;
        double total = 0;
        
        try
        {
            //allow user to punch in the file name
            System.out.print("\nEnter file name please: \n");
            Scanner scn = new Scanner(System.in);
            
            File = scn.nextLine();
            FileReader fr = new FileReader(new File(File));
            BufferedReader br = new BufferedReader(fr);
            
            // once the file is inpuuted then a symbolic calculating line is shown
            System.out.println("CALCULATIING");
            
            // reads each line
            line = br.readLine();
            
            
            while (line != null)
            {
                
                // looks for each and every ;
                String temp[] = line.split(";");
                
                // this prints out the string without the ; and sets it up as tabbed
                for (int i = 0; i < temp.length; i++)
                {
                    System.out.print(temp[i]+"\n");
                    if ( i == i)
                    {
                        System.out.print("\t");
                    }
                }
                
                // this sums up the total for each and every amount from position 2
                total += Double.parseDouble(temp[2]);
                System.out.println();
                line = br.readLine();
            }
            
            // shows the receipt
            System.out.println("\n Total: "+total);
        }
        
        // if the file isnt inputted right
        catch (FileNotFoundException e)
        {
            System.out.println("File does not exisit");
        }
    
    }
}



/*
--- exec-maven-plugin:1.5.0:exec (default-cli) @ Hotel ---

Enter file name please: 
/Users/erickbravo/NetBeansProjects/Hotel/src/main/java/hotel.txt
CALCULATIING
Erick
	 Drinks
	 123.00
	 07/17/2020
	
Flopster
	 Lodging
	 2342.00
	 07/19/2020
	
Master Chief
	 Conference
	 4334.00
	 07/20/2020
	

 Total: 6799.0
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  6.454 s
Finished at: 2020-07-17T13:00:44-07:00
------------------------------------------------------------------------
*/
