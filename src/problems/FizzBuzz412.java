package problems;

import java.util.ArrayList;
import java.util.List;

// DIFFICULTY   : Easy
// TOPICS       : Math, String, Simulation
public class FizzBuzz412 {
    public static void main(String[] args) {
        System.out.printf("FIZZBUZZ for 3: %s%n", fizzBuzzUsingStringBuilder(3));
        System.out.printf("FIZZBUZZ for 5: %s%n", fizzBuzzUsingStringBuilder(5));
        System.out.printf("FIZZBUZZ for 15: %s%n", fizzBuzzUsingStringBuilder(15));
    }

    /* CONSTRAINTS: 1<= n <= 10^4 */

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static List<String> fizzBuzzUsingStringBuilder(int n) {
        List<String> answer = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            StringBuilder sb = new StringBuilder();

            if (i % 3 == 0) sb.append("Fizz");
            if (i % 5 == 0) sb.append("Buzz");
            if (sb.isEmpty()) sb.append(i);

            answer.add(sb.toString());
        }

        return answer;
    }

    // TIME COMPLEXITY  : O(n)
    // SPACE COMPLEXITY : O(1)
    private static List<String> fizzBuzzUsingTernaryOperatorChaining(int n) {
        List<String> answer = new ArrayList<>(n);

        for (int i = 1; i <= n; i++) {
            answer.add(i % 15 == 0 ? "FizzBuzz" : i % 5 == 0 ? "Buzz" : i % 3 == 0 ? "Fizz" : String.valueOf(i));
        }

        return answer;
    }
}
