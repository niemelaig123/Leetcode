package com.company;

import java.util.*;
import java.util.concurrent.TimeUnit;


public class Main {
    public static void main(String[] args) {
        long nanoStart = System.nanoTime();

        int iterations = 100_000;

        for (int i = 0; i < iterations; i++) {
            int[] input = {3, 2, 2, 3};

            int expected = 2;

            int actual = new RemoveElement().removeElement(input, 3);
        }
        long endTime = System.nanoTime();

        long elapsed = endTime - nanoStart;

        long average = elapsed / iterations;

        System.out.printf("Average duration in nano = %s\n", average);
        System.out.printf("Average duration in millis = %s\n", TimeUnit.NANOSECONDS.toMillis(average));
    }

}

class RemoveElement {


    public int removeElement(int[] nums, int val) {
        List<Integer> indexOfOccurrences = new ArrayList<>(nums.length);

        for (int index = nums.length - 1; index > -1; index--) {
            int valueAtIndex = nums[index];

            if (valueAtIndex == val) {
                indexOfOccurrences.add(index);
            }
        }
        int tailLength = nums.length - 1;

        for (int indexOfOccurrence : indexOfOccurrences) { // advanced for-loop
            if (indexOfOccurrence == tailLength) {
                tailLength--;
                continue;
            }
            nums[indexOfOccurrence] = nums[tailLength];
            nums[tailLength] = val;
            tailLength--;
        }
        return nums.length - indexOfOccurrences.size();
    }
}