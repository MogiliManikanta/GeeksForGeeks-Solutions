class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
        int n=nums.length;
        for(int i=0;i<n;i++){
            int complete = target-nums[i];
            if(map.containsKey(complete)){
                return new int[]{map.get(complete),i};
            } 
            map.put(nums[i],i);
        }
        return new int[]{};
    }
}

[![Video Title](https://img.youtube.com/vi/VIDEO_ID/0.jpg)](https://www.youtube.com/watch?v=VIDEO_ID)
