package com.Federico;

import java.util.ArrayList;
import java.util.Collections;

public class Deck
{

    public ArrayList<Card> cards;

    public Deck()
    {
        this.cards = new ArrayList<>();


        String[] suits = {"Diamonds", "Hearts", "Clubs", "Spades"};

        // Initialize a card variable.
        Card card;

        // For each suit,
        for (String suit : suits)
        {
            // create the necessary cards for that suit. Since all twos are removed, and aces are valued at 11,
            // start the counter at 3.
            for (int x = 3; x < 12; x++)
            {
                card = new Card(suit, x);

                // The Ace of Spades is also removed, so if the card is not the Ace of Spades, add it.
                if (!card.toString().equals("Ace of Spades"))
                { this.cards.add(card); }
            }
        }
    }

    public void shuffle()
    {
        // Shuffle the deck using Collections.
        Collections.shuffle(this.cards);
    }

    public void deal(Player playa)
    {

        for (int x = 0; x < 6; x++)
        {

                playa.hand.add(this.cards.get(0));
                this.cards.remove(0);

        }
    }
}

