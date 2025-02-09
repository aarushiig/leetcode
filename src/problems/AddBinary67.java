package problems;

// DIFFICULTY   : Easy
// TOPICS       : Math, String, Bit Manipulation, Simulation
public class AddBinary67 {
    public static void main(String[] args) {
        System.out.printf("%s + %s = %s%n", "11", "1", addBinaryUsingSimulation("11", "1"));
        System.out.printf("%s + %s = %s%n%n", "11", "1", addBinaryUsingMath("11", "1"));

        System.out.printf("%s + %s = %s%n", "1010", "1011", addBinaryUsingSimulation("1010", "1011"));
        System.out.printf("%s + %s = %s%n%n", "1010", "1011", addBinaryUsingMath("1010", "1011"));

        System.out.printf("%s + %s = %s%n", "0", "0", addBinaryUsingSimulation("0", "0"));
        System.out.printf("%s + %s = %s%n%n", "0", "0", addBinaryUsingMath("0", "0"));

        System.out.printf("%s + %s = %s%n", "1", "0", addBinaryUsingSimulation("1", "0"));
        System.out.printf("%s + %s = %s%n%n", "1", "0", addBinaryUsingMath("1", "0"));

        System.out.printf("%s + %s = %s%n", "0", "1", addBinaryUsingSimulation("0", "1"));
        System.out.printf("%s + %s = %s%n%n", "0", "1", addBinaryUsingMath("0", "1"));

        System.out.printf("%s + %s = %s%n", "1", "1", addBinaryUsingSimulation("1", "1"));
        System.out.printf("%s + %s = %s%n%n", "1", "1", addBinaryUsingMath("1", "1"));
    }

    /* CONSTRAINTS: 1 <= a.length, b.length <= 10^4
                    a and b consist only of '0' or '1' characters.
                    Each string does not contain leading zeros except for the zero itself. */

    // TIME COMPLEXITY  : O(max(m, n))
    // SPACE COMPLEXITY : O(1)
    private static String addBinaryUsingSimulation(String a, String b) {
        char[] cc = new char[Math.max(a.length(), b.length()) + 1];
        int i = (a.length() - 1), j = (b.length() - 1), k = (cc.length - 1), carryover = 0;
        
        while (i >= 0 && j >= 0 && k >= 0) {
            if (a.charAt(i) == '0' && b.charAt(j) == '0') {
                if (carryover == 0) {
                    cc[k] = '0';
                } else {
                    cc[k] = '1';
                    carryover = 0;
                }
            } else if ((a.charAt(i) == '0' && b.charAt(j) == '1') || (a.charAt(i) == '1' && b.charAt(j) == '0')) {
                if (carryover == 0) {
                    cc[k] = '1';
                } else {
                    cc[k] = '0';
                }
            } else {
                if (carryover == 0) cc[k] = '0';
                else cc[k] = '1';

                carryover = 1;
            }

            i--;
            j--;
            k--;
        }

        while (i >= 0 && k >= 0) {
            if (a.charAt(i) == '0') {
                if (carryover == 0) cc[k] = '0';
                else {
                    cc[k] = '1';
                    carryover = 0;
                }
            } else {
                if (carryover == 0) cc[k] = '1';
                else cc[k] = '0';
            }

            i--;
            k--;
        }

        while (j >= 0 && k >= 0) {
            if (b.charAt(j) == '0') {
                if (carryover == 0) cc[k] = '0';
                else {
                    cc[k] = '1';
                    carryover = 0;
                }
            } else {
                if (carryover == 0) cc[k] = '1';
                else cc[k] = '0';
            }

            j--;
            k--;
        }

        if (k >= 0 && carryover == 1) {
            cc[k] = '1';
        }

        return new String(cc).trim();
    }

    // TIME COMPLEXITY  : O(max(m, n))
    // SPACE COMPLEXITY : O(1)
    private static String addBinaryUsingMath(String a, String b) {
        int i = (a.length() - 1), j = (b.length() - 1), carryover = 0;

        StringBuilder c = new StringBuilder();
        while (i >= 0 || j >= 0 || carryover == 1) {
            if (i >= 0) carryover += a.charAt(i--) - '0';
            if (j >= 0) carryover += b.charAt(j--) - '0';

            c.append(carryover % 2);
            carryover /= 2;
        }

        return c.reverse().toString();
    }
}
