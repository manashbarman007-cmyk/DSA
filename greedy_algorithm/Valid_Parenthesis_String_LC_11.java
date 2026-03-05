package greedy_algorithm;

import java.util.Stack;

public class Valid_Parenthesis_String_LC_11 {
    public static void main(String[] args) {
        String s1 = "()";
        String s2 = "(*)";
        String s3 = "(*))";
        System.out.println(checkValidString(s1));
        System.out.println(checkValidString(s2));
        System.out.println(checkValidString(s3));
    }

    // recursive solution
//    public static boolean checkValidString(String s) {
//        return func (s, 0, 0);
//    }
//    static boolean func(String s, int ind, int count) { // 'count' keeps a track of the count of (
//        int n = s.length();
//
//        // base case
//        if (ind == n) {
//            if (count == 0) {
//                return true;
//            }
//            else {
//                return false;
//            }
//        }
//        //edge case
//        if (count < 0) {
//            return false;
//        }
//        if (s.charAt(ind) == '(') {
//            return func(s, ind + 1, count + 1);
//        }
//        else if (s.charAt(ind) == ')') {
//            return func(s, ind + 1, count - 1);
//
//        }
//        else { // if (s.charAt(ind) == '*'), there are 3 possibilities
//           return func(s, ind + 1, count + 1) || func(s, ind + 1, count - 1)
//                   || func(s, ind + 1, count);
//        }
//    }


    // Optimal approach
    public static boolean checkValidString(String s) {
        int n = s.length();
        int min = 0, max = 0;
        for (int i = 0; i < n; i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                min = min + 1;
                max = max + 1;
            }
            else if (ch == ')') {
                min = min - 1;
                max = max - 1;
            }
            else { // if ch == '*'
               min = min - 1;
               max = max + 1;
            }
            if (min < 0) {
                min = 0; // make min 0
            }
            if (max < 0) {
                return false; // as string can never be valid
            }
        }
        if (min == 0) {
            return true;
        }
        return false;
    }

}
