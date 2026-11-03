class Solution {
    public String countAndSay(int n) {

        String s = "1";

        for(int i = 1; i < n; i++) {

            int count = 1;
            StringBuilder ans = new StringBuilder();

            for(int j = 0; j < s.length() - 1; j++) {

                if(s.charAt(j) == s.charAt(j + 1)) {
                    count++;
                }
                else {
                    ans.append(count);
                    ans.append(s.charAt(j));
                    count = 1;
                }
            }

            ans.append(count);
            ans.append(s.charAt(s.length() - 1));

            s = ans.toString();
        }

        return s;
    }
}