#include <iostream>
#include <vector>
#include <unordered_map>
#include <cassert>


std::vector<int> twoSum(const std::vector<int>& nums, int target) {
    std::cout << "Beginning Two Sum Invocation\n";
    std::unordered_map<int, int> num_map;
    for (int i = 0; i < nums.size(); ++i) {
        int complement = target - nums[i];
        if (num_map.find(complement) != num_map.end()) {
            return {num_map[complement], i};
        }
        num_map[nums[i]] = i;
    }
    return {};
}

void testTwoSum() {
    {
        std::vector<int> nums = {2, 7, 11, 15};
        int target = 9;
        std::vector<int> result = twoSum(nums, target);
        std::vector<int> expected = {0, 1};
        assert(result == expected);
        std::cout << "BasicTest passed\n";
    }
    {
        std::vector<int> nums = {1, 2, 3, 4};
        int target = 8;
        std::vector<int> result = twoSum(nums, target);
        std::vector<int> expected = {};
        assert(result == expected);
        std::cout << "NoSolution passed\n";
    }
    {
        std::vector<int> nums = {3, 2, 4};
        int target = 6;
        std::vector<int> result = twoSum(nums, target);
        std::vector<int> expected = {1, 2};
        assert(result == expected);
        std::cout << "MultipleSolutions passed\n";
    }
    {
        std::vector<int> nums = {1, 2};
        int target = 3;
        std::vector<int> result = twoSum(nums, target);
        std::vector<int> expected = {0, 1};
        assert(result == expected);
        std::cout << "MinimalInput passed\n";
    }
}

int main() {
    std::cout << "Starting Two Sum Tests\n";
    testTwoSum();
    std::cout << "All tests passed!\n";
    return 0;
}