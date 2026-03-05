package different_searching_algorithms;

public class ExponentialSearchAlgorithm {
    public static void main(String[] args) {
        int[] ex={2,3,5,7,11,16,19,24,30,42};
        System.out.println(performTernarySearch(ex,422));

    }
    static int performTernarySearch(int[] arr, int target){
        if(arr[0]==target) return 0; // edge case
        int n=arr.length;

        //finding range for binary search
        int i=1;
        while(i<n && arr[i]<=target){
            i*=2;
        }
        //now we perform binary search
        int start=i/2, end= Math.min(i,n-1);
        while(start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]==target) return mid;
            else if (target<arr[mid]) end=mid-1;
            else start=mid+1;
        }

        //we will return -1 if element is not present in the array
        return -1;
    }
}
