class Solution {

    static class Trie {

        Trie[] next = new Trie[26];

        int index;
        int len = Integer.MAX_VALUE;
    }

    public int[] stringIndices(String[] wordsContainer, String[] wordsQuery) {

        Trie root = new Trie();

        int smallest = 0;

        for (int i = 1; i < wordsContainer.length; i++) {

            if (wordsContainer[i].length() < wordsContainer[smallest].length()) {
                smallest = i;
            }
        }

        root.index = smallest;
        root.len = wordsContainer[smallest].length();

        // build reversed trie
        for (int i = 0; i < wordsContainer.length; i++) {

            String s = wordsContainer[i];
            Trie node = root;

            for (int j = s.length() - 1; j >= 0; j--) {

                int c = s.charAt(j) - 'a';

                if (node.next[c] == null) {
                    node.next[c] = new Trie();
                }

                node = node.next[c];

                if (s.length() < node.len) {
                    node.len = s.length();
                    node.index = i;
                }
            }
        }

        int[] ans = new int[wordsQuery.length];

        // process queries
        for (int i = 0; i < wordsQuery.length; i++) {

            String q = wordsQuery[i];

            Trie node = root;

            int res = root.index;

            for (int j = q.length() - 1; j >= 0; j--) {

                int c = q.charAt(j) - 'a';

                if (node.next[c] == null) {
                    break;
                }

                node = node.next[c];

                res = node.index;
            }

            ans[i] = res;
        }

        return ans;
    }
}