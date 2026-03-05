package recursion_and_backtracking;

public class Binary_Search_Using_Recursion {
    public static void main(String[] args) {
        Binary_Search_Using_Recursion obj=new Binary_Search_Using_Recursion();
        int[] ex1={1,2,3,4,5,10};
        int[] ex2={1,28,36,44,48,64,78,78};
        int[] ex3={1,1,1,2,2,3,3,3,3,3,3,4,4,4,5,5,5};
        System.out.println(binarySearch(ex1,90));
        System.out.println(binarySearch(ex2,36));
        System.out.println(binarySearch(ex3,3));
    }
    static int binarySearch(int[] arr,int k){
        if(arr[0]==arr[arr.length-1]){ //edge case
            return 0;
        }
        return func(arr,k,0,arr.length-1);
    }
    static int func(int[] arr,int k,int start,int end){
        if(start>end){
            return -1; //if element does not exist
        }
        int mid=start+(end-start)/2;
        //base case
        if(arr[mid]==k){
            return mid;

        }
        else if(arr[mid]>=k){
            //move left
           return func(arr,k,start,mid-1); //if the answer is obtained we stop the recursion
                                                //and exit the method ,so, we use 'return'
        }
        else{
            //move right if arr[mid]<k
           return func(arr,k,mid+1,end); //if the answer is obtained we stop the recursion
                                              //and exit the method ,so, we use 'return'
        }
    }
}
