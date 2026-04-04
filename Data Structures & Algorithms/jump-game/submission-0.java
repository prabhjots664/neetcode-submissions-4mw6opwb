class Solution {
    public boolean canJump(int[] nums) {

        for (int i = nums.length-2; i >=0; i--) {
            if(nums[i]==0){
                boolean flag = false;
                int steps=0;
                while(i>0){
                    i--;
                    steps++;
                    if(nums[i]>steps){
                        flag = true;
                        break;
                    }
                }
                if(flag==false){
                    return false;
                }
                i++;
            }
        }
        return true;
    }
}
