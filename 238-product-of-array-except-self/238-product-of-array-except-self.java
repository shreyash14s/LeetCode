class Solution {
    public int[] productExceptSelf(int[] nums) {
        // int[] prefix = new int[nums.length];
        // int[] suffix = new int[nums.length];
        int[] ans = new int[nums.length];
        
//         prefix[0] = nums[0];
//         suffix[nums.length-1] = nums[nums.length-1];
        
//         for (int i = 1; i < nums.length; i++) {
//             prefix[i] = prefix[i-1] * nums[i];
//             suffix[nums.length-i-1] = suffix[nums.length-i] * nums[nums.length-i-1];
//         }
        
//         ans[0] = suffix[1];
//         ans[nums.length-1] = prefix[nums.length-2];
        
//         for (int i = 1; i < nums.length-1; i++) {
//             ans[i] = prefix[i-1] * suffix[i+1];
//         }

        int pre = 1, suf = 1;

        for (int i = 0; i < nums.length; i++) {
            ans[i] = 1;
        }
        for (int i = 0; i < nums.length-1; i++) {
            ans[i] = ans[i] * pre;
            ans[nums.length-1-i] = ans[nums.length-1-i] * suf;
            pre = pre * nums[i];
            suf = suf * nums[nums.length-1-i];
        }
        ans[0] = suf;
        ans[nums.length-1] = ans[nums.length-1] * pre;
        
        return ans;
    }
}