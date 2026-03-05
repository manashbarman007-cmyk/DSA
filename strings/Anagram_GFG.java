package strings;

import java.util.Arrays;

public class Anagram_GFG {
    public static void main(String[] args) {
        String ex1="geeks";
        String ex2="skege";

        String ex3="allergyz";
        String ex4="allergy";
//        System.out.println(areAnagramsNonOptimised(ex1,ex2));
//        System.out.println(areAnagramsNonOptimised(ex3,ex4));

        System.out.println(areAnagrams(ex1,ex2));
        System.out.println(areAnagrams(ex3,ex4));
    }

    //Non_optimised way
//    public static boolean areAnagramsNonOptimised(String s1, String s2) {
//         char[] arrA=s1.toCharArray();
//         char[] arrB=s2.toCharArray();
//         boolean isAnagram=false;
//         //sort the two arrays
//        Arrays.sort(arrA);
//        Arrays.sort(arrB);
//       if(arrA.length==arrB.length) {
//           for (int i = 0; i < arrA.length; i++) {
//               if (arrA[i] != arrB[i]) {
//                   return false;
//               }
//               else isAnagram=true;
//           }
//       }
//        return isAnagram;
//    }

    //Optimised approach
    public static boolean areAnagrams(String s1, String s2){
        int[] anagramChecker=new int[26]; //initially all the elements are 0, as we have not initialized any value
        boolean isAnagram=false;

        if(s1.length()==s2.length()){

            //for loop to traverse the two strings and fill the anagramChecker array. TC=O O(n)
            for(int i=0; i<s1.length();i++){
                char charS1=s1.charAt(i);
                int freqIndexA= charS1-97;
                anagramChecker[freqIndexA]+=1;

                char charS2=s2.charAt(i);
                int freqIndexB= charS2-97;
                anagramChecker[freqIndexB]-=1;
            }

            //for loop to traverse the anagramChecker array. TC=O(26)
            for (int i=0;i<26;i++){
                if(anagramChecker[i]!=0) return false;
                else isAnagram=true;
            }
        }
        return isAnagram;
    }
}
