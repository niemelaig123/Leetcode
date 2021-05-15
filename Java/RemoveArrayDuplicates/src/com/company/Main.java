package com.company;

public class Main {

    public int removeDuplicates(int[] nums) {
        int duplicates = 0;

        for (int i = 0; i < nums.length - 1;) {
            if (nums[i] == nums[i+1]) {
                duplicates++;

                for (int j = i + 1; j < nums.length - 1; j++) {
                    int leftTemp = nums[j];

                    if (nums[j + 1] < leftTemp) {
                        break;
                    }
                    nums[j] = nums[j + 1];
                    nums[j + 1] = leftTemp;
                }
            }
            if (i >= nums.length - 1 - duplicates) {
                break;
            }

            if (nums[i] != nums[i + 1]) {
                i++;
            }
        }
        return nums.length - duplicates;
    }
    public static void main(String[] args) {
	// write your code here
    }
}
