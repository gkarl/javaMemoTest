package com.tuto.game;

public class GuessingGame {

    //_____________________Lesson 98 - Reimplementing the Guessing Game with TDD___________________________
    // Avec la methodologie TDD (test driven design) nous essayons de ne pas écrire plus de code réel que ce dont nous avons absolument besoin pour que le test passe.
    public String guess(int guessedNumber) {
        // return guessedNumber >= 0 ? "Vous avez trouvé le bon chiffre" : "Vous n'avez pas trouvé le bon chiffre"; // methode simple pour que le test testOneWrongNegGuessSituation passe
        return guessedNumber == getRandomNumber() ? "Vous avez trouvé le bon chiffre" : "Vous n'avez pas trouvé le bon chiffre"; // methode simple pour que le test testOneWrongGuessSituation + testOneWrongPosGuessSituation passe
    }

    public int getRandomNumber() {
        return 0;
    }
}
