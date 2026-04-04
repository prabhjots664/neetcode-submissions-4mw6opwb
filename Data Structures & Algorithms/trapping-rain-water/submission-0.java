class Solution {
    public int trap(int[] heights) {
        int n = heights.length;
        int[] leftmaxs = new int[n];
        int[] rightmaxs = new int[n];

        int max = 0;
        for (int i = 0; i < n; i++) {
            leftmaxs[i] = max;
            if(heights[i]>max){
                max = heights[i];
            }
        }

        max = 0;
        for (int i = n-1; i >= 0; i--) {
            rightmaxs[i] = max;
            if(heights[i]>max){
                max = heights[i];
            }
        }

        int totalTrappedWater = 0;
        for (int i = 0; i < n; i++) {
            int minEitherSide = Math.min(leftmaxs[i], rightmaxs[i]);
            if(minEitherSide-heights[i]>0){
                totalTrappedWater += minEitherSide-heights[i];
            }
        }

        return totalTrappedWater;
    }
}
