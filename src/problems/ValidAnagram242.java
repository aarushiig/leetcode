package problems;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

// DIFFICULTY   : Easy
// TOPICS       : Hash Table, String, Sorting
public class ValidAnagram242 {
    public static void main(String[] args) {
        System.out.printf("IS ANAGRAM?: %s %s %s%n", isAnagramUsingFrequencyArrays("anagram", "nagaram"), isAnagramUsingHashMaps("anagram", "nagaram"), isAnagramUsingSorting("anagram", "nagaram"));
        System.out.printf("IS ANAGRAM?: %s %s %s%n", isAnagramUsingFrequencyArrays("rat", "car"), isAnagramUsingHashMaps("rat", "car"), isAnagramUsingSorting("rat", "car"));
    }

    /* CONSTRAINTS: 1 <= s.length, t.length <= 5 * 10^4
                    s and t consist of lowercase English letters. */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static boolean isAnagramUsingFrequencyArrays(String s, String t) {
        if (s.length() != t.length()) return false;

        int[] sCharacterCounter = new int[26];

        for (int i = 0; i < s.length(); i++) {
            sCharacterCounter[s.charAt(i) - 'a']++;
        }

        int[] tCharacterCounter = new int[26];
        for (int i = 0; i < t.length(); i++) {
            tCharacterCounter[t.charAt(i) - 'a']++;
        }

        for (int i = 0; i < 26; i++) {
            if (sCharacterCounter[i] != tCharacterCounter[i]) return false;
        }

        return true;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static boolean isAnagramUsingHashMaps(String s, String t) {
        if (s.length() != t.length()) return false;

        Map<Character, Integer> sCharacterFrequency = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            sCharacterFrequency.put(s.charAt(i), sCharacterFrequency.getOrDefault(s.charAt(i), 0) + 1);
        }

        Map<Character, Integer> tCharacterFrequency = new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            tCharacterFrequency.put(t.charAt(i), tCharacterFrequency.getOrDefault(t.charAt(i), 0) + 1);
        }

        return sCharacterFrequency.equals(tCharacterFrequency);
    }

    // TIME COMPLEXITY  : O(n.logn)
    // SPACE COMPLEXITY : O(n)
    private static boolean isAnagramUsingSorting(String s, String t) {
        if (s.length() != t.length()) return false;

        char[] sCharacterArray = s.toCharArray();
        Arrays.sort(sCharacterArray);

        char[] tCharacterArray = t.toCharArray();
        Arrays.sort(tCharacterArray);

        for (int i = 0; i < s.length(); i++) {
            if (sCharacterArray[i] != tCharacterArray[i]) return false;
        }

        return true;
    }
}
