class Solution {
    public int searchInsert(int[] nums, int target) {

        int start = 0;
        int end = nums.length - 1;

        while (start <= end) {

            int mid = start + (end - start) / 2;

            // Target found
            if (nums[mid] == target) {
                return mid;
            }

            // Target is on the right side
            else if (nums[mid] < target) {
                start = mid + 1;
            }

            // Target is on the left side
            else {
                end = mid - 1;
            }
        }

        // Position where target should be inserted
        return start;
    }
}
