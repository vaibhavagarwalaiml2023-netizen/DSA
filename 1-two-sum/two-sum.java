class Solution {
    public int[] twoSum(int[] nums, int target) {
        // First loop iterates through every number except the last one
        for (int i = 0; i < nums.length - 1; i++) {
            // Second loop looks at every number AFTER the index 'i'
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] + nums[j] == target) {
                    return new int[] { i, j }; // Returns the indices immediately
                }
            }
        }
        // Return an empty array if no solution is found (though the problem says one always exists)
        return new int[] {}; 
    }
}