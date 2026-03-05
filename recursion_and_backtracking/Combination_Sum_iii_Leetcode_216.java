package recursion_and_backtracking;
import java.util.*;

public class Combination_Sum_iii_Leetcode_216 {
    public static void main(String[] args) {
      Combination_Sum_iii_Leetcode_216 obj=new Combination_Sum_iii_Leetcode_216();
        System.out.println(obj.combinationSum3(3,7));
        System.out.println(obj.combinationSum3(3,9));
        System.out.println(obj.combinationSum3(4,1));
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> sublist=new ArrayList<>();
        int[] arr={1,2,3,4,5,6,7,8,9};
        recur(k,n,list,sublist,arr,0);
        return list;
    }

    static void recur(int k,int n,List<List<Integer>> list,List<Integer> sublist,int[] arr,int index){
        if(sublist.size()==k){ //base case
            if(n==0){
                list.add(new ArrayList<>(sublist));
            }
            return;
        }
        for(int i=index;i<arr.length;i++){
            if(arr[i]>n){
                break;
            }
            sublist.add(arr[i]);
            recur(k,n-arr[i],list,sublist,arr,i+1);
            sublist.remove(sublist.size()-1); //for proper backtracking
        }
    }
}
