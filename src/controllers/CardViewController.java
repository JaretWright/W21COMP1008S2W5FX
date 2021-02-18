package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import models.Card;
import models.DeckOfCards;

import java.net.URL;
import java.util.ResourceBundle;

public class CardViewController implements Initializable {
    @FXML
    private Label faceNameLabel;

    @FXML
    private Label suitLabel;

    @FXML
    private Label faceValueLabel;

    @FXML
    private Label colourLabel;

    private DeckOfCards deckOfCards;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        deckOfCards = new DeckOfCards();
        deckOfCards.shuffle();
        getNextCard();
    }

    @FXML
    private void getNextCard()
    {
        Card card = deckOfCards.dealTopCard();
        if (card != null)
        {
            faceNameLabel.setText(card.getFaceName());
            suitLabel.setText(card.getSuit());
            faceValueLabel.setText(Integer.toString(card.getFaceValue()));
            colourLabel.setText(card.getCardColour());
        }
    }
}
