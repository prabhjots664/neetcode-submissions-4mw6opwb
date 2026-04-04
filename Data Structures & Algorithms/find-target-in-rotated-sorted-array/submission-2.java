class Solution {
    public int search(int[] nums, int target) {
        int n = nums.length;        
        int l =0,r = n-1;
        while(l<=r){
            if(target<=nums[r] && nums[l]<=target){
                int[] arr = new int[r-l+1];
                for(int i=l;i<=r;i++){
                    arr[i-l] = nums[i];
                }
                int idx = Arrays.binarySearch(arr, target);
                return idx<0?-1:idx+l;
            }
            int m = l +(r-l)/2;
            if(nums[m]==target){
                return m;
            } else if(nums[l]==target){
                return l;
            } else if(nums[r]==target){
                return r;
            }
            
            if(nums[m]>=nums[l]){
                if(nums[m]>nums[l] && target>=nums[l] && target<=nums[m]){
                    r = m-1;
                } else {
                    l = m+1;
                }
            } else {
                if(nums[r]>nums[m] && target>=nums[m] && target<=nums[r]){
                    l = m+1;
                } else {
                    r = m-1;
                }
            }
        }
        return -1;
    }
}
