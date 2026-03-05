package recursion_and_backtracking;
import java.util.*;

public class Combination_Sum_Leetcode_39 {
    public static void main(String[] args) {
        Combination_Sum_Leetcode_39 obj=new Combination_Sum_Leetcode_39();
        int[] ex1={2,3,6,7};
        int[] ex2={2,3,5};
        System.out.println(obj.combinationSum(ex1,7));
        System.out.println(obj.combinationSum(ex2,8));

    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> sublist=new ArrayList<>();
        recur(candidates,list,sublist,0,target);
        return list;
    }

    static void recur(int[] arr,List<List<Integer>> list,List<Integer> sublist,int index,int target){
        int n= arr.length;

        //base case
        if(index==n){ //ie the whole array has been checked
            if(target==0){
                list.add(new ArrayList<>(sublist));
            }
            return;

        }
        if(arr[index]<=target) {
            sublist.add(arr[index]);//add the element in the sublist
            recur(arr, list, sublist, index, target - arr[index]); //picking the same element
            sublist.remove(sublist.size()-1);//removing the last element from sublist for proper backtracking
        }
        recur(arr,list,sublist,index+1,target); //not picking the element
    }
}
