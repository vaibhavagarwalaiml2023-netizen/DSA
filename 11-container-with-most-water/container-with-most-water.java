class Solution {
    public int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;
        
        while (left < right) {
            // Calculate the width between the two pointers
            int width = right - left;
            
            // The height of the water container is limited by the shorter line
            int currentHeight = Math.min(height[left], height[right]);
            
            // Calculate current area and update maxArea if it's larger
            int currentArea = width * currentHeight;
            maxArea = Math.max(maxArea, currentArea);
            
            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        
        return maxArea;
    }
}