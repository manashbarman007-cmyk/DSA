package recursion_and_backtracking;
import java.util.*;

public class Combination_Sum_ii_Leetcode_40 {
    public static void main(String[] args) {
    Combination_Sum_ii_Leetcode_40 obj=new Combination_Sum_ii_Leetcode_40();
    int[] ex1={2,5,2,1,2};
    int[] ex2={10,1,2,7,6,1,5};
        System.out.println(obj.combinationSum2(ex1,5));
        System.out.println(obj.combinationSum2(ex2,8));

    }

    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> list = new ArrayList<>();
        List<Integer> sublist = new ArrayList<>();
        func(candidates, target, list, sublist, 0);
       return list;
    }

    static void func(int[] candidates, int target, List<List<Integer>> list, List<Integer> sublist, int index) {
        int n = candidates.length;
        Arrays.sort(candidates);

            if (target == 0) {
                    list.add(new ArrayList<>(sublist));
                    return;
            }
        for(int i=index;i<candidates.length;i++){
            if(i>index && candidates[i]==candidates[i-1]){ //to avoid the duplicates
                continue; //we skip this iteration and perform the next iteration
            }
            if(candidates[i]>target){
                break;
            }else {
                sublist.add(candidates[i]);
                func(candidates,target-candidates[i],list,sublist,i+1);
                sublist.remove(sublist.size()-1); //for proper backtracking
            }
        }
    }

}
