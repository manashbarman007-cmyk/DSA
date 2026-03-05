package special_binary_search_problems;

public class SingleElementInSortedArray_Leetcode_540 {
    public static void main(String[] args) {
        SingleElementInSortedArray_Leetcode_540 obj=new SingleElementInSortedArray_Leetcode_540();
        int[] ex1={1,1,2,3,3,4,4,8,8};
        int[] ex2={3,3,7,7,10,11,11};
        System.out.println(obj.singleNonDuplicate(ex1));
        System.out.println(obj.singleNonDuplicate(ex2));
    }
    public int singleNonDuplicate(int[] nums){
        if(nums.length==1){
            return nums[0];
        }else if(nums[0]!=nums[1]){ //the first element is unique
            return nums[0];
        }else if(nums[nums.length-1]!=nums[nums.length-2]){ //the last element is unique
            return nums[nums.length-1];
        }
        int start=1,end=nums.length-2,res=-1;
        while (start<=end){
           int mid=start+(end-start)/2;
           if(nums[mid]!=nums[mid-1] && nums[mid]!=nums[mid+1]){
               res=nums[mid];
               break;
           } else if ((mid%2==0 && nums[mid]==nums[mid+1])||(mid%2==1 && nums[mid]==nums[mid-1])) { //we are on the left half of mid
                                                                                                     // and we eliminate this half
               start=mid+1;
           }else {    //we are on the right half of mid
                      // and we eliminate this half
               end=mid-1;
           }
        }
        return res;
    }
}
