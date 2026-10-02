package W1.B1_6_SoNguyento;

public class Solution {
    public static boolean isPrime(int n) {
        if (n <= 1) {
            return false;
        }
        if (n <= 3) {
            return true;
        }
        if (n % 2 == 0 || n % 3 == 0) {
            return false;
        }
        // Kiểm tra đến căn bậc 2 của n theo bước nhảy 6
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) {
                return false;
            }
        }
        return true;
    }
    public static void main(String[] args) {
        System.out.println("isPrime(-5): " + isPrime(-5));   // false
        System.out.println("isPrime(2): " + isPrime(2));     // true
        System.out.println("isPrime(17): " + isPrime(17));   // true
        System.out.println("isPrime(100): " + isPrime(100)); // false
    }
}
