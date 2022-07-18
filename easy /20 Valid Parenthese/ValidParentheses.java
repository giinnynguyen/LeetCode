package easy;

import java.util.Arrays;
import java.util.Stack;

public class ValidParentheses {

    //code tui, 16ms
    public static boolean isValid(String s) {
        if (s.length() == 1) return false;
        String[] validPair = {"[]","{}","()"};
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char curChar = s.charAt(i);
            if ( curChar == '(' || curChar == '[' || curChar == '{') {
                stack.push(curChar);
            } else {
                if (stack.isEmpty()) {
                    return false;
                } else {
                    char lastCharInStack = stack.pop();
                    if (!Arrays.stream(validPair).anyMatch((""+lastCharInStack + curChar)::equals)) return false;
                }
            }
        }
        return stack.size() == 0;
    }

    //code ngừi ta, 2ms
    public static boolean isValid2(String s) {
        if (s.length() == 1) return false;
        Stack<Character> stack = new Stack();
        for(char c: s.toCharArray()) {
            if(c == ')' && !stack.isEmpty() && stack.peek() == '(') {
                stack.pop();
            }else if(c == '}' && !stack.isEmpty() && stack.peek() == '{') {
                stack.pop();
            }else if(c == ']' && !stack.isEmpty() && stack.peek() == '[') {
                stack.pop();
            }else{
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(isValid("(([]{}))"));
        /*test case
        "()"
        "(]"
        "()[]{}"
        "(([]{}))"
        "["
        "]"
        "(("
        "){"
         */
    }
}
