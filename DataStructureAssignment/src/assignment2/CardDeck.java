package assignment2;

import java.util.Arrays;

/**
 * 4- Write a program that will pick four cards at random from a deck of 52 cards.
 */
public class CardDeck {
    public static void main(String[] args) {
        final int RANKS_COUNT = 13;     // card rank (1 ~ 13)
        final int DECK_SIZE = 52;       // card deck size
        String[] suitList = { "Spade", "Heart", "Diamond", "Club" };

        int[] deck = new int[DECK_SIZE];

        // initialize array from 0 to 51
        Arrays.setAll(deck, num -> num++);
        // display initial deck
        System.out.println(Arrays.toString(deck));

        // shuffling array
        for (int i=0; i<DECK_SIZE; i++) {
            int index = (int) (Math.random() * DECK_SIZE);
            // swap value
            int temp = deck[index];
            deck[index] = deck[i];
            deck[i] = temp;
        }
        // display card deck after shuffling
        System.out.println(Arrays.toString(deck));

        // pick first four cards and display information
        System.out.println("\n---------- RESULT ----------");
        for (int i=0; i<4; i++) {
            System.out.format("card %d: %2d %s\n", i+1, deck[i] % RANKS_COUNT + 1, suitList[deck[i] / RANKS_COUNT]);
        }
    }
}
