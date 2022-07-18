package easy;

import java.util.Arrays;
import java.util.Comparator;
import java.util.function.Predicate;

public class LongestCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) return "";
        if (strs.length == 1) return strs[0];
        Arrays.sort(strs, Comparator.comparingInt(String::length));
        StringBuilder str = new StringBuilder("");
        for (int i = 0; i < strs[0].length(); i++) {
           for(int j = 1; j < strs.length; j++) {
               if ((strs[0].equals("") && !strs[j].equals("")) ||
                       (strs[j].equals("") && !strs[0].equals("")) ||
                       (strs[j].charAt(i) != strs[0].charAt(i))) {
                   return str.toString();
               }
           }
           str.append(strs[0].charAt(i));
        }
        return str.toString();
    }


    public static void main(String[] args) {
        System.out.println(longestCommonPrefix(new String[]{"ab","a"}));;
    }
}
