package problems;

// DIFFICULTY   : Easy
// TOPICS       : Two Pointers, String
public class ReverseVowelsOfAString345 {
    public static void main(String[] args) {
        System.out.printf("REVERSED STRING: %s%n", reverseVowels("IceCreAm"));
        System.out.printf("REVERSED STRING: %s%n", reverseVowels("leetcode"));
    }

    /* CONSTRAINTS: 1 <= s.length <= 3 * 10^5
                    s consist of printable ASCII characters. */

    // TIME COMPLEXITY  : O()
    // SPACE COMPLEXITY : O()
    private static String reverseVowels(String s) {
        int l = 0, r = (s.length() - 1);
        char[] sArray = s.toCharArray();

        while (l < r) {
            if ((isVowel(sArray[l])) && (isVowel(sArray[r]))) {
                char temp = sArray[l];
                sArray[l] = sArray[r];
                sArray[r] = temp;

                l++;
                r--;
            } else if (!isVowel(sArray[l])) {
                l++;
            } else if (!isVowel(sArray[r])) {
                r--;
            }
        }

        return new String(sArray);
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u' || c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U';
    }
}
