class Solution {
    public int maxArea(int[] heights) {

        int left=0, right = heights.length-1;
        int maxArea = 0;
        
        while(left<right){
            int min = Math.min(heights[left], heights[right]);
            int area = min*(right-left);
            if(area>maxArea){
                maxArea = area;
            }
            if(heights[left]==min){
                left++;
            } else {
                right--;
            }
        }

        return maxArea;
    }
}
