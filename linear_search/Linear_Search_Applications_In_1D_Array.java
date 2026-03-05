package linear_search;

public class Linear_Search_Applications_In_1D_Array {
    public static void main(String[] args) {
       int[] marks= {101,-1,53,67,105,86,58,97,102};
       toFindMax(marks);
       toFindMin(marks);
    }

    //To find the maximum element in the array
    static void toFindMax(int[] arr){
//        int max1=arr[0];  //This initialization is also valid
        int max1= Integer.MIN_VALUE; //we can also use this initialization
        for(int i=0;i<= arr.length-1;i++){
            if(max1<arr[i]){
                max1=arr[i];
            }

        }
        System.out.println("The maximum element in array is: "+max1);
    }

    //To find the minimum value in array
    static void toFindMin(int[] arr){
        int min=arr[0];
//   int min=Integer.MAX_VALUE  // This initialization also works
        for(int i=0;i< arr.length;i++){
            if(min>arr[i]){
                min=arr[i];
            }
        }
        System.out.println("The minimum element is array is: "+min);
    }
}
