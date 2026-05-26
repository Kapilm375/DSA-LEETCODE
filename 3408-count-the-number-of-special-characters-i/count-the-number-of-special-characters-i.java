class Solution {

    public int numberOfSpecialChars(String word) {

        HashSet<Character> small = new HashSet<>();
        HashSet<Character> capital = new HashSet<>();

        int index = 0;

        while (index < word.length()) {

            char current = word.charAt(index);

            if (current >= 'a' && current <= 'z') {
                small.add(current);
            } else {
                capital.add((char)(current + 32));
            }

            index++;
        }

        int answer = 0;

        for (char ch : small) {

            if (capital.contains(ch)) {
                answer++;
            }

        }

        return answer;
    }
}