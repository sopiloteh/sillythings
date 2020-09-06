/******************************************************************************
CS003B Java
Erick Bravo
07/03/20
P7.12 Video Poker
*******************************************************************************/
import java.util.*;

public class Deck 
{
    
    //variables
    private Card[] deck;
    private int currentCard = 0;
    private final int number = 52;
    private Random randomNumbers = new Random();
    private Hand handPlayer = new Hand();
    private static final int royalFlush = 8;
    private static final int fourOfAKind = 7;
    private static final int fullHouse = 6;
    private static final int flush = 5;
    private static final int straight = 4;
    private static final int threeOfAKind = 3;
    private static final int twoPairs = 2;
    private static final int onePair = 1;
    private static final int noPair = 0;
    private static String[] CardOrder = {"No pair", "One Pair", "Two Pair",
    "Three of a Kind", "Straight", "Flush", "Full House", "Four of a Kind",
    "Royal Flush"};
    
    
    // to create a new deck
    public Deck()
    {
        deck = new Card[number];
        for (int count = 0; count < deck.length; count++)
        {
            deck[count] = new Card(count%13, count/13);
        }
    }
    
    // to shuffle the deck around
    public void shuffle()
    {
        for (int first = 0; first < deck.length; first++)
        {
            int second = randomNumbers.nextInt(number);
            Card temp = deck[first];
            deck[first] = deck[second];
            deck[second] = temp;
        }
    }
    
    //dealing out the shuffled hand
    public void dealHand()
    {
        for (int i = 0; i < 5; i++)
        {
            handPlayer.setHand(i, deck[currentCard++]);
        }
    }

    //playing the shuffled hand
    public void playPoker()
    {
        shuffle();
        dealHand();
        System.out.println("Your hand is: ");
        handPlayer.printHand();
        Scanner input = new Scanner(System.in);
        
        // if you dont like the hand, you can swap it out
        System.out.println("Specifiy number of cards you want to change");
        int choice = input.nextInt();
        
        // changing all the players cards
        if (choice == 5)
        {
            for (int i = 0; i < 5; i++)
            {
                changeHand(i++);
            }
        }
        
        //changing only some cards
        else if (choice != 0)
        {
            for (int i = choice; i > 0; i--)
            {
                System.out.println("Enter the position of card you want to change: ");
                changeHand(input.nextInt());
            }
        }
        
        else if (choice == 0)
        {
        System.out.printf("Your Result is : %s",CardOrder[handPlayer.score()]);
        System.out.println("Your hand is: ");
        handPlayer.printHand(); 
        }
       
    }
    
    // swapping out hands if needed
    
    public void changeHand(int cardIndex)
    {
        handPlayer.setHand(cardIndex.deck[currentCard++]);
    }
    
}
