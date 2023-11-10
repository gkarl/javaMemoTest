package section9Collection.aMapScenario155;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 *  Etape 1 On creé le test qui verifie si on passe le firstName Flinston on obtiend bien son salaire qui est de 16000
 *  => pour ça on a besoin de créer la methode getSalaryMap dans le main()
 */
class MainTest {

    @Test
    public void testNametoSalary() {
        Main main = new Main();   // il instancie la class Main
        main.main(new String[0]); // Il veut accéder à la methode main() dans le Main mais elle prend en arg un array de type String => il en instancie un vide
        int salary = main.getSalaryMap("Flinston");  // On commence par mettre cette methode getSalaryMap() qu'on va crée ensuite dans le main() | on passe en arg de cette methode le lastName "Flinston" qui est dans notre data texte
        assertEquals(16000, salary); // on s'attend à ce que la methode getSalaryMap() retourne 16000 de salire pour cet employee
    }

}