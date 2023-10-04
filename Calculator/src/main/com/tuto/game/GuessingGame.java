package com.tuto.game;

import java.util.Random;

public class GuessingGame {

    private final int randomNumber = new Random().nextInt(10) + 1; //Lesson 100 ** Comme ça le nbre random n'est généré qu'une fois et la methode guess() le nbre peut etre trouvé | autre solution le mettre dans un constructeur pour que ce nbre soit crée à la création d'une instance
    private int counter = 0; // Lesson 102 **

    // Avec la methodologie TDD (test driven design) nous essayons de ne pas écrire plus de code réel que ce dont nous avons absolument besoin pour que le test passe.
    public String guess(int guessedNumber) {
        counter++;  // counte le nbre de tentatives
        String trytext = counter == 1 ? "try" : "tries";
        String winningMsg = String.format("Vous avez trouvé le bon chiffre in %d %s", counter, trytext);
        String reponse = null; // Lesson 103 ** Eviter d'avoir plusieurs return dans la meme methode => ils les met dans une variable un return à la fin affiche la variable qui répond à la condition
        if (counter == 4 && guessedNumber != getRandomNumber()) { // Lesson 102 ** 4 est le nbre d'essais max Game Over
            reponse = String.format("Vous n'avez pas trouvé le bon chiffre et c'est votre %dem %s. Game over", counter, trytext);
        } else if (counter > 4) {
            reponse = "Vous n'avez pas trouvé le bon chiffre c'est à 4em tries. Game over"; // Lesson 103
        } else {
            String tooLowHightText = null;
            if (guessedNumber < getRandomNumber()) { // Lesson 104 Si user essai un nbre plus petit que le nbre random à deviner
                tooLowHightText = "- you're too low";
            } else if (guessedNumber > getRandomNumber()) {
                tooLowHightText = "- you're to high";
            } else {
                tooLowHightText = "";
            }
            String loseText = String.format("Vous n'avez pas trouvé le bon chiffre %s", tooLowHightText);
            // return guessedNumber >= 0 ? "Vous avez trouvé le bon chiffre" : "Vous n'avez pas trouvé le bon chiffre"; // methode simple pour que le test testOneWrongNegGuessSituation passe
            reponse = guessedNumber == getRandomNumber() ? winningMsg : loseText.trim(); // Lesson 99 ** Ternaire si nbre deviné égale nbre random = true => return texte winningMsg si non texte loseText  methode simple pour que le test testOneWrongGuessSituation + testOneWrongPosGuessSituation passe | le test 1 ne passe plus car on cherche une égalité sur 2 random number => solution créer 1 field qui va contenir la génération de nobre random | trim()  => vire espace debut et fin d'un string
        }
        return reponse;
    }


    public int getRandomNumber() {
        // return new Random().nextInt(10) + 1; // nextInt() => peut prendre en arg une  borne supérieure (bound) ex 10 [0-9] +1 => [1-10]
        return randomNumber;
    }
}
