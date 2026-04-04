class Solution {
    public int search(int[] nums, int target) {
        int x = Arrays.binarySearch(nums, target);
        return x>=0 ? x : -1;
    }
}
