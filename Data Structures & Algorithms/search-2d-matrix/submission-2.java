class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int[] arr = new int[matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            arr[i] = matrix[i][0];
        }
        int rowNum = Arrays.binarySearch(arr, target);
        System.out.println("rowNum: " + rowNum);
        if(rowNum>=0){
            return true;
        }
        int actualRowNum = -rowNum-1-1;
        System.out.println("actualRowNum: " + actualRowNum);
        if(actualRowNum<0){
            return false;
        }
        int val = Arrays.binarySearch(matrix[actualRowNum], target);
        System.out.println("val: " + val);
        if(val>=0){
            return true;
        }
        return false;
    }
}
