package W1.B1_7_daosoZ;

public class Solution {
    public static int reverse(int n) {
        long reversed = 0;
        int temp = n;

        while (temp != 0) {
            int pop = temp % 10;
            reversed = reversed * 10 + pop;
            temp /= 10;
        }
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) {
            return 0;
        }
        return (int) reversed;
    }
    public static void main(String[] args) {
        System.out.println("reverse(123): " + reverse(123));       // 321
        System.out.println("reverse(-123): " + reverse(-123));     // -321
        System.out.println("reverse(120): " + reverse(120));       // 21
        System.out.println("reverse(1000000009): " + reverse(1000000009)); // Tràn int -> 0
    }
}
