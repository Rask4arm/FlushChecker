package org.prog2.oving5;

public class HandOfCards {
    private String[] hand;
    DeckOfCards deck = new DeckOfCards();

    public HandOfCards(String[] hand) {
        this.hand = hand;
    }

    public void printHand() {
        for (String card : hand) {
            System.out.println(card);
        }
    }

    public void getHand() {
        HandOfCards hand = new HandOfCards(deck.DealHand(5));
        hand.printHand();
    }
}
