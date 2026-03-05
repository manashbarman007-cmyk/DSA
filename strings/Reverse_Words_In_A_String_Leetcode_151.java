package strings;

import java.util.Arrays;

public class Reverse_Words_In_A_String_Leetcode_151 {
    public static void main(String[] args) {
        String ex1="   hello   world   ";
        String ex2="    the sky is blue           ";
       Reverse_Words_In_A_String_Leetcode_151 obj=new Reverse_Words_In_A_String_Leetcode_151();
        System.out.println(obj.reverseWords(ex1));
        System.out.println(obj.reverseWords(ex2));
    }

    public String reverseWords(String s) {
         String[] arr=s.split("\\s+");
         //To reverse the array
        int n= arr.length;
        for(int i=0;i<n/2;i++){
            String temp=arr[n-1-i];
            arr[n-1-i]=arr[i];
            arr[i]=temp;
        }
        StringBuilder sb=new StringBuilder();// creating a new empty StringBuffer object
        for(int i=0;i<n;i++){
            sb.append(arr[i]);
            if(i<n-1){
                sb.append(" ");
            }
        }
        String str=sb.toString();
        return str.trim();
    }
}
