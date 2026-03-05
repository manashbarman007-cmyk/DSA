package special_binary_search_problems;

public class Rotated_Sorted_Array_Lec_22 {
    public static void main(String[] args) {
        int[] example1={7,8,9,1,2,3,4,5,6};  //Rotated sorted array with distinct values
        int[] example2={19,2,3,4,19,19,19,19};//Rotated sorted array with duplicate values
        int[] example3={3,1,2,3,3,3,3};//Rotated sorted array with duplicate values

//        toFindTargetDistinct(example1,3);
//        toFindTargetDuplicate(example2,2);
//        toFindTargetDuplicate(example3,2);
//        toFindMinimumWithDistinct(example1);
//        toFindMinimumWithDuplicates(example3);
        toFindNumberOfRotations(example1);

    }

    //To find the target in the rotated sorted array (with distinct values)
    static void toFindTargetDistinct(int[] arr, int target){
        int start=0,end= arr.length-1,index_P=-1;

      //finding the sorted half
        while (start<=end){
            int mid= start+(end-start)/2;
            if(arr[mid]==target){
                index_P=mid;
                break;
            }
            // if the left side of mid is sorted
            if(arr[start]<=arr[mid]){  //condition for left side to be sorted
                //can answer be found on the left side?
                if(target<arr[mid] && target>=arr[start]){ //if target lies on the left side of mid that is in the
                                                           // sorted part
                    end=mid-1;
                }else {   //if target lies on the right side of mid that is in the unsorted part
                    start=mid+1;
                }
            }
            //else the right side of mid is sorted
            else {
                if(target>arr[mid] && target<=arr[arr.length-1]){
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
        }
        if(index_P==-1){
            System.out.println("The element "+target+" is not present in the array");
        }else {
            System.out.println("The element "+target+" is present in the index: "+index_P);

        }
    }

    //To find the target in the rotated sorted array (with duplicate values)
    static void toFindTargetDuplicate(int[] arr, int target){
        int start=0,end=arr.length-1,index=-1;
        while (start<=end) {
            int mid=start+(end-start)/2;
            if (arr[mid]==target){
                index=mid;
                break;
            }
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){  //**This is very important
                start++;
                end--;
            }
            //if left side of mid is sorted
            else if(arr[start]<=arr[mid]){
                if(target<arr[mid] && target>=arr[start]){ //target is in the left sorted part
                    end=mid-1;
                }else {    //target is in the unsorted right part
                    start=mid+1;
                }
            }//else the right part of mid is unsorted
            else {
                if(target>arr[mid] && target<=arr[end]){ //target is in the left sorted part
                    start=mid+1;
                }else {    //target is in the unsorted right part
                   end=mid-1;
                }
            }
        }
        if(index==-1){
            System.out.println("The element "+target+" is not present in the array");
        }else {
            System.out.println("The element "+target+" is present in the index: "+index);

        }
    }

    //To find minimum element in rotated sorted array
    static void toFindMinimumWithDistinct(int[] arr){
        int start=0,end=arr.length-1;
        int min= Integer.MAX_VALUE;
        while (start<=end){
            int mid=start+(end-start)/2;
            //the left half is sorted
            if(arr[start]<=arr[mid]){
                if(min>arr[start]){
                    min=arr[start]; //storing the leftmost element of the sorted array
                }
                start=mid+1; //eliminate this half and we will search for the minimum in the other half
            }//else the right half is sorted
            else {
                if(min>arr[mid]){
                    min=arr[mid];  //storing the leftmost element of the sorted array
                }
                end=mid-1; //eliminate this half and we will search for the minimum in the other half
            }
        }
        System.out.println("The minimum element in the rotated sorted array is "+min);
    }

    //To find minimum element in rotated sorted array
    static void toFindMinimumWithDuplicates(int[] arr){
        int start=0,end=arr.length-1;
        int min= Integer.MAX_VALUE;
        while (start<=end){
            int mid=start+(end-start)/2;
            if(arr[start]==arr[mid] && arr[mid]==arr[end]){
                start++;
                end--;
            }
            //the left half is sorted
            if(arr[start]<=arr[mid]){
                if(min>arr[start]){
                    min=arr[start]; //storing the leftmost element of the sorted array
                }
                start=mid+1; //eliminate this half
            }//else the right half is sorted
            else {
                if(min>arr[mid]){
                    min=arr[mid];  //storing the leftmost element of the sorted array
                }
                end=mid-1; //eliminate the half
            }
        }
        System.out.println("The minimum element in the rotated sorted array is "+min);

    }

    //To find the number of rotations in the rotated sorted array
    static void toFindNumberOfRotations(int[] arr){
        int start=0,end=arr.length-1,index=Integer.MAX_VALUE;
        int min= Integer.MAX_VALUE;
        while (start<=end){
            int mid=start+(end-start)/2;
            //the left half is sorted
            if(arr[start]<=arr[mid]){
                if(min>arr[start]){
//                    min=arr[start]; //storing the leftmost element of the sorted array
                    index=start;// will store the index of the minimum element
                }
                start=mid+1; //eliminate this half and we will search for the minimum in the other half
            }//else the right half is sorted
            else {
                if(min>arr[mid]){
                    min=arr[mid];  //storing the leftmost element of the sorted array
                }
                end=mid-1; //eliminate the half and we will search for the minimum in the other half
            }
        }
        System.out.println("The number of rotations in the rotated sorted array is "+index);

    }
}
