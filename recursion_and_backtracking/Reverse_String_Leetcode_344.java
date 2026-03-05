package recursion_and_backtracking;

import java.util.Arrays;

public class Reverse_String_Leetcode_344 {
    public static void main(String[] args) {
        Reverse_String_Leetcode_344 obj=new Reverse_String_Leetcode_344();
        char[] s={'h','e','l','l','o'};
        obj.reverseString(s);

    }


    //using iterative method
//    public void reverseString(char[] s) {
//        int n=s.length;
//       if(s.length==0){
//           return;
//       }
//       for (int i=0;i<n/2;i++){
//           char temp=s[i];
//           s[i]=s[n-1-i];
//           s[n-1-i]=temp;
//       }
//    }

    //using recursion
    public void reverseString(char[] s){
        recur(s,0,s.length-1);
    }
    static void recur(char[] s,int start,int end){
        if(start>end){ //base case
            return;
        }
        //this part will execute if start<end
        char temp=s[start];
           s[start]=s[end];
           s[end]=temp;

        recur(s,start+1,end-1);   //the recursive function
    }
}
