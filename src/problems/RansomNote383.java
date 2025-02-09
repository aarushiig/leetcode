package problems;

import java.util.HashMap;
import java.util.Map;

// DIFFICULTY   : Easy
// TOPICS       : Hash Table, String, Counting
public class RansomNote383 {
    public static void main(String[] args) {
        System.out.printf("CAN CONSTRUCT? : %s, %s%n", canConstructUsingArray("a", "b"), canConstructUsingHashMap("a", "b"));
        System.out.printf("CAN CONSTRUCT? : %s, %s%n", canConstructUsingArray("aa", "ab"), canConstructUsingHashMap("aa", "ab"));
        System.out.printf("CAN CONSTRUCT? : %s, %s%n", canConstructUsingArray("aa", "aab"), canConstructUsingHashMap("aa", "aab"));
        System.out.printf("CAN CONSTRUCT? : %s%n", canConstructUsingSubstrings("abc", "baa"));
    }

    /* CONSTRAINTS: 1 <= ransomNote.length, magazine.length <= 10^5
     *              ransomNote and magazine consist of lowercase English letters. */

    /* NOTE:
     * Consider using indexed-for loops to iterate through strings, as it is a constant time operation since strings are indexed arrays.
     * The for-each loop implemented using the toCharArray() function, allocates a new character array which impacts the space complexity.
     * However, it makes the code more readable.
     */

    /* NOTE:
     * The space complexity is influenced by the size of the number of occurrences of each character.
     * Specifically, when dealing with large numbers of character occurrences (like 2^1000), the number of bits required to store those values becomes relevant.
     * So the space complexity is O(k⋅logn)=O(logn).
     */

    // TIME COMPLEXITY  : O(n) where n = magazine.length
    // SPACE COMPLEXITY : O(k.logn) where k <= 26 ~ O(logn)
    private static boolean canConstructUsingArray(String ransomNote, String magazine) {
        int[] alphabetFrequency = new int[26];
        for (char m : magazine.toCharArray()) {
            alphabetFrequency[m - 'a']++;
        }

        for (char rn : ransomNote.toCharArray()) {
            if (alphabetFrequency[rn - 'a'] < 1) {
                return false;
            } else {
                alphabetFrequency[rn - 'a']--;
            }
        }

        return true;
    }

    // TIME COMPLEXITY  : O(n) where n = magazine.length
    // SPACE COMPLEXITY : O(k.logn) where k <= 26 ~ O(logn)
    private static boolean canConstructUsingHashMap(String ransomNote, String magazine) {
        Map<Character, Integer> magazineCF = new HashMap<>();
        for (char m : magazine.toCharArray()) {
            magazineCF.put(m, magazineCF.getOrDefault(m, 0) + 1);
        }

        for (char rn : ransomNote.toCharArray()) {
            if (!magazineCF.containsKey(rn) || magazineCF.get(rn) < 1) return false;
            magazineCF.put(rn, magazineCF.get(rn) - 1);
        }

        return true;
    }

    // TIME COMPLEXITY  : O(m.n) where m = ransomNote.length, n = magazine.length
    // SPACE COMPLEXITY : O(n) (strings are immutable, so we create a copy of magazine whenever we remove a letter)
    private static boolean canConstructUsingSubstrings(String ransomNote, String magazine) {
        for (int i = 0; i < ransomNote.length(); i++) {
            char rn = ransomNote.charAt(i);
            int matchingIndex = magazine.indexOf(rn);

            if (matchingIndex == -1) return false;

            magazine = magazine.substring(0, matchingIndex) + magazine.substring(matchingIndex + 1);
        }

        return true;
    }
}
