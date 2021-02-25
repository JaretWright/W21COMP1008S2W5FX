package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;
import models.Card;
import models.DeckOfCards;

import java.io.IOException;
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

    @FXML
    private ImageView imageView;

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
            imageView.setImage(card.getCardImage());
        }
    }

    @FXML
    private void goToCardHand(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(getClass().getResource("../views/handOfCardsView.fxml"));
        Scene scene = new Scene(root);
        Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.setTitle("Viewing a hand of cards");
        stage.show();
    }
}
