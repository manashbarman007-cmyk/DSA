package recursion_and_backtracking;
import java.util.*;

public class Letter_Combination_Leetcode_17 {
    public static void main(String[] args) {
     Letter_Combination_Leetcode_17 obj = new Letter_Combination_Leetcode_17();
        System.out.println(obj.letterCombinations("864"));
    }
    public List< String > letterCombinations(String digits) {
     List< String > list = new ArrayList<>();
     HashMap< Character, String > map = new HashMap<>();
     map.put('2', "abc");
     map.put('3', "def");
     map.put('4', "ghi");
     map.put('5', "jkl");
     map.put('6', "mno");
     map.put('7', "pqrs");
     map.put('8', "tuv");
     map.put('9', "wxyz");
     possibleWords(digits, list, map, "");
     return list;
    }

    static void possibleWords(String digits,List<String> list, HashMap<Character,String> map,String ans){
        if (digits.length() == 0) {
            if(ans != "") {
                list.add(ans);
            }
            return;
        }
        char curDigit = digits.charAt(0);  //eg: the current digit is '8'
        String curAlphabet = map.get(curDigit); //the corresponding alphabet is "tuv"
        for (int i = 0; i < curAlphabet.length(); i++){
            ans += curAlphabet.charAt(i); //we concatenate
            possibleWords(digits.substring(1), list, map, ans);
            ans = ans.substring(0, ans.length() - 1); //to get the original string while backtracking
        }
    }
}
