/******************************************************************************
CS003B Java
Kelly Yu & Erick Bravo
06/26/20
P6.18 Half Life
*******************************************************************************/

import java.util.*;

public class halfLife
{
	public static void main(String[] args)
	{
        // user input to declare how much radioactive medicine they took at T =0
        System.out.println("Please enter radioactive medicine given now: ");
        
        // sets the atucal user input
        Scanner med = new Scanner(System.in);
        
        // sets the inputted half life into the variable
        double Ao = med.nextDouble();
        System.out.println("A/Ao in a patient’s body for the next 24 hours: ");

            for (int i = 1; i <= 24; i++)
            {
            // runs the calculation for estimating half life while run a loop for 24 times
            System.out.println("A/Ao after hr " +i+ ": "+(Ao * Math.exp(-i * (Math.log(2) /6.0))));
            }
	}
}

/*
Please enter radioactive medicine given now: 
6
A/Ao in a patient’s body for the next 24 hours: 
A/Ao after hr 1: 5.345392308842036
A/Ao after hr 2: 4.762203155904599
A/Ao after hr 3: 4.242640687119286
A/Ao after hr 4: 3.7797631496846193
A/Ao after hr 5: 3.367386144928119
A/Ao after hr 6: 3.0
A/Ao after hr 7: 2.6726961544210184
A/Ao after hr 8: 2.3811015779522995
A/Ao after hr 9: 2.121320343559643
A/Ao after hr 10: 1.8898815748423097
A/Ao after hr 11: 1.68369307246406
A/Ao after hr 12: 1.5
A/Ao after hr 13: 1.3363480772105092
A/Ao after hr 14: 1.1905507889761497
A/Ao after hr 15: 1.0606601717798214
A/Ao after hr 16: 0.9449407874211551
A/Ao after hr 17: 0.8418465362320298
A/Ao after hr 18: 0.7500000000000002
A/Ao after hr 19: 0.6681740386052547
A/Ao after hr 20: 0.5952753944880749
A/Ao after hr 21: 0.5303300858899107
A/Ao after hr 22: 0.47247039371057753
A/Ao after hr 23: 0.42092326811601505
A/Ao after hr 24: 0.375
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  13.137 s
Finished at: 2020-06-26T12:17:26-07:00
------------------------------------------------------------------------

*/
