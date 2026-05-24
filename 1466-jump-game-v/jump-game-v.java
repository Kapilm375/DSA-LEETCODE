class Solution {

    int[] memo;
    int n;

    public int maxJumps(int[] arr, int d) {

        n = arr.length;
        memo = new int[n];

        int max = 1;

        for (int i = 0; i < n; ++i) {
            max = Math.max(max, solve(arr, d, i));
        }

        return max;
    }

    private int solve(int[] arr, int d, int index) {

        if (memo[index] > 0) {
            return memo[index];
        }

        int result = 1;

        int left = Math.max(0, index - d);
        int right = Math.min(n - 1, index + d);

        for (int i = index - 1; i >= left; --i) {

            if (arr[i] >= arr[index]) {
                break;
            }

            result = Math.max(result, solve(arr, d, i) + 1);
        }

        for (int i = index + 1; i <= right; ++i) {

            if (arr[i] >= arr[index]) {
                break;
            }

            result = Math.max(result, solve(arr, d, i) + 1);
        }

        memo[index] = result;

        return result;
    }
}