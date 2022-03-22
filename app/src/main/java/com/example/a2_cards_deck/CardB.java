package com.example.a2_cards_deck;

public class CardB {
    private String suit;
    private int rank;

    public CardB(String suit, int rank) throws Exception {
        if (!suit.equals("spades") &&
                !suit.equals("diamonds") &&
                !suit.equals("clubs") &&
                !suit.equals("hearts")) {
            System.out.println("Такой масти нет!");
            throw new Exception("Такой масти нет!");
        }
        this.rank = rank;
        this.suit = suit;
    }

    public String getSuit() {
        return this.suit;
    }
    public int getRank() {
        return this.rank;
    }
}
