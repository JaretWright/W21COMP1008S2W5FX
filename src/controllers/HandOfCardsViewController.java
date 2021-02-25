package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import models.DeckOfCards;

import java.net.URL;
import java.util.ResourceBundle;

public class HandOfCardsViewController implements Initializable {
    @FXML
    private ImageView card1ImageView;

    @FXML
    private ImageView card2ImageView;

    @FXML
    private ImageView card3ImageView;

    @FXML
    private ImageView card4ImageView;

    @FXML
    private ImageView card5ImageView;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DeckOfCards deck = new DeckOfCards();
        deck.shuffle();
        card1ImageView.setImage(deck.dealTopCard().getCardImage());
        card2ImageView.setImage(deck.dealTopCard().getCardImage());
        card3ImageView.setImage(deck.dealTopCard().getCardImage());
        card4ImageView.setImage(deck.dealTopCard().getCardImage());
        card5ImageView.setImage(deck.dealTopCard().getCardImage());
        //small change
    }
}
