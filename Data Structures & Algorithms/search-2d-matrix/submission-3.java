class Solution {
    public boolean searchMatrix(int[][] grid, int target) {
        int[] arr = new int[grid.length];
        for(int i=0;i<grid.length;i++){
            arr[i] = grid[i][0];
        }

        int midRes = Arrays.binarySearch(arr,target);
        if(midRes>=0){
            return true;
        }

        int row = -midRes-1-1;

        if(row>=0){
            int res = Arrays.binarySearch(grid[row],target);
            if(res>=0){
                return true;
            }
        }

        return false;

    }
}
