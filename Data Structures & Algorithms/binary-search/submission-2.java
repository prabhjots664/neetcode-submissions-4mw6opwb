class Solution {
     public int search(int[] nums, int target) {
        return recursiveBinarySearch(nums, target, 0, nums.length-1);
    }

    // [-1,0,2,4,6,8]
    private int recursiveBinarySearch(int[] nums, int target, int i, int j) {

        if(i>j) return -1;
        
        int x = i + (j-i)/2;
        if(nums[x]==target){
            return x;
        } else if (nums[x]>target) {
            return recursiveBinarySearch(nums, target, i, x-1);
        } else {
            return recursiveBinarySearch(nums, target, x+1, j);
        }

    }
}
