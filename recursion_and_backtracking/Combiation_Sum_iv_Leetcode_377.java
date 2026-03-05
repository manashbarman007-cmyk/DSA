package recursion_and_backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Combiation_Sum_iv_Leetcode_377 {
    public static void main(String[] args) {
       Combiation_Sum_iv_Leetcode_377 obj=new Combiation_Sum_iv_Leetcode_377();
       int[] ex1={1,2,3};
       int[] ex2={3,1,2,4};
       int[] ex3={4,2,1};
        System.out.println(obj.combinationSum4(ex1,4));
//        System.out.println(obj.combinationSum4(ex2,4));
//        System.out.println(obj.combinationSum4(ex3,32));
    }
    public int combinationSum4(int[] nums, int target) {
        List<List<Integer>> list=new ArrayList<>();
        List<Integer> sublist=new ArrayList<>();
        recur(nums,target,list,sublist,0);
        return list.size();
    }
    static void recur(int[] nums,int target,List<List<Integer>> list,List<Integer> sublist,int index) {
        int n = nums.length;
        Arrays.sort(nums);
        //base case
            if (target == 0) {
                list.add(new ArrayList<>(sublist));
                System.out.println(sublist);
                return;
            }
        for (int i = 0; i < n; i++) {
            if (nums[i] > target) {
                break;
            } else {
                sublist.add(nums[i]);
                recur(nums, target - nums[i], list, sublist,i+1);
                sublist.remove(sublist.size() - 1);//for proper backtracking
            }
        }

    }
}
