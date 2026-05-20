class Solution {
    public List<Integer> findClosestElements(int[] arr, int k, int x) {

        int left = 0, right = arr.length - 1;

        List<Integer> res = new ArrayList<>();

        if (k == arr.length) {
            for (int ele : arr) {
                res.add(ele);
            }
            return res;
        }

        // find the next element greater than or equal to x
        while (left < right) {
            int mid = left + (right - left) / 2;

            if (arr[mid] >= x) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        // T: O(log n + k), S: O(1)

        left = right - 1;

        // find the starting left
        int i = 0;

        while (i < k) {

            if (left == -1) {
                right = right + 1;

            } else if (right == arr.length) {
                left = left - 1;

            } else if (Math.abs(arr[right] - x) < Math.abs(arr[left] - x)) {
                right = right + 1;

            } else {
                left = left - 1;
            }

            i = i + 1;
        }

        for (int j = left + 1; j < right; j = j + 1) {
            res.add(arr[j]);
        }

        return res;
    }
}