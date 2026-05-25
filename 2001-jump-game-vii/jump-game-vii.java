class Solution {

    public boolean canReach(String str, int min, int max) {

        int len = str.length();

        boolean visited[] = new boolean[len];
        visited[0] = true;

        int count = 0;
        int i = 1;

        while (i < len) {

            int addIndex = i - min;

            if (addIndex >= 0) {
                if (visited[addIndex] == true) {
                    count++;
                }
            }

            int removeIndex = i - max - 1;

            if (removeIndex >= 0) {
                if (visited[removeIndex] == true) {
                    count--;
                }
            }

            if (count > 0) {

                if (str.charAt(i) == '0') {
                    visited[i] = true;
                }
            }

            i++;
        }

        return visited[len - 1];
    }
}