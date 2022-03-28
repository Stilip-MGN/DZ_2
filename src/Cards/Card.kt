package Cards

import java.util.*

class Card(suit: Suit, rank: Int) : Comparable<Card> {
    private val suit: Suit
    private val rank: Int

    init {
        this.suit = suit
        this.rank = rank
    }

    fun getSuit() = suit

    fun getRank() = rank

    fun isBelongsStandardDeck() =
        if (rank in 1..12)
            true
        else
            rank == 14 && (suit == Suit.spades || suit == Suit.hearts)

    fun isStrongerThan(c2: Card): Boolean {
        return if (rankToString() == "Joker") {
            true
        } else if (c2.rankToString() == "Joker") {
            false
        } else if (suit !== c2.suit) {
            false
        } else if (rank == c2.rank) {
            false
        } else if (rank == 1 && c2.rank < 14) {
            true
        } else if (c2.rank == 1 && rank < 14) {
            false
        } else {
            rank > c2.rank
        }
    }

    override fun toString(): String {
        return "Cards.Card{suit=$suit, rank=${rankToString()}}"
    }

    override fun equals(other: Any?): Boolean {
        return if (this === other) {
            true
        } else if (other != null && this::class.java == other::class.java) {
            val card = other as Card
            rank == card.rank && suit === card.suit
        } else {
            false
        }
    }

    override fun hashCode(): Int {
        return Objects.hash(suit, rank)
    }

    override fun compareTo(c2: Card): Int {
        val _c1 = suitOrder(suit)
        val _c2 = suitOrder(c2.suit)
        return if (_c1 > _c2) {
            1
        } else if (_c1 < _c2) {
            -1
        } else if (isStrongerThan(c2)) {
            1
        } else {
            if (c2.isStrongerThan(this)) -1 else 0
        }
    }

    private fun rankToString(): String {
        return when (rank) {
            1 -> "Ace"
            11 -> "Jack"
            12 -> "Queen"
            13 -> "King"
            14 -> {
                if (suit === Suit.spades || suit === Suit.hearts) {
                    "Joker"
                } else rank.toString()
            }
            else -> rank.toString()
        }
    }

    private fun suitOrder(suit: Suit): Int {
        return when (suit) {
            Suit.clubs -> 0
            Suit.diamonds -> 1
            Suit.spades -> 2
            else -> 3
        }
    }
}