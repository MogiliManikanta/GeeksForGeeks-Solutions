class Solution {
    public boolean canSortArray(int[] nums) {
        boolean flag = true;
        int count[] = new int[101],j = 0, n = nums.length, k = 0, i = 1;

        while (j < nums.length && flag) {
            count[j++] = setbits(nums[j - 1], flag);
        }

        while (k < nums.length && flag) {
            i = 1;
            while (i < n && flag) {
                if (flag && count[i - 1] == count[i] && nums[i] < nums[i - 1]) {
                    int temp = nums[i];
                    nums[i] = nums[i-1];
                    nums[i-1] = temp;
                }
                i=i+1;
            }

            if (check(nums, flag) && flag) {
                return true;
            }

            k=k+1;
        }

        return false;
    }

    public boolean check(int nums[], boolean flag) {
        int i = 0, n = nums.length - 1;

        while (i < n && flag) {
            if (nums[i] > nums[1 + i]) {
                return false;
            }
            i = i + 1;
        }

        return true;
    }

    public int setbits(int num, boolean flag) {
        int c = 0, i = 31;

        while (i >= 0 && flag) {
            if (1 == ((num >> i) & 1) && flag) {
                c = c + 1;
            }
            i = i - 1;
        }

        return c;
    }
}
