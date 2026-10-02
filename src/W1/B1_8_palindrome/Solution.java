package W1.B1_8_palindrome;

public class Solution {
    public static boolean isPalindrome(int n) {
        if (n < 0) {
            return false;
        }
        long reversed = 0;
        int temp = n;
        while (temp > 0) {
            reversed = reversed * 10 + temp % 10;
            temp /= 10;
        }
        return n == reversed;
    }
    public static void main(String[] args) {
        System.out.println("isPalindrome(121): " + isPalindrome(121));   // true
        System.out.println("isPalindrome(-121): " + isPalindrome(-121)); // false
        System.out.println("isPalindrome(10): " + isPalindrome(10));     // false
    }
}
