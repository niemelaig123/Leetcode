package com.company;


import java.util.Map;


public class Main {

    public static void main(String[] args) {
        String result = new IntegerToRoman().integerToRoman(1994);

        System.out.println(result);
    }
}

class IntegerToRoman {

    // III = 3
    // IV = 4
    // IX = 9
    // LVIII = 58
    // MCMXCIV = 1994

    //    I             1
    //    V             5
    //    X             10
    //    L             50
    //    C             100
    //    D             500
    //    M             1000

    // constraints
    //      { i <= i < 4000 }
    //

    // i = 1994
    //M = i / 1000 = 1
    // i = 1994 - 1000 = 994
    // i / 500 = 1
    // i = 995 - 500 = 494
    // i / 100 .
    // ...

    // 1885
    // 1889

    // Max/Step

    // Number "Chunks"
    // 1000 - M
    // 900 - CM
    // 500 - D
    // 400 - CD
    // 100 - C
    // 90 - XC
    // 50 - L
    // 40 - XL
    // 10 - X
    // 9 - IX
    // 5 - V
    // 4 - IV
    // 1 - I

    // 1885 - M     DCCC    LXXX    V
    // 1889 - M     DCCC    LXXX    IX
    //        1000  800     80      5
    //        1000  800     80      9


    // if number == 1000    M
    // if number == 900     CM
    // if number == 800     DCCC
    // if number == 700     DCC
    // if number == 600     DC

    // if number == 500     D
    // if number == 400     CD
    // if number == 300     CCC
    // if number == 200     CC
    // if number == 100     C

    // if number > 90 < 100
    // if number > 80 < 90

    private static final Map<Integer, Character> ROMAN_CHARACTERS = Map.of(
            1, 'I',
            5, 'V',
            10, 'X',
            50, 'L',
            100, 'C',
            500, 'D',
            1000, 'M'
    );



    // 9  9  4
    // CM XC IV

    //    I can be placed before V (5) and X (10) to make 4 and 9.
    //    X can be placed before L (50) and C (100) to make 40 and 90.
    //    C can be placed before D (500) and M (1000) to make 400 and 900.

    // LVIII

    public String integerToRoman(int number) {//1994
        StringBuilder roman = new StringBuilder();

        int currentChunk = 1000;
        int priorChunk = 0;
        int step = 0;

        int nineBound = 900;

        int fourBound = 400;

        while (number > 0) {
            int occurrences = number / currentChunk;

            int romanNumericalValue = (currentChunk * occurrences);

            int value = (occurrences * romanNumericalValue);

            if ((number >= nineBound) && (number < priorChunk)) {
                number -= nineBound;
                if (nineBound == 900) {
                    roman.append("CM");
                } else if (nineBound == 90) {
                    roman.append("XC");
                } else if (nineBound == 9) {
                    roman.append("IX");
                }
            } else if ((number >= fourBound) && (number < priorChunk)) {
                number -= fourBound;
                if (fourBound == 400) {
                    roman.append("CD");
                } else if (fourBound == 40) {
                    roman.append("XL");
                } else if (fourBound == 4) {
                    roman.append("IV");
                }
            } else if (number >= currentChunk) {
                number -= value;

                System.out.println(romanNumericalValue);

                char character = ROMAN_CHARACTERS.get(romanNumericalValue);

                roman.append(character);
            } else if (number < currentChunk && number > 0) {
                continue;
            }

            else {
                break;
            }



            int division = step++ % 2 == 1 ? 5 : 2;

            if (division == 2 && step - 1 != 0) {
                nineBound /= 10;
                fourBound /= 10;
            }
            priorChunk = currentChunk;
            currentChunk /= division;

            }



        return roman.toString();
        }

}
