/******************************************************************************
CS003B Java
Erick Bravo
07/03/20
P7.12 Video Poker
*******************************************************************************/
public class Card 
{
    // variables
    private int face;
    private int suit;
    private String faces[] = {"Deuce", "Three", "Four", "Five", "Six", "Seven",
        "Eight", "Nine", "Ten", "Jack", "Queen", "King", "Ace"};
    private String suits[] = {"Hearts", "Diamonds", "Clubs", "Spades"};
    
    // setting up variables
    public Card(int cardFace, int cardSuit)
    {
        face = cardFace;
        suit = cardSuit;
    }
    
    // adds the face/ rank of the card to the suit
    public String toString()
    {
        return faces[face] + " of" +suits[suit];
    }
    
    // gets the face/rank
    public int getFace()
    {
        return face;
    }
    
    //gets the suit
    public int getSuit()
    {
        return suit;
    }
    
    // compares both cards to see if they are same face
    public int compareTo(Card compareCard)
    {
        int compareFace = ((Card) compareCard).getFace();
        return compareFace - this.face;
    }
}
