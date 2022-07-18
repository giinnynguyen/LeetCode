package easy;

import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;

public class PalindromeNumber {
    //solution 1
    public static boolean isPalindrome(int x) {
        Deque<String> deque = new LinkedList<>();
        String[] array = (x + "").split("");
        deque.addAll(Arrays.asList(array));
        while(!deque.isEmpty()) {
            String first = deque.pollFirst();
            String last = deque.pollLast();
            if (last != null && !first.equals(last)) return false;
        }
        return true;
    }

    //solution 2
    public static boolean isPalindrome2(int x) {
        int originX = x;
        int reverseNum = 0;
        while(x > 0) {
            reverseNum = (reverseNum * 10) + (x % 10);
            x = x / 10;
        }
        return reverseNum == originX;
    }
    public static void main(String[] args) {
        System.out.println(isPalindrome2(454));
    }
}
