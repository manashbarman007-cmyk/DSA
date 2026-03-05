package special_binary_search_problems;

public class Minimized_Maximum_Of_Products_Leetcode_2064 {
    public static void main(String[] args) {
        int[] example1 = {11, 6};
        int[] example2 = {15,10,10};
        System.out.println("The minimized maximum is: "+binarySearchToMinimizeMaximum(example1,6));
        System.out.println("The minimized maximum is: "+binarySearchToMinimizeMaximum(example2,7));
    }

    static int binarySearchToMinimizeMaximum(int[] quantities, int n) {
        int start = 1, end = Integer.MIN_VALUE, res = -1;
        for (int i = 0; i < quantities.length;i++){
            if(end<quantities[i]){
                end=quantities[i];
            }
        }
        while (start<=end){
            int mid=start+(end-start)/2;
            int numOfStores=countStores(quantities,mid);
            if(numOfStores<=n){
                res=mid;
                end=mid-1;
            }else{
                start=mid+1;
            }
        }
        return res;
    }

    //method to count the number of stores
    static int countStores(int[] arr, int maxQuantity){
        int stores=0;
        for(int i=0;i<arr.length;i++){
            stores+=Math.ceil((double)arr[i]/maxQuantity);
        }
        return  stores;
    }
}
