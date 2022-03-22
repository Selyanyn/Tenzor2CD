package com.example.a2_cards_deck;

import java.util.HashMap;
import java.util.Map;

public class CardC {
    private String suit;
    private int rank;

    static Map<String, Integer> maxRank;
    static {
        maxRank = new HashMap<String, Integer>();
        maxRank.put("spades", 1);
        maxRank.put("diamonds", 1);
        maxRank.put("clubs", 1);
        maxRank.put("hearts", 1);
    }

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
        maxRank.put(suit, maxRank.get(suit) + 1);
        this.rank = maxRank.get(suit);
    }

    public String getSuit() {
        return this.suit;
    }
    public int getRank() {
        return this.rank;
    }
}
