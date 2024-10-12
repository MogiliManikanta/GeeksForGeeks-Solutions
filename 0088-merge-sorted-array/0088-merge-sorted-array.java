class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int p = m+n-1;
        int i=m-1,j=n-1;
        while(i>=0){
            if(j>=0 && nums2[j]<=nums1[i]){
                nums1[p]=nums2[j];
                j--;
                p--;
            }
            else{
                nums1[p]=nums1[i];
                p--;i--;
            }
        }
    }
}