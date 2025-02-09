package problems;

// DIFFICULTY   : Easy
// TOPICS       : Two Pointers, String
public class ReverseString344 {
    public static void main(String[] args) {
        char[] s1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseString(s1);
        System.out.printf("REVERSED STRING: %s%n", new String(s1));
        s1 = new char[]{'h', 'e', 'l', 'l', 'o'};
        reverseStringUsingRecursion(s1);
        System.out.printf("REVERSED STRING: %s%n%n", new String(s1));

        char[] s2 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        reverseString(s2);
        System.out.printf("REVERSED STRING: %s%n", new String(s2));
        s2 = new char[]{'H', 'a', 'n', 'n', 'a', 'h'};
        reverseStringUsingRecursion(s2);
        System.out.printf("REVERSED STRING: %s%n", new String(s2));
    }

    /* CONSTRAINTS: 1 <= s.length <= 10^5
                    s[i] is a printable ascii character. */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static void reverseString(char[] s) {
        int l = 0, r = (s.length - 1);

        while (l < r) {
            char temp = s[l];
            s[l] = s[r];
            s[r] = temp;

            l++;
            r--;
        }
    }

    // TIME COMPLEXITY  : O()
    // SPACE COMPLEXITY : O()
    private static void reverseStringUsingRecursion(char[] s) {
        reverseStringUsingRecursion(s, 0, (s.length - 1));
    }

    private static void reverseStringUsingRecursion(char[] s, int l, int r) {
        char temp = s[l];
        s[l] = s[r];
        s[r] = temp;

        l++;
        r--;

        if (l < r) reverseStringUsingRecursion(s, l, r);
    }
}
