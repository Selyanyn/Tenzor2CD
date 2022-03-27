package com.example.a2_cards_deck

class CardBKT(private val suit: String, private val rank: Int) : Comparable<CardBKT> {
    val rankParser: MutableMap<Int, String> = hashMapOf(11 to "Jack", 12 to "Queen", 13 to "King", 14 to "Ace")
    val suitsStrength: MutableMap<String, Int> = hashMapOf("spades" to 2, "diamonds" to 1, "clubs" to 0, "hearts" to 3)

    init {
        if (!suitsStrength.containsKey(suit)) {
            throw Exception("Такой масти нет!")
        }
    }

    override fun toString(): String {
        val stringRank = if (rank in 11..14) rankParser[rank] else rank
        return "CardB{" +
                "suit='" + suit + '\'' +
                ", rank=" + stringRank +
                '}'
    }

    override fun hashCode(): Int {
        return super.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (other == null || javaClass != other.javaClass) return false
        val cardB = other as CardB
        return rank == cardB.rank && suit == cardB.suit
    }

    fun isCardLegit(): Boolean {
        val isJoker = rank == 15 && (suit == "spades" || suit == "hearts")
        return isJoker || rank in 2..14
    }

    fun isStrongerByRanks(card: CardBKT): Boolean {
        return rank > card.rank
    }

    //Нет необходимости в методе сравнивания карт по силе, т. к. он совпадает с методом CompareTo

    override fun compareTo(other: CardBKT): Int {
        val suitDiff = suitsStrength[suit]!!.minus(suitsStrength[other.suit]!!)
        if (suitDiff != 0) {
            return suitDiff
        }
        return rank - other.rank
    }

}