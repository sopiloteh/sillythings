/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author erickbravo
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

public class babyNames 
{
    public static void main(String[] args) throws FileNotFoundException
    {
        //calls in file for babynames
        File babyfile = new File("/Users/erickbravo/NetBeansProjects/Baby/src/main/java/babynames.txt");
        Scanner inFile = new Scanner(babyfile);
        PrintWriter girl = new PrintWriter("boynames.txt");
        PrintWriter boy = new PrintWriter("girlnames.txt");
        
        
        // scans that file and sees whats what
        while (inFile.hasNextLine())
        {
            int rank = inFile.nextInt();
            
            // checks for boys names
            String boyname = inFile.next();
            
            int bCount = inFile.nextInt();
            double bPercent = inFile.nextDouble();
            
            // writes out how many people use that name
            boy.println(rank+" "+boyname+" "+bCount+" "+bPercent);
            
            // checks for girls names
            String girlname = inFile.next();
            
            int gCount = inFile.nextInt();
            double gPercent = inFile.nextDouble();
            
            // writes out how many people use that name
            girl.println(rank+" "+girlname+" "+gCount+" "+gPercent);
        }
        
        // closes the files so that they can be viewed later
        boy.close();
        girl.close();
        inFile.close();
    }
    
}
