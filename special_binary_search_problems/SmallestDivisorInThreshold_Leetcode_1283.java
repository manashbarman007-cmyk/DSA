package special_binary_search_problems;

public class SmallestDivisorInThreshold_Leetcode_1283 {

    public static void main(String[] args) {
        int[] example1={1,2,5,9};
        int[] example2={44,22,33,11,1};
        System.out.println(toFindMinimumInteger(example1,6));
        System.out.println(toFindMinimumInteger(example2,5));

    }

     static int toFindMinimumInteger(int[] nums, int threshold){
        int start=1,end= Integer.MIN_VALUE,res=-1;
        //finding the max value in array and storing it in 'end'
         for(int i=0;i< nums.length;i++){
             if(end<nums[i]){
                 end=nums[i];
             }
         }
         while(start<=end){
           int mid=start+(end-start)/2;
           int minSum=toFindSumInsideThreshold(nums,mid);
           if(minSum<=threshold){
               res=mid;
               end=mid-1;  //move left
           }else {
               start=mid+1;  //move right
           }
         }
         return res;
     }


     static int toFindSumInsideThreshold(int[] arr,int minDivisor){
        int sum=0;
        for(int i=0;i< arr.length;i++){
            sum+=Math.ceil((double) arr[i]/minDivisor);
        }
        return sum;
     }
}
