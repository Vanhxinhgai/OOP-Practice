package W1.B1_5_GCD;

public class Solution {
    public int gcd(int a, int b) {
        // Thuật toán Euclid
        while (b != 0) {
            int r = a % b;
            a = b;
            b = r;
        }
        return a < 0 ? -a : a; // UCLN luôn không âm
    }

    public static void main(String[] args) {
        Solution s = new Solution();
        System.out.println("gcd(12, 18) = " + s.gcd(12, 18));   // 6
        System.out.println("gcd(17, 5) = " + s.gcd(17, 5));     // 1
        System.out.println("gcd(0, 7) = " + s.gcd(0, 7));       // 7
        System.out.println("gcd(7, 0) = " + s.gcd(7, 0));       // 7
        System.out.println("gcd(0, 0) = " + s.gcd(0, 0));       // 0
        System.out.println("gcd(-12, 18) = " + s.gcd(-12, 18)); // 6
        System.out.println("gcd(-12, -18) = " + s.gcd(-12, -18)); // 6
    }
}
