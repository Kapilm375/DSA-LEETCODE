class Solution {
    public int[] findThePrefixCommonArray(int[] A, int[] B) {
        int n = A.length;
        int[] ans = new int[n];

        boolean[] seen = new boolean[n + 1];
        int common = 0;

        for (int i = 0; i < n; i++) {

            if (seen[A[i]]) common++;
            else seen[A[i]] = true;

            if (seen[B[i]]) common++;
            else seen[B[i]] = true;

            ans[i] = common;
        }

        return ans;
    }
}