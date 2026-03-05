package recursion_and_backtracking;
import java.util.*;

public class Print_All_Subsequences_GFG {

    public static void main(String[] args) {
        Print_All_Subsequences_GFG obj=new Print_All_Subsequences_GFG();
         obj.printSubsequences("abc","",0);
    }

    public void printSubsequences(String s,String ans,int index) {
        //base case

        if (index==s.length()) {
            System.out.print("\""+ans+"\""+" "); //using excape sequence
            return;
        }
        printSubsequences(s,ans+s.charAt(index),index+1);//recursion call for picking the character
        printSubsequences(s,ans,index+1);//recursion call for not picking the character

    }
}
