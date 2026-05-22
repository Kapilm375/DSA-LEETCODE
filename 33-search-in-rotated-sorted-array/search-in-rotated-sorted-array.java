class Solution {
     public int search(int[] nums, int target) {
        int L = nums.length;
        if (L == 0) return -1;

        return searchHelper(nums, target, 0, L-1);
    }

    private int searchHelper(int[] nums, int target, int s, int e) {
        if (s > e) return -1;

        int mid = (e-s)/2 + s;
        if (nums[mid] == target) {
            return mid;
        }

        if (nums[s] < nums[e] && (nums[s] > target || nums[e] < target)) {
            return -1;
        }

        if (nums[s] > nums[e] && target < nums[s] && nums[e] < target) {
            return -1;
        }

        int left = searchHelper(nums, target, s, mid-1);
        if (left != -1) return left;

        return searchHelper(nums, target, mid+1, e);
    }
}