package com.example.a2_cards_deck;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {
    private ArrayList<CardB> deck;
    private Deck(boolean withJokers) throws Exception {
        for (String suit: CardB.legitSuits) {
            for (int rank = 2; rank <= 14; rank++) {
                deck.add(new CardB(suit, rank));
            }
        }
        if (withJokers) {
            deck.add(new CardB("spades", 15));
            deck.add(new CardB("hearts", 15));
        }
    }

    public static Deck createDeck() throws Exception {
        return new Deck(false);
    }
    public static Deck createDeckWithJokers() throws Exception {
        return new Deck(true);
    }

    public static CardB getRandomCard(Deck deck) {
        return deck.deck.get((int)(Math.random() * deck.deck.size()));
    }

    public void shuffleDeck() {
        Collections.shuffle(deck);
    }

    public void sortDeck() {
        Collections.sort(deck);
    }

    public CardB dealCard() {
        CardB card = deck.get(0);
        deck.remove(0);
        return card;
    }

    public void addCard(CardB card) {
        if (deck.contains(card)) {
            System.out.println("The card already in a deck!");
            return;
        }
        deck.add(card);
    }

    public boolean isEmpty() {
        return deck.isEmpty();
    }

    @NonNull
    @Override
    public String toString() {
        return "Deck{" +
                "deck=" + deck +
                '}';
    }
}
