package strings;

import java.util.Locale;

public class Check_Palindrome_String {
    public static void main(String[] args) {
        String ex1="mADaM";
        String ex2="NItin";
        System.out.println("Is palindrome: "+isPalindrome(ex1));
        System.out.println("Is palindrome: "+isPalindrome(ex2));

    }

    static boolean isPalindrome(String ref){

        //To make case-insensitive
        String ref1=ref.toLowerCase(); //every characters are converted to lower case

        //converting the String into a StringBuilder
        StringBuilder refNew=new StringBuilder(ref1);
        StringBuilder refToCmpare=new StringBuilder(ref1);
        int n=refNew.length();
        //perform swaps to reverse the string
        for(int i=0;i<n/2;i++){
            char temp=refNew.charAt(n-1-i);
            refNew.setCharAt(n-1-i, refNew.charAt(i));
            refNew.setCharAt(i, temp);
        }

        if(refNew.compareTo(refToCmpare)==0){
            return true;
        }

        // return false for non-palindrome String
        return false;
    }
}
