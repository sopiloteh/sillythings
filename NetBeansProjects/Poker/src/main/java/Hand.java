/******************************************************************************
CS003B Java
Erick Bravo
07/03/20
P7.12 Video Poker
*******************************************************************************/
import java.util.*;

public class Hand

{
    //variables
    private Card[] hand = new Card[5];
    private int count = 0;
    private static final int ROYAL_FLUSH = 8;
    private static final int FOUR_OF_A_KIND = 7;
    private static final int FULL_HOUSE = 6;
    private static final int FLUSH = 5;
    private static final int STRAIGHT = 4;
    private static final int THREE_OF_A_KIND = 3;
    private static final int TWO_PAIRS = 2;
    private static final int ONE_PAIR = 1;
    private static final int NO_PAIR = 0;

    //sets up the hand of poker cards to player
    public void setHand(int number,Card dealtCard)
    {
    
    hand[number] = dealtCard;
    count++;
    }

    // gives the player a card
    public Card getCard(int number)
    {
    return hand[number];
    }
    
    // sets up the array for the player for the hand
    public void sortHand()
    {
    // array to hold the cards
    Arrays.sort(hand);          
    }
    
    // actually shows the hand on screen
    public void printHand()
    {
    //loop to print out poker hand
    for(int i=0;i<5;i++)
        {
        System.out.printf("%d.%s\n",i+1,hand[i]);
        }
    }             

    // determines what kinda winning hand one has
    public int score()
    {
    sortHand();
    
    if(royalFlush())
        {
        return ROYAL_FLUSH;
        }

    else if(fourOfaKind())
        {
        return FOUR_OF_A_KIND;
        }

    else if(fullHouse())
        {
        return FULL_HOUSE;
        }

    else if(flush())
        {
        return FLUSH; 
        }

    else if(straight())
        {
        return STRAIGHT;  
        }
    
    else if(threeOfaKind())
        {
        return THREE_OF_A_KIND;    
        }

    else if(twoPairs())
        {
        return TWO_PAIRS;
        }
    
    else if(onePair())
        {
        return ONE_PAIR;
        }
    
    else
        {
        return NO_PAIR;
        }
    }

    // to check if its a royal flush
    public boolean royalFlush()
        {
        
        // checking to see if its both a straight and flush    
        if(straight() && flush())
            {
            return true;
            }
    
        else
            {
            return false;
            }
        }

    // to check if its a full house
    public boolean fullHouse()
    {
        //uses if statements to check face values
        if(threeOfaKind())
        {
            if(hand[3].getFace() == hand[4].getFace())
            {
                return true;
            }
        }   
        
        return false;

    }

    // checks its a straight
    public boolean straight()
    {
        // uses loop to compare cards and face value
        for(int i=0;i<4;i++)
        {
            if(!(hand[i].getFace() == hand[i+1].getFace() - 1));
            {
                return false;
            }
        }

    return true;
    }

    //checks if its a flush
    public boolean flush()
    {
        // uses loop to compare cards and face value
        for(int i=0;i<4;i++)
        {
            if(!(hand[i].getSuit() == hand[i+1].getSuit()))
            {
            return false;
            }
        }
        
    return true;        
    }

    //checks if its a four of a kind
    public boolean fourOfaKind()
    {
        
        if(threeOfaKind())
            {
                if(hand[2].getFace() == hand[3].getFace())
                {
                    return true;
                }
                
                else if(hand[2].getFace() == hand[4].getFace())
                {
                    Card temp = hand[3];
                    hand[3] = hand[4];
                    hand[4] = temp;
                    return true;
                }
            }
        
            return false;       
    }

    // chdcks if its a three of a kind
    public boolean threeOfaKind()
    {
        for(int i=0;i<3;i++)
        {
            if(hand[i].getFace() == hand[i+2].getFace())
                {
                    for(int j=0;j<i;j++)
                    {
                        Card temp = hand[j];
                        hand[j] = hand[j+3];
                        hand[j+3] = temp;
                    }             
        
                return true;

                }

        }

        return false;

    }
                
    //checks if its a two of a kind
    public boolean twoPairs()
    {
    int[] pair = {5,5};
    int count = 0;

    for(int i=0;i<4;i++)
    {
        if(hand[i].getFace() == hand[i+1].getFace())
            {
                pair[count] = i;
                count++;
            }
    }

    if(count == 2)
    {
        if(!(pair[0] == 0))
            {
            Card temp = hand[0];
            hand[0] = hand[2];
            hand[2] = hand[4];
            hand[4] = temp;
            }
        
        else
        {
            if(!(pair[1] == 2))
            {
            Card temp = hand[2];
            hand[2] = hand[4];
            hand[4] = temp;
            }
        }             

        return true;
    }

    return false;       
    }

    // checks if its a one of a kind
    public boolean onePair()
    {
    for(int i=0;i<4;i++)
        {
            if(hand[i].getFace() == hand[i+1].getFace())
                {
                Card temp = hand[0];
                hand[0] = hand[i];
                hand[i] = temp;
                temp = hand[1];
                hand[1] = hand[i+1];
                hand[i+1] = temp;
                Arrays.sort(hand,2,4);
                return true;
                }
        }             

    return false;

    }             

}