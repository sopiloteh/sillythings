/******************************************************************************
CS003B Java
Erick Bravo
06/22/20
P3.12 Voting Machine
*******************************************************************************/

// this is where the fun starts
public class TesterVotingMachine 
{
    public static void main(String[] args)
    {
        // calls in the voting machine.java to get the functions
        VotingMachine voterMachine = new VotingMachine();
        
        // this is where you rig the election
        voterMachine.voteForDem();
        voterMachine.voteForDem();
        voterMachine.voteForDem();
        voterMachine.voteForDem();
        voterMachine.voteForRep();
        voterMachine.voteForRep();
        voterMachine.voteForRep();
        voterMachine.voteForRep();
        voterMachine.voteForRep();
        voterMachine.voteForRep();
        
        //after counting using built in getTotal, it sums up the total
        System.out.println("Voting Polls: \nTotal Votes Polled: " 
                +voterMachine.getTotal());
        
        // prints out only Rep votes
        System.out.println("Republican Votes: " +voterMachine.getRepVotes());
        
        // prints out only Dem votes
        System.out.println("Democratic Votes: "+voterMachine.getDemVotes());
        
        // this checks to see if there were any votes which is automatic yes
        System.out.println("Are Votes tallied?: \n" +voterMachine.isTally());
        
        // this sets function back to 0 for Rep and 0 for Dems
        System.out.println("Clearing Voting Machine ");
        voterMachine.clear();
        
        
    }
    
}
/*
Test results below using Apache NetBeans
Voting Polls: 
Total Votes Polled: 10
Republican Votes: 6
Democratic Votes: 4
Are Votes tallied?: 
true
Clearing Voting Machine 
------------------------------------------------------------------------
BUILD SUCCESS
------------------------------------------------------------------------
Total time:  0.830 s
Finished at: 2020-06-22T17:14:20-07:00
*/
