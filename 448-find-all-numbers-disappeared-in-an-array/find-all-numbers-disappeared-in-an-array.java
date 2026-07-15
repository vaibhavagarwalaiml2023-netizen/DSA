import java.util.*;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        List<Integer> ans = new ArrayList<>();

        Arrays.sort(nums);

        int expected = 1;
        int i = 0;

        while (i < nums.length) {
            if (nums[i] == expected) {
                expected++;
                i++;

                // Skip duplicates
                while (i < nums.length && nums[i] == nums[i - 1]) {
                    i++;
                }
            } 
            else if (nums[i] < expected) {
                i++;
            } 
            else { // nums[i] > expected
                ans.add(expected);
                expected++;
            }
        }

        // Add remaining missing numbers
        while (expected <= nums.length) {
            ans.add(expected);
            expected++;
        }

        return ans;
    }
}
