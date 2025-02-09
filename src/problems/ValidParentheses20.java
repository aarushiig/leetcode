package problems;

import java.util.Stack;

// DIFFICULTY   : Easy
// TOPICS       : String, Stack
public class ValidParentheses20 {
    public static void main(String[] args) {
        System.out.printf("IS VALID?: %s %s%n", isValid("["), isValidTypeTwo("["));
        System.out.printf("IS VALID?: %s %s%n", isValid("]"), isValidTypeTwo("]"));
        System.out.printf("IS VALID?: %s %s%n", isValid("]["), isValidTypeTwo("]["));
        System.out.printf("IS VALID?: %s %s%n", isValid("()"), isValidTypeTwo("()"));
        System.out.printf("IS VALID?: %s %s%n", isValid("()[]{}"), isValidTypeTwo("()[]{}"));
        System.out.printf("IS VALID?: %s %s%n", isValid("(]"), isValidTypeTwo("(]"));
        System.out.printf("IS VALID?: %s %s%n", isValid("(]"), isValidTypeTwo("(]"));
        System.out.printf("IS VALID?: %s %s%n", isValid("([])"), isValidTypeTwo("([])"));
        System.out.printf("IS VALID?: %s %s%n", isValid("([}}])"), isValidTypeTwo("([}}])"));
    }

    /* CONSTRAINTS: 1 <= s.length <= 10^4
                    s consists of parentheses only '()[]{}'. */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static boolean isValid(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char parentheses = s.charAt(i);

            if (parentheses == '(' || parentheses == '[' || parentheses == '{') stack.push(parentheses);
            else {
                if (stack.isEmpty() ||
                        (stack.peek() != '(' && parentheses == ')') ||
                        (stack.peek() != '[' && parentheses == ']') ||
                        (stack.peek() != '{' && parentheses == '}')) {
                    return false;
                }

                stack.pop();
            }
        }

        return stack.isEmpty();
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(n)
    private static boolean isValidTypeTwo(String s) {
        if (s.length() % 2 != 0) return false;

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char parentheses = s.charAt(i);

            if (parentheses == '(') stack.push(')');
            else if (parentheses == '[') stack.push(']');
            else if (parentheses == '{') stack.push('}');
            else {
                if (stack.isEmpty() || stack.pop() != parentheses) return false;
            }
        }

        return stack.isEmpty();
    }
}
