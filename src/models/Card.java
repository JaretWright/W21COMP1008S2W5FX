package models;

import javafx.scene.image.Image;

import java.util.Arrays;
import java.util.List;

public class Card {
    private String faceName;
    private String suit;
    private Image cardImage;

    /**
     * This constructor takes 2 arguments, one for the face name and
     * one for the suit.  The value of the card assumes that aces
     * are high and will dynamically establish the card value
     * when the getCardValue() method is run
     *
     * The constructor must be the same name as the class (including the upper case first letter)
     * The constructor does NOT have a return type
     */
    public Card(String faceName, String suit)
    {
        setFaceName(faceName);
        setSuit(suit);
        setCardImage();
    }

    private void setCardImage()
    {
        String filePath = String.format("images/%s_of_%s.png",faceName,suit);
//        System.out.println(filePath);
        cardImage = new Image(filePath);
    }

    public Image getCardImage() {
        return cardImage;
    }

    public String getFaceName() {
        return faceName;
    }

    /**
     * This returns a list of valid face names in lower case
     * @return
     */
    public static List<String> getFaceNames(){
        return Arrays.asList("2","3","4","5","6","7","8",
                "9","10","jack","queen","king","ace");
    }

    /**
     * This method will validate that the argument is in the collection of
     * "two","three","four","five","six","seven","eight","nine","ten","jack","queen",
     * "king","ace" and set the instance variable
     * @param faceName - this is a String to represent the name of the card
     */
    public void setFaceName(String faceName) {
        faceName = faceName.toLowerCase();
        List<String> faceNames = getFaceNames();

        if (faceNames.contains(faceName))
            this.faceName = faceName;
        else
            throw new IllegalArgumentException(faceName + " is not valid, use "+faceNames);

        this.faceName = faceName;
    }

    public String getSuit() {
        return suit;
    }

    public static List<String> getSuits()
    {
        return Arrays.asList("hearts","diamonds","spades","clubs");
    }

    /**
     * This method will validate that the argument is one of "hearts","diamonds","spades","clubs"
     * @param suit
     */
    public void setSuit(String suit) {
        suit = suit.toLowerCase();
        List<String> validSuits = getSuits();
        if (validSuits.contains(suit))  // this performs a case sensitive comparison
            this.suit = suit;
        else
            throw new IllegalArgumentException(suit + " is not valid.  Use one of "+validSuits);
    }

    /**
     * This method will return the String "red" if the card's suit is hearts or diamonds,
     * "black" otherwise
     * @return
     */
    public String getCardColour()
    {
        if (suit.equals("hearts")||suit.equals("diamonds"))
            return "red";
        else
            return "black";
    }

    /**
     * This method will return the value of the card.  2 = 2, 3=3...9=9, 10=10, jack = 11
     * queen = 12, king = 13, ace = 14
     * @return
     */
    public int getFaceValue()
    {
        //the first face name in the list (position 0) is "two".  So we add 2 to the
        //index (or position) of each card
        return getFaceNames().indexOf(faceName) + 2;
    }

    public String toString()
    {
        return faceName + " of " + suit;
    }
}
