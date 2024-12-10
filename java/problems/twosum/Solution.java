import java.util.HashMap;
import java.util.Map;

public class Solution {
    public static int[] twoSum(int[] nums, int target) {
        System.out.println("Beginning Two Sum Invocation");
        Map<Integer, Integer> numMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int complement = target - nums[i];
            if (numMap.containsKey(complement)) {
                return new int[] { numMap.get(complement), i };
            }
            numMap.put(nums[i], i);
        }
        return new int[] {};
    }

    public static void testTwoSum() {
        {
            int[] nums = { 2, 7, 11, 15 };
            int target = 9;
            int[] result = twoSum(nums, target);
            int[] expected = { 0, 1 };
            assert java.util.Arrays.equals(result, expected);
            System.out.println("BasicTest passed");
        }
        {
            int[] nums = { 1, 2, 3, 4 };
            int target = 8;
            int[] result = twoSum(nums, target);
            int[] expected = {};
            assert java.util.Arrays.equals(result, expected);
            System.out.println("NoSolution passed");
        }
        {
            int[] nums = { 3, 2, 4 };
            int target = 6;
            int[] result = twoSum(nums, target);
            int[] expected = { 1, 2 };
            assert java.util.Arrays.equals(result, expected);
            System.out.println("MultipleSolutions passed");
        }
        {
            int[] nums = { 1, 2 };
            int target = 3;
            int[] result = twoSum(nums, target);
            int[] expected = { 0, 1 };
            assert java.util.Arrays.equals(result, expected);
            System.out.println("MinimalInput passed");
        }
    }

    public static void main(String[] args) {
        System.out.println("Starting Two Sum Tests");
        testTwoSum();
        System.out.println("All tests passed!");
    }
}