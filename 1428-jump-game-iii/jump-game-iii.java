class Solution {

    public boolean canReach(int[] arr, int start) {

        // Invalid index
        if (start < 0 || start >= arr.length) {
            return false;
        }

        // Already visited
        if (arr[start] < 0) {
            return false;
        }

        // Reached zero
        if (arr[start] == 0) {
            return true;
        }

        int jump = arr[start];

        arr[start] = -arr[start];
        return canReach(arr, start + jump) ||
               canReach(arr, start - jump);
    }
}