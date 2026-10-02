public class Solution {
    public static int sumOfDigits(int n) {
        n = Math.abs(n);
        int sum = 0;
        while (n > 0) {
            sum += n % 10;
            n /= 10;
        }
        return sum;
    }
    public static void main(String[] args) {
        System.out.println("sumOfDigits(1234): " + sumOfDigits(1234));  // 10
        System.out.println("sumOfDigits(-567): " + sumOfDigits(-567));  // 18
        System.out.println("sumOfDigits(0): " + sumOfDigits(0));        // 0
    }
}
