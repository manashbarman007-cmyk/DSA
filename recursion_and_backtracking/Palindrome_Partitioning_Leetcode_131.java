package recursion_and_backtracking;
import java.util.*;

public class Palindrome_Partitioning_Leetcode_131 {
    public static void main(String[] args) {
        Palindrome_Partitioning_Leetcode_131 obj =new Palindrome_Partitioning_Leetcode_131();
        String ex1="aabb";
        System.out.println(obj.partition(ex1));

    }

    public List<List<String>> partition(String s) {
      List<List<String>> res=new ArrayList<>();
      List<String> subList=new ArrayList<>();
      func(s,res,subList,0);
      return res;
    }

    static void func(String s,List<List<String>> list,List<String> subList,int index){

        int n=s.length();
        //base case
        if(index==n){
            list.add(new ArrayList<>(subList));
            return;
        }

        for(int i=index;i<n;i++){
            if(isPalindrome(s,index,i)){  //this code will execute if isPalindrome==true
                subList.add(s.substring(index,i+1));
                func(s,list,subList,i+1); //recursion call
                subList.remove(subList.size()-1); //remove the last entry of subList while backtracking
            }
        }
    }

    //code to check if string is palindrome
    static boolean isPalindrome(String s,int start,int end){
        while(start<=end){
          if(s.charAt(start)!=s.charAt(end)){
              return false;
          }
          start++;
          end--;
        }

        //if the string is palindrome
        return true;
    }
}
