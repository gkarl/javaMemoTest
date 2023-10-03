package com.tuto.calculator;


import org.junit.jupiter.api.Assertions; // j'ai utilisé https://start.spring.io/ pour générer pom.xml | pb import Junit depuis ProjectStructure => assertEquals
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Disabled;
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

    @BeforeEach // Annotation va s'executé juste avant chaque @Test
    void setUp() {  // clic D calc / Refactor / Introduce field / setup
        calc = new Calculator(); // Crée une instance de la Class Calculator pour chaque test mais sur le meme field = Référence la 1ere address pour pointer vers la 2em => Evite que cette variable stocke des valeurs (states) qui pourrait affecter le test suivant
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
    @Test
    @Disabled // Junit 5 désactive ce test évite de supprimer ce code pour que les test marche | Junit 4 @Ignore
    public void canAddMaxIntPlusOne() {
        // Calculator calc = new Calculator(); // instance de la class Calculator
        int sum = calc.add(Integer.MAX_VALUE,1); // Il essaie de faire un test d'un cas extreme ou il depasse de +1 la valeur max d'un int => devient un nbre négatif
        System.out.println(sum); // -2147483647
        Assertions.assertEquals(Integer.MAX_VALUE + 1L, sum); // L => il met le +1 long pour convertir ce nbre en long et pouvoir dépasser la valeur limite des int | Erreur test plante => -2147483647/2147483647
    }

    //_____________________Lesson 97 - Testing Annuity Calculation___________________________
    @Test
    public void annuityExample1() {
        String answer = calc.calcAnnuity("22000", 7, ".06", 1); // utilise un site internet csus.educ avec la formule et des exemples de calcules qui nous serve pour ce test TDD (crée tout le test avant de créer la methode à tester)| R = dépos fait chaque année | t = durant 7 ans | r = compte rémunéré à 6% | n = compounded annually
        Assertions.assertEquals("$184,664.43", answer); // combien aura-t-elle déposé au bout de 7 ans ? $184,664.43
    }
    @Test
    public void annuityExample2() {
        String answer = calc.calcAnnuity("1200", 10, ".08", 4); // utilise un site internet csus.educ exemple 2
        Assertions.assertEquals("$72,482.38", answer);
    }


}
