package strings;

import java.util.Arrays;

public class Reversing_Words_In_A_String_iii_Leetcode_557 {
    public static void main(String[] args) {
        Reversing_Words_In_A_String_iii_Leetcode_557 obj=new Reversing_Words_In_A_String_iii_Leetcode_557();
        String ex1="Let's take LeetCode contest";
        String ex2="Mr Ding";

        System.out.println(obj.reverseWords(ex1));
        System.out.println(obj.reverseWords(ex2));

    }

    //Non_optimised solution
//    public String reverseWords(String s) {
//
////      StringBuilder sb=new StringBuilder(s);
//        String[] arr=s.split(" ");// using space as delimeter, splitting takes extra time complexity
//        StringBuilder sb=new StringBuilder(); // creating an empty StringBuilder
//
//        for(int i=0;i< arr.length;i++){
//            char[] ch=arr[i].toCharArray(); //converting each String element in the "arr" as char array
//            int n= ch.length;
//            //perform swaps
//            for(int j=0;j<n/2;j++){
//                char temp=ch[j];
//                ch[j]=ch[n-1-j];
//                ch[n-1-j]=temp;
//            }
//            sb.append(ch);
//            if(i< arr.length-1) sb.append(" ");
//        }
//
//        String newS=sb.toString();
//
//        return newS.trim();
//    }


//Optimised  solution
public String reverseWords(String s){
    char[] arr=s.toCharArray();
    int n= arr.length;
    int startPointer=0;
    for(int endPointer=0;endPointer<=n;endPointer++){
        if(endPointer==n || arr[endPointer]==' '){
            //perform swap
            swap(arr,startPointer,endPointer-1);
            startPointer=endPointer+1; //to get to the first index of the next word
        }
    }

    return new String(arr);
}


static void swap(char[] arr,int index1,int index2){
    while(index1<index2){
        char temp=arr[index2];
        arr[index2]=arr[index1];
        arr[index1]=temp;
        index1++;
        index2--;
    }
}
}
