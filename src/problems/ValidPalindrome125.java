package problems;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

// DIFFICULTY   : Easy
// TOPICS       : Two Pointers, String
public class ValidPalindrome125 {
    public static void main(String[] args) {
        System.out.printf("IS PALINDROME?: %s%n", isPalindrome("A man, a plan, a canal: Panama"));
        System.out.printf("IS PALINDROME?: %s%n", isPalindrome("race a car"));
        System.out.printf("IS PALINDROME?: %s%n", isPalindrome(" "));
    }

    /* CONSTRAINTS: 1 <= s.length <= 2 * 10^5
                    s consists only of printable ASCII characters.
    */

    // TIME COMPLEXITY  : O()
    // SPACE COMPLEXITY : O()
    private static boolean isPalindromeUsingTwoPointers(String s) {
        s = s.replaceAll("[^a-zA-Z0-9]*", "").toLowerCase();

        int left = 0, right = (s.length() - 1);
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) return false;

            left++;
            right--;
        }

        return true;
    }

    // TIME COMPLEXITY  : O()
    // SPACE COMPLEXITY : O()
    private static boolean isPalindrome(String s) {
        int left = 0, right = (s.length() - 1);

        while (left < right) {
            if (!Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            } else if (!Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            } else {
                if (Character.toLowerCase(s.charAt(left)) != Character.toLowerCase(s.charAt(right))) return false;
                left++;
                right--;
            }
        }

        return true;
    }
}
