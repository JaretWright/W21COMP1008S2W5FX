package controllers;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
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


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        DeckOfCards deckOfCards = new DeckOfCards();

        faceNameLabel.setText("Jaret's Magic Card");
        suitLabel.setText("Armani");
        faceValueLabel.setText("$1 million");
    }
}
