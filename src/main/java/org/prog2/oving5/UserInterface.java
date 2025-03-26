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
    HandOfCards handOfCards = new HandOfCards(5);
    //CardGraphic cardGraphic;

    @Override
    public void start(Stage stage) {
        deckOfCards = new DeckOfCards();
        //cardGraphic = new CardGraphic();

        Button dealHandButton = new Button("Deal hand");
        Label handLabel = new Label("Hand: ");
        Label hand = new Label();

        dealHandButton.setOnAction(e -> {
            handOfCards = new HandOfCards(5);
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
            boolean isFlush = handOfCards.checkHand();
            checkHand.setText(isFlush ? "Flush" : "Not flush");
        });

        Button getHeartsButton = new Button("Get Hearts");
        Label getHeartsLabel = new Label("Hearts: ");
        Label getHearts = new Label();

        getHeartsButton.setOnAction(e -> {
            PlayingCard[] hearts = handOfCards.getHearts();
            String heartsString = "";
            for (PlayingCard card : hearts) {
                heartsString += card.getAsString() + " ";
            }
            getHearts.setText(heartsString);
        });

        Button getSumButton = new Button("Get sum");
        Label getSumLabel = new Label("Sum: ");
        Label getSum = new Label();

        getSumButton.setOnAction(e -> {
            int sum = handOfCards.getSum();
            getSum.setText(String.valueOf(sum));
        });

        Button hasS12Button = new Button("Has S12");
        Label hasS12Label = new Label("Has S12: ");
        Label hasS12 = new Label();

        hasS12Button.setOnAction(e -> {
            Boolean testhasS12 = handOfCards.hasS12();
            hasS12.setText(testhasS12 ? "Yes" : "No");
        });

        VBox root = new VBox();
        root.getChildren().addAll(dealHandButton, handLabel, hand,
                checkHandButton, checkHandLabel, checkHand,
                getHeartsButton, getHeartsLabel, getHearts,
                getSumButton, getSumLabel, getSum, hasS12Button, hasS12Label, hasS12);

        Scene scene = new Scene(root, 800, 600);
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}
