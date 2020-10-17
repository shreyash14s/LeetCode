class Solution {
    public int search(int[] nums, int target) {
        int l = 0, h = nums.length, mid;
        while (l < h) {
            mid = l + (h - l) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (target < nums[mid]) {
                h = mid;
            } else {
                l = mid + 1;
            }
        }
        return -1;
    }
}
