package W1.B1_10_timsolonthu2trongmang;

public class Solution {
    public static int secondLargest(int[] arr) {
        if (arr == null || arr.length < 2) {
            return -1;
        }
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        for (int num : arr) {
            if (num > largest) {
                second = largest;
                largest = num;
            } else if (num < largest && num > second) {
                second = num;
            }
        }
        return (second == Integer.MIN_VALUE) ? -1 : second;
    }
    public static void main(String[] args) {
        System.out.println(secondLargest(new int[]{1, 5, 3, 4, 5}));
        System.out.println(secondLargest(new int[]{10, 10, 10}));
        System.out.println(secondLargest(new int[]{5}));
    }
}
