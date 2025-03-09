package org.prog2.oving5;
import java.util.Random;

public class DeckOfCards {
    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private final char[] rank = { 'A', '2', '3', '4', '5', '6', '7', '8', '9', 'T', 'J', 'Q', 'K' };
    private final String[] deck = new String[52];

    public DeckOfCards() {
        for (int i = 0; i < 52; i++) {
            deck[i] = "" + rank[i % 13] + suit[i / 13];
        }
    }

    public String[] DealHand(int n) {
        String[] hand = new String[n];
        shuffle();
        for (int i = 0; i < n; i++) {
            String randomCard = deck[i];
            hand[i] = randomCard;

        }
        return hand;

    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            int randomIndex = rand.nextInt(52);
            String temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }
}
