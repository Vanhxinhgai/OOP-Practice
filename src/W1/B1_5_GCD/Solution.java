package W1.B1_5_GCD;

public class Solution {
    public static int gcd(int a, int b) {
        a = Math.abs(a);
        b = Math.abs(b);
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public static void main(String[] args) {
        System.out.println("GCD(24, 36): " + gcd(24, 36));     // 12
        System.out.println("GCD(-24, 36): " + gcd(-24, 36));   // 12
        System.out.println("GCD(0, 5): " + gcd(0, 5));         // 5
    }
}
