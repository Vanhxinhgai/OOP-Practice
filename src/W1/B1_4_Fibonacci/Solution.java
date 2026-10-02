package W1.B1_4_Fibonacci;

public class Solution {
    public static long fibonacci(long n) {
        if (n < 0) {
            return -1;
        }
        if (n == 0) return 0;
        if (n == 1) return 1;

        long f0 = 0;
        long f1 = 1;
        long fn = 0;

        for (int i = 2; i <= n; i++) {
            // Kiểm tra tràn số trước khi cộng
            if (Long.MAX_VALUE - f1 < f0) {
                return Long.MAX_VALUE;
            }
            fn = f0 + f1;
            f0 = f1;
            f1 = fn;
        }
        return fn;
    }

    public static void main(String[] args) {
        System.out.println("Fibonacci(-5): " + fibonacci(-5));   // -1
        System.out.println("Fibonacci(10): " + fibonacci(10));   // 55
        System.out.println("Fibonacci(50): " + fibonacci(50));   // 12586269025
        System.out.println("Fibonacci(100): " + fibonacci(100)); // Tràn long -> Long.MAX_VALUE
    }
}
