#include <iostream>
#include <vector>

using namespace std;

class Solution {

public:

    int searchInsert(vector<int>& nums, int target) {
        int lastIndex = (int) nums.size() - 1;

        if (target <= nums[0]) {
            return 0;
        }
        if (target > nums[lastIndex]) {
            return lastIndex + 1;
        }
        return searchIndex(nums, target, 0, lastIndex);
    };

    int searchIndex(vector<int>& nums, int target, int left, int right) {
        int index = (right - left) / 2 + 1;

        int value = nums[index];

        if (value == target) {
            return index;
        }

        if (left == right) {
            return 0;
        }
        if (index > 0) {
            int valueAtLeft = nums[index - 1];

            if (valueAtLeft < target && value > target) {
                return index;
            }
        }
        if (index < nums.size()) {
            int valueAtRight = nums[index + 1];

            if (valueAtRight > target && value < target) {
                return index + 1;
            }
        }
        if (value < target) {
            return searchIndex(nums, target, index, right);
        } else {
            return searchIndex(nums, target, left, index - 1);
        }
    }

};


int main() {


    std::cout << "Hello, World!" << std::endl;
    return 0;
}
