package special_binary_search_problems;

public class Implement_Lower_and_Upper_Bound {
    public static void main(String[] args) {
        int[] example={1,5,8,15,19,19,20};
        System.out.println(implementLowerBound(example,5));
        System.out.println(implementUpperBound(example, 19));
    }

    //to find lower bound
    static int implementLowerBound(int[] arr, int num){
        int start=0, end=arr.length-1, index=arr.length; //arr.length is the hypothetical upper bound for the last element
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>=num){
                index=mid; //mid is a potential answer and we move left
                end=mid-1;
            }else {
                start=mid+1; //when arr[mid]<num
            }
        }
        return index;
    }

    //to find upper bound
    static int implementUpperBound(int[] arr, int num){
        int start=0, end=arr.length-1, index=arr.length ; //arr.length is the hypothetical upper bound for the last element
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[mid]>num){
                index=mid; //mid is a potential answer and we move left
                end=mid-1;
            }else {
                start=mid+1; //when arr[mid]<num
            }
        }
        return index;
    }
}
