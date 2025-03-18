package org.prog2.oving5;
import java.util.Random;

public class DeckOfCards {
    private final char[] suit = { 'S', 'H', 'D', 'C' };
    private final int[] rank = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13};
    private final PlayingCard[] deck = new PlayingCard[52];

    public DeckOfCards() {
        for (int i = 0; i < 52; i++) {
            deck[i] = new PlayingCard(suit[i / 13], rank[i % 13]);
        }
    }

    public PlayingCard[] DealHand(int n) {
        PlayingCard[] hand = new PlayingCard[n];
        shuffle();
        for (int i = 0; i < n; i++) {
            PlayingCard randomCard = deck[i];
            hand[i] = randomCard;

        }
        return hand;

    }

    public void shuffle() {
        Random rand = new Random();
        for (int i = 0; i < 52; i++) {
            int randomIndex = rand.nextInt(52);
            PlayingCard temp = deck[i];
            deck[i] = deck[randomIndex];
            deck[randomIndex] = temp;
        }
    }
}
