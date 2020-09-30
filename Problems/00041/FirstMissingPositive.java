class Solution {
    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] <= 0) {
                nums[i] = nums.length+1;
            }
        }
        // IntStream.of(nums).forEach(x -> System.out.print(x + " "));
        // System.out.println();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] < -nums.length) {
                // nums[i] = -1;
            } else if (nums[i] <= 0) {
                nums[Math.abs(nums[i])-1] = -Math.abs(nums[Math.abs(nums[i])-1]);
            } else if (nums[i] <= nums.length) {
                nums[nums[i]-1] = -Math.abs(nums[nums[i]-1]);
            }
        }
        // IntStream.of(nums).forEach(x -> System.out.print(x + " "));
        // System.out.println();
        int res = 0;
        while (res < nums.length && nums[res] <= 0) res++;
        return res+1;
    }
}
