package W1.B1_4_Fibonacci;

public class Solution {
    public static long fibonacci(long n) {
        if (n < 0) return -1;
        if (n == 0) return 0;

        long a = 0, b = 1; // a = F(i-2), b = F(i-1)
        for (long i = 2; i <= n; i++) {
            // Nếu a + b vượt quá Long.MAX_VALUE thì trả về MAX_VALUE
            if (a > Long.MAX_VALUE - b) {
                return Long.MAX_VALUE;
            }
            long c = a + b;
            a = b;
            b = c;
        }
        return b;
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        long[] tests = {-5, 0, 1, 2, 10, 50, 92, 93, 100};
        for (long n : tests) {
            System.out.println("fibonacci(" + n + ") = " + s.fibonacci(n));
        }
    }
}
