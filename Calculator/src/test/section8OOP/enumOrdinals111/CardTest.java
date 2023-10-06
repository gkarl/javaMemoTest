package section8OOP.enumOrdinals111;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CardTest {

    @Test
    void canGetValueOfATowCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.TWO);
        Assertions.assertEquals(2, card1.getValue());
    }

    @Test
    void canGetValueOfAThreeCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.THREE);
        Assertions.assertEquals(3, card1.getValue());
    }

    @Test
    void canGetValueOfAJackCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.JACK);
        Assertions.assertEquals(10, card1.getValue());
    }

    @Test
    void canGetValueOfAKingCard() {
        Card card1 = new Card(Suit.DIAMONDS, Rank.KING);
        Assertions.assertEquals(10, card1.getValue());
    }
}