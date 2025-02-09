package problems;

// DIFFICULTY   : Easy
// TOPICS       : Array, Matrix
public class RichestCustomerWealth1672 {
    public static void main(String[] args) {

    }

    /* CONSTRAINTS: m == accounts.length
     *              n == account[i].length
     *              1 <= m, n <= 50
     *              1 <= accounts[i][j] <= 100 */

    // TIME COMPLEXITY  : O(m x n)
    // SPACE COMPLEXITY : O(1)
    private static int maximumWealth(int[][] accounts) {
        int richestCustomerWealth = 0;

        for (int[] customer : accounts) {
            int customerWealth = 0;
            for (int bank : customer) {
                customerWealth += bank;
            }

            richestCustomerWealth = Math.max(customerWealth, richestCustomerWealth);
        }

        return richestCustomerWealth;
    }
}
