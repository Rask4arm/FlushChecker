package org.prog2.oving5;


import java.util.Arrays;

public class HandOfCards {
    private PlayingCard[] hand;
    private int handSize;
    public DeckOfCards deckOfCards = new DeckOfCards();

    public HandOfCards(int size) {
        this.handSize = size;
        hand = deckOfCards.DealHand(handSize);
        /**
         tested that it works with the following code
         PlayingCard[] handOfCardss = new PlayingCard[5];
        handOfCardss[0] = new PlayingCard('S', 5);
        handOfCardss[1] = new PlayingCard('S', 6);
        handOfCardss[2] = new PlayingCard('S', 7);
        handOfCardss[3] = new PlayingCard('S', 8);
        handOfCardss[4] = new PlayingCard('S', 9);
        this.hand = handOfCardss;

        */
    }

    public PlayingCard[] getHand() {
        return hand;
    }

    public boolean checkHand() {
        boolean isFlush = (Arrays.stream(hand).filter(card -> card.
                getSuit() == hand[0].getSuit()).count() == handSize);
        return isFlush;
    }

    public PlayingCard[] getHearts() {
        PlayingCard[] result = Arrays.stream(hand).filter(card -> card.
                getSuit() == 'H').toArray(PlayingCard[]::new);
        return result;
    }

    public int getSum() {
        int sum = Arrays.stream(hand).mapToInt(PlayingCard::getFace).sum();
        return sum;
    }

    public Boolean hasS12() {
        Boolean hasS12 = Arrays.stream(hand).anyMatch(card -> card.getFace() == 12 && card.getSuit() == 'S');
        return hasS12;
    }
}
