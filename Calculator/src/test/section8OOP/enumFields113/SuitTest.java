package section8OOP.enumFields113;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class SuitTest {

    @Test
    void heartPrintHeart() {
        Assertions.assertEquals("\u2665", Suit.HEART.toString());
    }
}