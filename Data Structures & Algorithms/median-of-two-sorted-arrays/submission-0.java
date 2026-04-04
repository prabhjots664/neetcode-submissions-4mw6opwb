class Solution {

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    int n = nums1.length + nums2.length;
    return (findkth(nums1, nums2,nums1.length, nums2.length, 0,0, (n+1)/2) + findkth(nums1, nums2,nums1.length, nums2.length, 0,0, (n+2)/2))/2.0;
}

public double findkth(int[] nums1, int[] nums2, int n1, int n2, int start1, int start2, int k) {
    if(n1>n2){
        return findkth(nums2, nums1, n2, n1, start2, start1, k);
    }
    
    if(n1==0){
        return nums2[start2+k-1];
    }
    
    if(k==1){
        return Math.min(nums1[start1], nums2[start2]);
    }
    
    int i = Math.min(k/2,n1);
    int j = Math.min(k/2,n2);
    if(nums1[start1+i-1] < nums2[start2+j-1]){
        return findkth(nums1, nums2, n1-i, n2, start1+i, start2, k-i);
    } else {
        return findkth(nums1, nums2, n1, n2-j, start1, start2+j, k-j);
    }

}
}
