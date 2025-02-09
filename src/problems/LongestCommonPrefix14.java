package problems;

// DIFFICULTY   : Easy
// TOPICS       : String, Trie
public class LongestCommonPrefix14 {
    public static void main(String[] args) {
        String[] strs1 = {"ab", "a"};
        System.out.printf("LONGEST COMMON PREFIX: %s %s %s %s%n", longestCommonPrefixUsingHorizontalStringMatching(strs1), longestCommonPrefixUsingVerticalCharacterMatching(strs1), longestCommonPrefixUsingDivideAndConquer(strs1), longestCommonPrefixUsingBinarySearch(strs1));

        String[] strs2 = {"flower", "flow", "flight"};
        System.out.printf("LONGEST COMMON PREFIX: %s %s %s %s%n", longestCommonPrefixUsingHorizontalStringMatching(strs2), longestCommonPrefixUsingVerticalCharacterMatching(strs2), longestCommonPrefixUsingDivideAndConquer(strs2), longestCommonPrefixUsingBinarySearch(strs2));

        String[] strs3 = {"dog", "racecar", "car"};
        System.out.printf("LONGEST COMMON PREFIX: %s %s %s %s%n", longestCommonPrefixUsingHorizontalStringMatching(strs3), longestCommonPrefixUsingVerticalCharacterMatching(strs3), longestCommonPrefixUsingDivideAndConquer(strs3), longestCommonPrefixUsingBinarySearch(strs3));

        String[] strs4 = {"apple", "applepro", "applepromax"};
        System.out.printf("LONGEST COMMON PREFIX: %s %s %s %s%n", longestCommonPrefixUsingHorizontalStringMatching(strs4), longestCommonPrefixUsingVerticalCharacterMatching(strs4), longestCommonPrefixUsingDivideAndConquer(strs4), longestCommonPrefixUsingBinarySearch(strs4));
    }

    /* CONSTRAINTS: 1 <= strs.length <= 200
                    0 <= strs[i].length <= 200
                    strs[i] consists of only lowercase English letters if it is non-empty. */

    // TIME COMPLEXITY  : O(m * n)
    // SPACE COMPLEXITY : O(1)
    private static String longestCommonPrefixUsingHorizontalStringMatching(String[] strs) {
        String longestCommonPrefix = strs[0];
        int lastIndex = strs[0].length();

        for (int i = 1; i < strs.length; i++) {
            while (strs[i].indexOf(longestCommonPrefix) != 0) {
                longestCommonPrefix = longestCommonPrefix.substring(0, (--lastIndex));
                if (lastIndex == 0) return "";
            }
        }

        return longestCommonPrefix;
    }

    // TIME COMPLEXITY  : O(m * nMIN)
    // SPACE COMPLEXITY : O(1)
    private static String longestCommonPrefixUsingVerticalCharacterMatching(String[] strs) {
        StringBuilder longestCommonPrefix = new StringBuilder();

        int lastIndex = 0;
        while (lastIndex < strs[0].length()) {
            char current = strs[0].charAt(lastIndex);

            for (String str : strs) {
                if (lastIndex == str.length() || str.charAt(lastIndex) != current) {
                    return longestCommonPrefix.toString();
                }
            }

            longestCommonPrefix.append(current);
            lastIndex++;
        }

        return longestCommonPrefix.toString();
    }

    // TIME COMPLEXITY  : O(mMIN * n)
    // SPACE COMPLEXITY : O(n.logm)
    private static String longestCommonPrefixUsingDivideAndConquer(String[] strs) {
        return longestCommonPrefixUsingDivideAndConquer(strs, 0, (strs.length - 1));
    }

    private static String longestCommonPrefixUsingDivideAndConquer(String[] strs, int left, int right) {
        if (left == right) return strs[left];

        int middle = (left + right) / 2;
        String longestCommonPrefixLEFT = longestCommonPrefixUsingDivideAndConquer(strs, left, middle);
        String longestCommonPrefixRIGHT = longestCommonPrefixUsingDivideAndConquer(strs, (middle + 1), right);

        return commonPrefix(longestCommonPrefixLEFT, longestCommonPrefixRIGHT);
    }

    private static String commonPrefix(String a, String b) {
        int minimumLength = Math.min(a.length(), b.length());
        for (int i = 0; i < minimumLength; i++) {
            if (a.charAt(i) != b.charAt(i)) return a.substring(0, i);
        }

        return a.substring(0, minimumLength);
    }

    // TIME COMPLEXITY  : O(m.n.logn)
    // SPACE COMPLEXITY : O(1)
    private static String longestCommonPrefixUsingBinarySearch(String[] strs) {
        int minimumLength = 200;
        for (String str : strs) minimumLength = Math.min(minimumLength, str.length());

        int low = 1;
        int high = minimumLength;
        while (low <= high) {
            int middle = (low + high) / 2;

            if (isCommonPrefix(strs, middle)) low = middle + 1;
            else high = middle - 1;
        }

        return strs[0].substring(0, (low + high) / 2);
    }

    private static boolean isCommonPrefix(String[] strs, int length) {
        String commonPrefix = strs[0].substring(0, length);
        for (int i = 1; i < strs.length; i++) {
            if (!strs[i].startsWith(commonPrefix)) return false;
        }

        return true;
    }
}
