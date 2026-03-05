package stacks_lectures;

public class Min_Swaps_For_Bracket_Balancing_GFG {
    public static void main(String[] args) {
     String ex1="[]][][";
     String ex2="[[[][][]]]";
     String ex3="]]][[[";
     String ex4="[]][][]][[";
        System.out.println(minimumNumberOfSwaps(ex1));
        System.out.println(minimumNumberOfSwaps(ex2));
        System.out.println(minimumNumberOfSwaps(ex3));
        System.out.println(minimumNumberOfSwaps(ex4));
    }

    //optimised way, without using stacks
    static int minimumNumberOfSwaps(String s) {
        // code here
        int n=s.length(),countOpen=0,countClose=0,swap=0,unbalanceClose=0;
        for (int i=0;i<n;i++){
            char ch=s.charAt(i);
            if(ch=='['){
                countOpen++;
                if(unbalanceClose>0){
                    swap+=unbalanceClose;
                    unbalanceClose--;
                }
            }else {
                countClose++;
                unbalanceClose=countClose-countOpen;
            }
        }
     return swap;
    }
}
