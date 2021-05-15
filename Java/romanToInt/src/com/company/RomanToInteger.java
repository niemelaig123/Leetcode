package com.company;

import java.util.Map;

public class RomanToInteger {

    private static final Map<Character, Integer> ROMAN_CHARACTERS = Map.of(
            'I', 1,
            'V', 5,
            'X', 10,
            'L', 50,
            'C', 100,
            'D', 500,
            'M', 1000
    );


    /**
     * for each index in the character array
     *      get the value at current index
     *      if the current index is length - 1 or less
     *          get the value at next index
     *      if the value at next is > the value at current
     *          the upper range is the first index + current index
     *      convert current value to numerical and add to accumulator/sum
     *          add condition if next value is same
     *          I can be placed before V (5) and X (10) to make 4 and 9.
     *      X can be placed before L (50) and C (100) to make 40 and 90.
     *      C can be placed before D (500) and M (1000) to make 400 and 900.
     *
     */
    public int romanToInt(String s) {
        char[] characters = s.toCharArray();

        int totalSum = 0;

        for(int i = 0; i < s.length(); i++) {
            int numericalValueAtIndex = ROMAN_CHARACTERS.get(characters[i]);

            if (i == s.length() - 1) {
                totalSum += numericalValueAtIndex;
                break;
            }
            int numericalValueAtNext = ROMAN_CHARACTERS.get(characters[i + 1]);

            if (numericalValueAtNext > numericalValueAtIndex) {
                int difference = numericalValueAtNext - numericalValueAtIndex;

                if (difference % 4 == 0 || difference % 9 == 0) {
                    totalSum += difference;
                    i++;
                    continue;
                }
            }
            totalSum += numericalValueAtIndex;
        }
        return totalSum;
    }
}
