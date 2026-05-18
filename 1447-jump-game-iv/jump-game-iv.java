import java.util.*;

class Solution {
    public int minJumps(int[] arr) {
        Map<Integer, List<Integer>> map = new HashMap<>();
        for (int i = 0; i < arr.length; i++)
            map.computeIfAbsent(arr[i], k -> new ArrayList<>()).add(i);

        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[arr.length];
        q.offer(0);
        vis[0] = true;

        for (int step = 0; !q.isEmpty(); step++) {
            for (int s = q.size(); s > 0; s--) {
                int i = q.poll();
                if (i == arr.length - 1) return step;

                int[] next = {i - 1, i + 1};

                for (int x : next)
                    if (x >= 0 && x < arr.length && !vis[x]) {
                        vis[x] = true;
                        q.offer(x);
                    }

                for (int x : map.get(arr[i]))
                    if (!vis[x]) {
                        vis[x] = true;
                        q.offer(x);
                    }

                map.get(arr[i]).clear();
            }
        }
        return -1;
    }
}