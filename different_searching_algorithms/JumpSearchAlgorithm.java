package different_searching_algorithms;

public class JumpSearchAlgorithm {
    public static void main(String[] args) {
        int[] ex={2,3,5,7,11,16,19,24,30,42};
        System.out.println(performJumpSearch(ex,24)); //Gives us the index of the target
    }
    static int performJumpSearch(int[] arr,int target){
        int n=arr.length; //size of arrray
        int m=(int)Math.sqrt(n),start=0,end=m; //'m' is the block size
        while (arr[end]<=target && end<n-1){
            start=end;
            end+=m;
            if(end>n-1) {
                end = n - 1;
            }
        }
        //linear search in the potential block
        for (int i=start;i<=end;i++){
            if(arr[i]==target){
                return i; //return exits the method
            }
        }
        //if element is not found
        return -1;
    }
}
