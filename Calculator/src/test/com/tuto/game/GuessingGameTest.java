package com.tuto.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class GuessingGameTest {

    //_____________________Lesson 98 - Reimplementing the Guessing Game with TDD___________________________
    // En TDD on écrit dabord le test
    @Test
    public void testSimpleWinSituation(){
        GuessingGame game = new GuessingGame(); // Crée une instance nommé game de la class GuessingGame
        String message = game.guess(3); // Imagine que l'user devine (guess) le chiffre 3 | passe 3 en arg de la methode guess()
        Assertions.assertEquals("Vous avez trouvé le bon chiffre", message); // Test si la methode guess() return bien "Vous avez trouvé le bon chiffre"
    }


}
