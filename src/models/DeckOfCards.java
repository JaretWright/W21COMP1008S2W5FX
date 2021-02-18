package models;

import java.util.ArrayList;
import java.util.List;

public class DeckOfCards {
    private ArrayList<Card> deck;

    /**
     * The constructor does not require any inputs, but must set
     * all the facenames and suits
     */
    public DeckOfCards()
    {
        deck = new ArrayList<>();
        //loop through all the face names and all the suits
        //to create Card objects and add them to the deck
        List<String> faceNames = Card.getFaceNames();
        List<String> suits = Card.getSuits();
        for (String suit : suits)
        {
            for (String faceName : faceNames)
            {
                Card newCard = new Card(faceName, suit);
                deck.add(newCard);
            }
        }
    }
}