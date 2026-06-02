class Solution {
    public boolean isPalindrome(String s) {
     s = s.toLowerCase().replaceAll("[^a-z0-9]","");
     StringBuilder rev = new StringBuilder();
     for (int i =s.length()-1; i>=0; i--){
        rev.append(s.charAt(i));
        }
        return s.equals(rev.toString());
    }
}
    
