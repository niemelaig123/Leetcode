def two_sum(nums, target):
    print("Beginning Two Sum Invocation")
    num_map = {}
    for i, num in enumerate(nums):
        complement = target - num
        if complement in num_map:
            return [num_map[complement], i]
        num_map[num] = i
    return []

def test_two_sum():
    # Basic Test
    nums = [2, 7, 11, 15]
    target = 9
    result = two_sum(nums, target)
    expected = [0, 1]
    assert result == expected, f"Expected {expected}, but got {result}"
    print("BasicTest passed")

    # No Solution Test
    nums = [1, 2, 3, 4]
    target = 8
    result = two_sum(nums, target)
    expected = []
    assert result == expected, f"Expected {expected}, but got {result}"
    print("NoSolution passed")

    # Multiple Solutions Test
    nums = [3, 2, 4]
    target = 6
    result = two_sum(nums, target)
    expected = [1, 2]
    assert result == expected, f"Expected {expected}, but got {result}"
    print("MultipleSolutions passed")

    # Minimal Input Test
    nums = [1, 2]
    target = 3
    result = two_sum(nums, target)
    expected = [0, 1]
    assert result == expected, f"Expected {expected}, but got {result}"
    print("MinimalInput passed")

if __name__ == "__main__":
    print("Starting Two Sum Tests")
    test_two_sum()
    print("All tests passed!")