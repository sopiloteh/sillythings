/******************************************************************************
CS003B Java
Erick Bravo
06/25/20
P6.10 Number Discard
*******************************************************************************/
import java.util.Scanner;

public class dataSet 
{
    private double sum;
    private double square;
    private double smallest;
    private double largest;
    private double count;
    
    public dataSet()
    {
        sum = 0;
        smallest = Double.MAX_VALUE;
        largest = Double.MIN_VALUE;
        count = 0;
    }
    
    // this adds the numbers and sets up variables for std dev down bellow
    public void add(double value)
    {
        double num = value;
        sum += num;
        square += Math.pow(num, 2.0);
        count++;
        
    // this updates the values to the new smallest
        if (value < smallest)
        {
          smallest = value;
        }

    // this updates values to the new largest    
        if (value > largest)
        {
            largest = value;
        }
        
    }
    
    // getting the average
    public double getAve()
    {
        return sum /count;
    }
    
    // getting standard deviation
    public double getStanDev()
    {
        double stddev = 0;
        stddev = Math.sqrt(square - (1.0/count)*Math.pow(sum,2.0) / (count - 1));
        return stddev;
    }   
}

/*
Enter a value or 0 to quit
1
Enter a value or 0 to quit
2
Enter a value or 0 to quit
3
Enter a value or 0 to quit

4
Enter a value or 0 to quit
5
Enter a value or 0 to quit
6
Enter a value or 0 to quit
0
Average of values 3.5
Standard deviation 8.734987120768983
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  10.632 s
Finished at: 2020-06-26T10:39:41-07:00
------------------------------------------------------------------------
*/
