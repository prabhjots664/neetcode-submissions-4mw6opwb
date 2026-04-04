class Solution {
    public int climbStairs(int n) {

        int[] arr = new int[n+1];
        Arrays.fill(arr, -1);
        
        return waysToClimbStairs(n, arr);

    }

    public int waysToClimbStairs(int n, int [] arr) {
        if(n==0) return 0;
        if(n==1) return 1;
        if(n==2) return 2;
        
        if(arr[n]!=-1) return arr[n];
        
        arr[n] = waysToClimbStairs(n-1, arr) + waysToClimbStairs(n-2, arr);
        return arr[n];
    }
}
