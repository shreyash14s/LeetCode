class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int prod = 1, prev = 0, cnt = 0;
        for (int i = 0; i < nums.length; i++) {
            prod *= nums[i];
            // if (prod >= k) {
                while (prev < i && prod >= k) {
                    prod /= nums[prev];
                    prev++;
                    // System.out.println(prev + " " + i + " " + prod);
                }
            // }
            if (prod < k) {
                cnt += i - prev + 1;
                // System.out.println(prev + " " + i + " " + prod + " " + cnt);
            }
        }
        return cnt;
    }
}