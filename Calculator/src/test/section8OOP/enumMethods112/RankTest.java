package section8OOP.enumMethods112;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RankTest {

    @Test
    void getValueOfKing() {
        Assertions.assertEquals(10, Rank.KING.getValue());  // Rank.KING => c'est un racourcit permis par class Enum équivalent à créer une instance Rank KING = new Rank("KING") | s'attend à ce que la valeur d'un roi (King) soit 10
    }
}