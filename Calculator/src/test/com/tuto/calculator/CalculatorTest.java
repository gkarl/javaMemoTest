package com.tuto.calculator;


import org.junit.jupiter.api.Assertions; // j'ai utilisé https://start.spring.io/ pour générer pom.xml | pb import Junit depuis ProjectStructure => assertEquals
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions.*;

/**
 * Section 7 Testing Code - 94 Our First Test
 *
 * RQ assertEquals() peut prendre un 3em arg = message
 * cela s'avère pratique, en particulier dans les cas où vous pouvez avoir plusieurs assertions dans un seul test méthode
 * et vous souhaitez identifier laquelle des multiples assertions de cette méthode a été en échec
 */
public class CalculatorTest {

    private Calculator calc;

    @BeforeEach // Annotation va s'executé juste avant @Test
    void setUp() {  // clic D calc / Refactor / Introduce field / setup
        calc = new Calculator(); // Crée une instance de la Class Calculator pour chaque test mais sur le meme field = Déférence la 1ere address pour pointer vers la 2em => Evite que cette variable stocke des valeurs (states) qui pourrait affecter le test suivant
    }

    //_____________________Lesson 94 - Our first Test___________________________
    @Test // Framework JUnit scanne le code à la recherche de toutes les methodes annotés => Junit sauras qu'elles méthodes elle doit appeler pour exécuter nos tests
    public void canAddZeroPlusZero() {
        int sum = calc.add(0,0); // depuis instance calc lance la methode add() et stock le return dans la variable sum
        Assertions.assertEquals(0, sum); // assertEquals => 1er arg = ce que j'attend comme value comparé avec 2em arg = la valeur de la variable qui stock le return de la methode add() de l'instance calc de la class Calculator => si égal true si non false | peut prendre un 3em arg commentaire
    }

    //_____________________Lesson 95 - Writting the second Test___________________________
    @Test
    public void canAddOnePlusOne() {
        // Calculator calc = new Calculator(); // instance de la class Calculator
        int sum = calc.add(1,1);
        Assertions.assertEquals(2, sum);
    }

    //_____________________Lesson 96 - Testing Edge Cases___________________________
    /*@Test
    public void canAddMaxIntPlusOne() {
        // Calculator calc = new Calculator(); // instance de la class Calculator
        int sum = calc.add(Integer.MAX_VALUE,1); // Il essaie de faire un test d'un cas extreme ou il depasse de +1 la valeur max d'un int => devient un bre négatif et son test plante
        System.out.println(sum); // -2147483647
        Assertions.assertEquals(Integer.MAX_VALUE + 1L, sum); // L => il met le +1 long pour convertir ce nbre en long et pouvoir dépasser la valeur limite des int | Erreur => -2147483647/2147483647
    }*/


}
