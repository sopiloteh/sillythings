/******************************************************************************
CS003B Java
Erick Bravo
06/22/20
P3.12 Voting Machine
*******************************************************************************/


// main function holder
public class VotingMachine 
{
    // this is so that they cant be messed with easily
    private int repVotes;
    private int demVotes;
    
    // sets both variables to be starting at 0 or when its cleared
    public VotingMachine()
    {
        repVotes = 0;
        demVotes= 0;
    }
    
    // everytime voteFor is called, it adds to tally
    public void voteForDem()
    {
        demVotes = demVotes +1;
    }
    
    public void voteForRep()
    {
        repVotes = repVotes +1;
    }
    
    // this returns that summed up number to the print line
    public int getDemVotes()
    {
        return demVotes;
    }
    
    public int getRepVotes()
    {
        return repVotes;
    }
    
    // adds both voting totals to see how many voted
    public int getTotal()
    {
        return repVotes + demVotes;
    }
    
    // beacuse everyone voted it will always return true
    public boolean isTally()
    {
        return getTotal() == repVotes + demVotes;
    }
    
    // sets totals back to zero
    public void clear()
    {
        repVotes = 0;
        demVotes = 0;
    }
    
}
