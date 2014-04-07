/*
 * My own implementation of one of my all time favourite time consuming card games -- Solitaire
 * So far I have gotten the deck to initialize and have implemented the fischer-yates shuffle algorithm for an un-biased random shuffle of the deck
 * 
 */

package solitairegame;

import java.util.Random;
import java.util.Map;
import java.util.Timer;


class CardPile
{
    
}

class WastePile extends CardPile
{
    
}

class FoundationPile extends CardPile
{
    
}

class Cards 
{
    private enum Suits{HEARTS, DIAMONDS, CLUBS, SPADES}
    private enum Ranks{ACE, TWO, THREE, FOUR, FIVE, SIX, SEVEN, EIGHT, NINE, TEN, JACK, QUEEN, KING}
    private Ranks rank;
    private Suits suit;
    private int id;
    private boolean cardState; 
    
    Cards (int s, int r, int i)
    {   
        this.suit = Suits.values()[s];
        this.rank = Ranks.values()[r]; 
        this.id = i;
        cardState = false;
    }
    
    public void setCardValue(Suits s, Ranks r)
    {
       this.rank = r;
       this.suit = s;
    }
   
    public void getCardValue()
    {
      System.out.println(this.rank + " of " + this.suit);
    }
    
    public void flipCard()
    {
        this.cardState = !(this.cardState);
    }
    
    public boolean isFaceDown()
    {
        return cardState != false;
    }
   
    /*
    public void compareVal(Cards s)
    {
        if(s.val == this.val)
        {
            
        }
        else if(s.val> this.val)
        {
        }
        
        else if(s.val<this.val)
        {
            
        }
       
    }
    */
    @Override
    public String toString()
    {
        return this.rank + " of " + this.suit;
    } 
}
class Deck 
{
    private final Cards[] cardList = new Cards [52];
    //for init purposes
    private final int suitMaxNum = 13;
    private int suitType = 0;
    private int cardVal = 0;

    
    Deck(){
        //create the deck
        for(int currentCard = 0; currentCard<cardList.length; currentCard++)
        {
            cardList[currentCard] = new Cards(suitType, cardVal, currentCard);
            cardVal++;
     
            if(suitType<3 && cardVal==suitMaxNum)
            {
                cardVal = 0;
                suitType++;
            }    
        }
    }
    public  void shuffle()
    {
        Random r = new Random();
        for(int i = cardList.length - 1; i>0; i--)
        {   
            Cards tempCard = cardList[i];
            // generate random index value  
            int randIndex = r.nextInt(cardList.length);  
            
            //perform swap
            cardList[i] = cardList[randIndex];
            cardList[randIndex] = tempCard;  
        }
    }
    
    public  void dealDeck()
    {
        
    }   
    
    public  void showDeck()
    {
        for (Cards cardList1 : cardList) {
            cardList1.getCardValue();
        }
    }
 }

public class SolitaireGame 
{
    private static Deck solitaireDeck;

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
    {
            solitaireDeck = new Deck();
            solitaireDeck.shuffle();
            solitaireDeck.showDeck();  
    }
    
}
