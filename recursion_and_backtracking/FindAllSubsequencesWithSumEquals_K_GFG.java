package recursion_and_backtracking;
import java.util.*;

public class FindAllSubsequencesWithSumEquals_K_GFG {

    public static void main(String[] args) {
        int[] ex1={1,2,3};
        int[] ex2={17,18,6,11,2,4};
//        System.out.println(allSubsequences(ex1,3));
        System.out.println(allSubsequences(ex2,6));

    }
    static List<List<Integer>> allSubsequences(int[] arr,int k){
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> sublist=new ArrayList<>();
        recur(arr,list,sublist,k,0,0);
        return list;
    }
    static void recur(int[] arr,List<List<Integer>> list, List<Integer> sublist,int k,int index,int sum){
       //base case
       if(index==arr.length) { //this means that the whole array is checked
           if (sum == k) {
               list.add(new ArrayList<>(sublist));
           }
           return;
       }
        //adding the element to sublist
        sublist.add(arr[index]);

        recur(arr,list,sublist,k,index+1,sum+arr[index]); //picking the element


        //removing the last element from sublist for proper backtracking
        sublist.remove(sublist.size()-1);

       recur(arr,list,sublist,k,index+1,sum); //not picking the element




    }

}
