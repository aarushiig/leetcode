package problems;

// DIFFICULTY   : Easy
// TOPICS       : Two Pointers, String, String Matching
public class FindTheIndexOfTheFirstOccurrenceInAString28 {
    public static void main(String[] args) {
        System.out.printf("FIRST INDEX: %d\t%d%n", strStrUsingInBuiltFunction("mississippi", "issipi"), strStrUsingTwoPointers("mississippi", "issipi"));
        System.out.printf("FIRST INDEX: %d\t%d%n", strStrUsingInBuiltFunction("abcdefghijklmnopqrstuvwxyz", "z"), strStrUsingTwoPointers("abcdefghijklmnopqrstuvwxyz", "z"));
        System.out.printf("FIRST INDEX: %d\t%d%n", strStrUsingInBuiltFunction("sadbutsad", "sad"), strStrUsingTwoPointers("sadbutsad", "sad"));
        System.out.printf("FIRST INDEX: %d\t%d%n", strStrUsingInBuiltFunction("leetcode", "leeto"), strStrUsingTwoPointers("leetcode", "leeto"));
        System.out.printf("FIRST INDEX: %d\t%d%n", strStrUsingInBuiltFunction("abcdefbcghij", "bc"), strStrUsingTwoPointers("abcdefbcghij", "bc"));
    }

    /* CONSTRAINTS: 1 <= haystack.length, needle.length <= 10^4
                    haystack and needle consist of only lowercase English characters. */

    // TIME COMPLEXITY  : O(m * n)
    // SPACE COMPLEXITY : O(1)
    private static int strStrUsingInBuiltFunction(String haystack, String needle) {
        return haystack.indexOf(needle);
    }

    // TIME COMPLEXITY  : O(m * n)
    // SPACE COMPLEXITY : O(1)
    private static int strStrUsingTwoPointers(String haystack, String needle) {
        if (needle.length() > haystack.length()) return -1;

        for (int h = 0; h <= (haystack.length() - needle.length()); h++) {
            int n;
            for (n = 0; n < needle.length(); n++) {
                if (haystack.charAt(h + n) != needle.charAt(n)) break;
            }

            if (n == needle.length()) return h;
        }

        return -1;
    }
}
