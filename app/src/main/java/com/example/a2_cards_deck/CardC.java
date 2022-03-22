package com.example.a2_cards_deck;

public class CardC {
    private String suit;
    private int rank;

    static int spadesMaxRank = 1;
    static int diamondsMaxRank = 1;
    static int clubsMaxRank = 1;
    static int heartsMaxRank = 1;

    public CardC(String suit, int rank) throws Exception {
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

    public CardC(String suit) throws Exception {
        if (!suit.equals("spades") &&
                !suit.equals("diamonds") &&
                !suit.equals("clubs") &&
                !suit.equals("hearts")) {
            System.out.println("Такой масти нет!");
            throw new Exception("Такой масти нет!");
        }
        this.suit = suit;
        if (suit.equals("spades")) {
            rank = spadesMaxRank++;
        }
        if (suit.equals("diamonds")) {
            rank = spadesMaxRank++;
        }
        if (suit.equals("clubs")) {
            rank = spadesMaxRank++;
        }
        if (suit.equals("hearts")) {
            rank = spadesMaxRank++;
        }
    }

    public String getSuit() {
        return this.suit;
    }
    public int getRank() {
        return this.rank;
    }
}
