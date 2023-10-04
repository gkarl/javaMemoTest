package com.tuto.game;

import java.util.Random;

public class GuessingGame {

    private final int randomNumber = new Random().nextInt(10) + 1; //Lesson 100 ** Comme ça le nbre random n'est généré qu'une fois et la methode guess() le nbre peut etre trouvé | autre solution le mettre dans un constructeur pour que ce nbre soit crée à la création d'une instance
    private int counter = 0; // Lesson 102 **

    // Avec la methodologie TDD (test driven design) nous essayons de ne pas écrire plus de code réel que ce dont nous avons absolument besoin pour que le test passe.
    public String guess(int guessedNumber) {
        counter++;  // counte le nbre de tentatives
        if (counter == 4 && guessedNumber != getRandomNumber()) { // Lesson 102 ** 4 est le nbre d'essais max Game Over
            return "Vous n'avez pas trouvé le bon chiffre et vous c'est votre 4em essaie. Game over";
        }
        String trytext = counter == 1 ? "try" : "tries";
        String winningMsg = String.format("Vous avez trouvé le bon chiffre in %d %s", counter, trytext);
        // return guessedNumber >= 0 ? "Vous avez trouvé le bon chiffre" : "Vous n'avez pas trouvé le bon chiffre"; // methode simple pour que le test testOneWrongNegGuessSituation passe
        return guessedNumber == getRandomNumber() ? winningMsg : "Vous n'avez pas trouvé le bon chiffre"; // Lesson 99 ** methode simple pour que le test testOneWrongGuessSituation + testOneWrongPosGuessSituation passe | le test 1 ne passe plus car on cherche une égalité sur 2 random number => solution créer 1 field qui va contenir la génération de nobre random
    }


    public int getRandomNumber() {
        // return new Random().nextInt(10) + 1; // nextInt() => peut prendre en arg une  borne supérieure (bound) ex 10 [0-9] +1 => [1-10]
        return randomNumber;
    }
}
