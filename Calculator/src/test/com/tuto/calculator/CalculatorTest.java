package com.tuto.calculator;


import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.Assertions.*;

public class CalculatorTest {

    @Test
    public void canZeroPlusZero() {
        Calculator calc = new Calculator();
        int sum = calc.add(0,0);
        Assertions.assertEquals(0, sum);
    }


}
