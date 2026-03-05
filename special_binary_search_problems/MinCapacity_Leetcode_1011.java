package special_binary_search_problems;

public class MinCapacity_Leetcode_1011 {
    public static void main(String[] args) {
        int[] weight1={3,2,2,4,1,4};
        int[] weight2= {1,2,3,4,5,6,7,8,9,10};
        System.out.println( toFindMinCapacity(weight1,3));
        System.out.println( toFindMinCapacity(weight2,5));

    }
    static int toFindMinCapacity(int[] arr, int days){
        int start= Integer.MIN_VALUE, end=0, res=-1;
        for (int i=0;i<arr.length;i++){
            if(start<arr[i]){
                start=arr[i]; //to find the max element in the array
            }
            end+=arr[i]; // finding the array sum
        }
        while(start<=end){
            int mid=start+(end-start)/2;
            int numOfDays=countNumOfDays(arr,mid);
            if(numOfDays<=days){
                res=mid;
                end=mid-1; //we move left
            }else {
                start=mid+1;  //move right
            }
        }
        return res;
    }

    //to find the number of days
    static int countNumOfDays(int[] arr, int minCapacity){
        int toCountDay=1, weight=0; //initially in the first day the initial weight of cargo is 0
        for(int i=0;i<arr.length;i++){
            if((weight+arr[i])<=minCapacity){
                weight+=arr[i]; //we keep on adding the array elements until the if-condition is satisfied
            }else {
                toCountDay++; //we increase the day count by 1 and give an array element to it
                weight=arr[i];
            }
        }
        return toCountDay;
    }
}
