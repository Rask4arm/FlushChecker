package org.prog2.oving5;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class UserInterface extends Application{
    DeckOfCards deckOfCards;
    //CardGraphic cardGraphic;

    @Override
    public void start(Stage stage) {
        deckOfCards = new DeckOfCards();
        //cardGraphic = new CardGraphic();

        Button dealHandButton = new Button("Deal hand");
        Label handLabel = new Label("Hand: ");
        Label hand = new Label();

        dealHandButton.setOnAction(e -> {
            HandOfCards handOfCards = new HandOfCards(5);
            PlayingCard[] handArray = handOfCards.getHand();
            String handString = "";
            for (PlayingCard card : handArray) {
                handString += card.getAsString() + " ";
            }
            hand.setText(handString);
        });

        Button checkHandButton = new Button("Check hand");
        Label checkHandLabel = new Label("Check hand: ");
        Label checkHand = new Label();

        checkHandButton.setOnAction(e -> {
            HandOfCards handOfCards = new HandOfCards(5);
            boolean isFlush = handOfCards.checkHand();
            checkHand.setText(isFlush ? "Flush" : "Not flush");
        });

        VBox root = new VBox();
        root.getChildren().addAll(dealHandButton, handLabel, hand, checkHandButton, checkHandLabel, checkHand);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
