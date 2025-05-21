// This source code is UTF-8 coded - see https://stackoverflow.com/questions/9180981/how-to-support-utf-8-encoding-in-eclipse
package simplifiedBlackJack;


import cards.*;
import cards.Card.*;
import static cards.Card.*;
import static cards.Card.Constant.*;


/**
 * Simplified Black Jack Agent - see task
 * 
 * @author  Hendrik, Christoph Tank 
 * @version v1.0.0
 */
public class SimplifiedBlackJackAgent {
    
    // Ersetzen Sie diesen Kommentar durch Ihren Code
    // oder falls kein Code noetig ist, loeschen diesen Kommentar einfach.
    // Hier waere die Stelle fuer moegliche Zustandsvariablen, Exemplarvariablen
    // bzw. Objekt-spezifische Variablen oder einen Konstruktor,
    // sofern derartiges benoetigt wird.
    // Es ist Ihre Entscheidung und sie sollte Sinn machen.
    
    private int AceValue = 11;
    private int TriValue = 10;
    
    /**
     * "Play" Black Jack
     */
    public void playBlackJack(){
        
        // create new deck-instance
    	Deck deck = new Deck();
    	// instantiate and declare points counter for each run
        int totalPoints = 0;
        
        // Play until at least 17 Points with while loop
        while (totalPoints < 17) {
        	// Deal new card and store it in local variable
            Card drawnCard = deck.deal();// todo: karte direkt ausgeben 
            System.out.printf("%s",drawnCard);
            // get Cards Rank (e.g. CA, H9, etc)
            final Rank rank = drawnCard.getRank();
            //declare new local variable but don't instantiate it yet
            int cardValue;
            
            // Compare Card Value and instantiate cardValue with the corresponding value
            if (rank == Rank.ACE) {
                cardValue = AceValue; //ACE-Value is 11
            } else if (rank == Rank.JACK || rank == Rank.QUEEN || rank == Rank.KING) {
                cardValue = TriValue; //Non-Ace special card value is 10
            } else {
                cardValue = rank.value(); // fallback for non-speical cards to get Card Value with rank.value() method
            }// maybe simplify to switch case later?
            
            
            totalPoints += cardValue; //Increment points by current cards value totalPoint = totalPoints + cardValue
            
            // Print Point and Card Type
            System.out.printf("Punkte: %s ",totalPoints);
            System.out.printf("(Diff: %s)\n",cardValue);

        }
        if (totalPoints > 21) {
            System.out.println("LOST");
        }
        
        
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        // Sofern Sie kein Vorwissen haben und/oder NICHT wissen was Sie tun
        // führen Sie KEINE! Änderungen unterhalb dieser Zeilen durch.
        //^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^
        System.out.flush();
    }//method()
    
}//class
