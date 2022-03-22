package com.example.a2_cards_deck;

import androidx.annotation.NonNull;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Objects;

public class CardB {
    public static Map<Integer, String> rankParser;
    public static HashSet<String> legitSuits;
    public static Map<String, Integer> suitsStrength;
    static {
        rankParser = new HashMap<Integer, String>();
        rankParser.put(11, "Jack");
        rankParser.put(12, "Queen");
        rankParser.put(13, "King");
        rankParser.put(14, "Ace");

        legitSuits = new HashSet<String>();
        legitSuits.add("spades");
        legitSuits.add("diamonds");
        legitSuits.add("clubs");
        legitSuits.add("hearts");

        suitsStrength = new HashMap<String, Integer>();
        suitsStrength.put("hearts", 3);
        suitsStrength.put("spades", 2);
        suitsStrength.put("diamonds", 1);
        suitsStrength.put("clubs", 0);
    }

    private String suit;
    private int rank;

    public CardB(String suit, int rank) throws Exception {
        if (!legitSuits.contains(suit)) {
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

    //Использовал авто-сгенерированные методы, дполняя собственным кодом, потому что почему бы и нет?
    @NonNull
    @Override
    public String toString() {
        String stringRank = (rank >= 11 && rank <= 14) ? rankParser.get(rank) : String.valueOf(rank);
        return "CardB{" +
                "suit='" + suit + '\'' +
                ", rank=" + stringRank +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CardB cardB = (CardB) o;
        return rank == cardB.rank && suit.equals(cardB.suit);
    }

    @Override
    public int hashCode() {
        return Objects.hash(suit, rank);
    }

    public boolean isCardLegit() {
        boolean isJoker = rank == 15 && (suit.equals("spades") || suit.equals("hearts"));
        //Масть проверять не надо, так как создать карту с несуществующей мастью невозможно
        return isJoker || (rank >= 2 && rank <= 14);
    }

    public boolean isStrongerByRanks(CardB card) {
        return rank > card.getRank();
    }

    public int isStronger(CardB card) {
        //Так как создать карту с несуществующей мастью невозможно, исключение вызвано не будет
        int suitDiff = suitsStrength.get(suit) - suitsStrength.get(card.getSuit());
        if (suitDiff != 0) {
            return suitDiff;
        }
        return rank - card.getRank();
    }

    static public int isStronger(CardB firstCard, CardB secondCard) {
        return firstCard.isStronger(secondCard);
    }
}
