package com.tuto.game;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;


public class GuessingGameTest {

    private GuessingGame game;

    @BeforeEach // Annotation va s'executé juste avant chaque @Test
    void setUp() { // // clic D calc / Refactor / Introduce field / setup
        game = new GuessingGame(); // Crée une instance de la Class GuessingGame pour chaque test | on fait ce choix car on veut que cette class génére un nbre random différent pour chaque test
    }

    //_____________________Lesson 98 - Reimplementing the Guessing Game with TDD___________________________
    // En TDD on écrit dabord le test
    @Test
    public void testSimpleWinSituation(){ // test le cas ou user trouve le nbre
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum); // Imagine que l'user devine (guess) le random number | guess() => affiche un message si nbre trouvé ou pas
        Assertions.assertEquals("Vous avez trouvé le bon chiffre", message); // Test si la methode guess() return bien "Vous avez trouvé le bon chiffre"
    }

    //_____________________Lesson 99 - Guessing Game TDD Part Two___________________________
    @Test
    public void testOneWrongNegGuessSituation(){ // test le cas ou user donne un nbre négatif et ne trouve pas le nbre
        //GuessingGame game = new GuessingGame(); // Refactorisation
        String message = game.guess(-5); // Imagine que l'user devine (guess) le chiffre -5 => on est sur qu'il sera faut car notre moteur de random produira un chiffre entre 1 et 10
        Assertions.assertEquals("Vous n'avez pas trouvé le bon chiffre", message); // Test si la methode guess() return bien "Vous n'avez pas trouvé le bon chiffre"
    }

    @Test
    public void testOneWrongPosGuessSituation(){ // test le cas ou user donne un nbre positif et ne trouve pas le nbre
        //GuessingGame game = new GuessingGame(); // Refactorisation
        int randomNum = game.getRandomNumber();
        String message = game.guess(randomNum + 1); // Imagine que l'user devine (guess) presque le bon nbre  + 1
        Assertions.assertEquals("Vous n'avez pas trouvé le bon chiffre", message); // Test si la methode guess() return bien "Vous n'avez pas trouvé le bon chiffre"
    }

    //_____________________Lesson 99 - Lesson 100 Implementing Randomness**___________________________
    @Test
    public void testRandomNumberGeneration(){ // test si notre methode getRandomNumber() est vraiment efficace et génére un nbre aléatoire égalemnt distribué
        int[] rndNumCount = new int[11]; // On crée un Array avec 10 élément de type int => il met 11 au final car si non la 2em boucle for nous crée un outbound
        for (int counter=0; counter < 50; counter++) { // on va bouclé 100 fois | ** grace à l'annotation @RepeatTest(10) à la place de @Test => ça répéte le test 10 fois pour voire si il passe à chaque fois il a pus déterminer que bouclé 50 fois suffisait pour que tous les éléments de l'arrays soit à 1
            GuessingGame game = new GuessingGame(); //** Pour que le test passe on crée une instance que pour ce test => recrée un random nbre à chaque tour de boucle | si non on aurait eu tjrs le meme random nbre du fait qu'on l'ai mis en field dans la class GuessingGame
            int randomNum = game.getRandomNumber();  // sur la methode getRandomNumber() et on va stocker sa valeur dans la variable randomNumrndNumCounrndNumCount
            rndNumCount[randomNum] = 1; // getRandomNumber() génére un nbre de 1 à 10 qui correspond à l'index de notre Array rndNumCount => qd un nbre est sorti par notre moteur de random il lui assigne la valeur 1 correspondant dans notre Array
        }
        int sum = 0;
        for (int counter=0; counter < 11; counter++) { // il boucle 10 fois
            sum += rndNumCount[counter]; // sur notre Array qui contiend 10 élément avec des valeur 0 ou 1 pour les additionner
        }
        Assertions.assertEquals(10, sum); // il s'attend à avoir 10 from sum => si c'est le cas getRandomNumber() a un bon moteur de random les chiffre sont produit de façon équivalente car tous les flafg de notre Array on été allumé aprés avoir lancé la methode 100 fois
    }


}
