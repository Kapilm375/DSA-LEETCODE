class Solution {
    public int shipWithinDays(int[] weights, int days) {

        int left = 0, right = 0;

        for (int w : weights) {
            left = Math.max(left, w); // minimum capacity
            right += w; // maximum capacity
        }

        while (left < right) {

            int mid = left + (right - left) / 2;

            int need = 1;
            int curr = 0;

            for (int w : weights) {

                if (curr + w > mid) {
                    need++;
                    curr = 0;
                }

                curr += w;
            }

            if (need <= days) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }
}