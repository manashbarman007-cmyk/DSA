package strings;

import java.util.Arrays;

public class Reversing_A_String {
    public static void main(String[] args) {
       String ex1=new String("ABCDEF");
//       StringBuilder ex2=new StringBuilder("MANASH");
       toReverseString(ex1);
//       toReverseString(ex2);
//       String name="MANASH";
//       char[] arr=name.toCharArray();
//        System.out.println(Arrays.toString(arr));
    }


    static void toReverseString(String ref){

        //converting the String into a StringBuilder
        StringBuilder refNew=new StringBuilder(ref);
        int n=refNew.length();
        //perform swaps
        for(int i=0;i<n/2;i++){
            char temp=refNew.charAt(n-1-i);
            refNew.setCharAt(n-1-i, refNew.charAt(i));
            refNew.setCharAt(i, temp);
        }
        System.out.println(refNew);
    }
}
