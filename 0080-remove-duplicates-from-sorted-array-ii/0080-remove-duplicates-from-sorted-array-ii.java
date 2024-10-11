class Solution {
    public int removeDuplicates(int[] nums) {
        int index=1;
        for(int i=2;i<nums.length;i++){
            if(index>1 && nums[index-2]!=nums[i]) {
                nums[++index]=i;
            }
        }
        return index+1;
    }
}