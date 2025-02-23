import java.util.ArrayList;
import java.util.List;

class Solution {
    private static final String[] VOWELS = {"A", "E", "I", "O", "U"};
    private static List<String> wordList;

    public int solution(String targetWord) {
        wordList = new ArrayList<>();
        generateWords("", 0);

        for (int index = 0; index < wordList.size(); index++) {
            if (wordList.get(index).equals(targetWord)) {
                return index;
            }
        }
        return -1;
    }

    private static void generateWords(String currentWord, int length) {
        wordList.add(currentWord);
        if (length == 5) return;

        for (String vowel : VOWELS) {
            generateWords(currentWord + vowel, length + 1);
        }
    }
}
