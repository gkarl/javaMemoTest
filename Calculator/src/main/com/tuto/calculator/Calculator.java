package com.tuto.calculator;

import java.math.BigDecimal;
import java.text.NumberFormat;
import java.util.Locale;

public class Calculator {

    // Lesson 94 - Our first Test + Lesson 95 - Writting the second Test
    public int add(int num1, int num2) {
        return num1 + num2;
    }

    // Lesson 97 - Testing Annuity Calculation
    // Utilise Bigdecimal pour calculer une formule de calcul d'une rente ordinaire ou d'un fonds d'amortissement
    public String calcAnnuity(String R, int t, String r, int n) {
        BigDecimal a = new BigDecimal(r).divide(new BigDecimal(n));
        BigDecimal b = BigDecimal.ONE.add(a);
        BigDecimal c = b.pow(n * t);
        BigDecimal d = c.subtract(BigDecimal.ONE);
        BigDecimal e = d.divide(a);
        BigDecimal f = e.multiply(new BigDecimal(R));
        NumberFormat currencyInstance = NumberFormat.getCurrencyInstance(Locale.US);
        return currencyInstance.format(f);
    }
}
