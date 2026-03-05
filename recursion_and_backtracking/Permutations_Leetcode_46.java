package recursion_and_backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutations_Leetcode_46 {
    public static void main(String[] args) {
        int[] ex={1,2,3};
        Permutations_Leetcode_46 obj=new Permutations_Leetcode_46();
        System.out.println(obj.permute(ex));

    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        computePermutation(nums,0,res);
        return res;
    }
    static void computePermutation(int[] nums,int fi,List<List<Integer>> res){  //fi: fixed index
         int n=nums.length;
        List<Integer> subList=new ArrayList<>();
         //base case
        if(fi==n-1){
           for(Integer in:nums){
               subList.add(in);
           }
           res.add(new ArrayList<>(subList));
           return;
        }
        for(int i=fi;i<n;i++){
            swap(nums,i,fi);
            computePermutation(nums,fi+1,res); //recursive call
            swap(nums,i,fi); //swapping while backtracking
        }
    }

    static void swap(int[] arr,int i1,int i2){
        int temp=arr[i1];
        arr[i1]=arr[i2];
        arr[i2]=temp;
    }

}
