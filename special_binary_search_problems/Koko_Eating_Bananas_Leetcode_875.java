package special_binary_search_problems;

public class Koko_Eating_Bananas_Leetcode_875 {
    public static void main(String[] args) {
        int[] example1={3,6,7,11}; //may or may not be sorted
        int[] example2={30,11,23,4,20};
        System.out.println("The minimum numbers of bananas eaten per hour is "+minEatingSpeed(example1,8));
//        System.out.println("The minimum numbers of bananas eaten per hour is "+minEatingSpeed(example2,5));
    }
    static int minEatingSpeed(int[] piles, int h) {
        //To find the max of piles[]
        int start=1,end=Integer.MIN_VALUE,res=-1;
        for(int i=0;i<piles.length;i++) {
            if (end < piles[i]) {
                end = piles[i]; //we find the max of the array
            }
        }
        //binary search
            while (start<=end){
                int mid=start+(end-start)/2;
                int noOfHours=countHours(piles,mid);
                if(noOfHours<=h){
                    res=mid;
                    end=mid-1; //move left
                }else {
                    start=mid+1; //move right
                }
            }
        return res;
    }

    //method to count the hours
    static int countHours(int[] arr, int minBananas){
        int hour=0;
        for (int i=0;i<arr.length;i++){
         hour+=Math.ceil((double)arr[i]/minBananas);
        }
        return hour;

    }
}
