package binary_search;

public class Binary_Search_Lec_20 {
    public static void main(String[] args) {
        int[] age = {1, 2, 2, 4, 5, 8, 8, 8, 10, 13, 20};
        int[] newArr={0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
//        minDifference(age, 25);
       int[] range=toFindRangeOfInfiniteArray(newArr,1);
       for (int x:range){
           System.out.print(x+"    ");
       }
        System.out.println();
       findFirstOccurrence(newArr,8,16,1);

//        int[] range1=toFindRangeOfInfiniteArray(age,4);
//        for (int x:range1){
//            System.out.print(x+"    ");
//        }
//        System.out.println();
//       toFindTargetInInfiniteArray(age,2,4,3);
    }

    // minimum absolute difference that is to find "abs(target-arr[j])=minimum"
    static void minDifference(int[] arr, int target) {
        int start = 0, end = arr.length - 1, ans = -1;
        int start1 = 0, end1 = arr.length - 1, ans1 = -1;

        //to find floor of target
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                ans = arr[mid];
                break;
            } else if (arr[mid] < target) {
                start = mid + 1;
                ans = arr[mid];
            } else {
                end = mid - 1;
            }
        }

        //to find ceil of target
        while (start1 <= end1) {
            int mid = start1 + (end1 - start1) / 2;
            if (arr[mid] == target) {
                ans1 = arr[mid];
                break;
            } else if (arr[mid] < target) {
                start1 = mid + 1;
            } else {
                end1 = mid - 1;
                ans1 = arr[mid];
            }
        }
        int floorDiff = Math.abs(target - ans);
        int ceilDiff = Math.abs(target - ans1);
        if (floorDiff <= ceilDiff) {
            System.out.println("Minimum absolute difference is: " + floorDiff);
        } else {
            System.out.println("Minimum absolute difference is: " + ceilDiff);
        }
        if (arr.length == 0) {
            return;  //if array has no element then simply exit the method
        }
    }

    //To find the target in an infinite array. We assume the input array to be infinite,so, we do not check
    //for array index out of bound exception
    static void toFindTargetInInfiniteArray(int[]arr,int start,int end,int target) { //binary search
        int index=-1;
        if (arr[end]>=target){
            //write the code for binary search
            while (start<=end){
                int mid=start+(end-start)/2;
                if(arr[mid]==target){
                    index=mid;
                    break;
                } else if (arr[mid]<target) {
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
        }
        if(index==-1){
            System.out.println("The element "+target+" is not present in the array");
        }else {
            System.out.println("The element "+target+" is found at index: "+index);
        }

    }


    //we define a method to find the range of start and end for the infinite array
    static int[] toFindRangeOfInfiniteArray(int[] arr, int target) {  //The method returns an array of the range
        int start=0,end=1;  //initially put start=0 and end=1
        int[] range = new int[2]; //an array having 2 indices
        while (arr[end] < target) {  //The loop stops when arr[end]>=target
            start = end;
            end = 2 * end;
        }
        range[0] = start;
        range[1] = end;
        return range;
    }

    //Code to find the first occurrence of 1 in newArr infinite array
    static void findFirstOccurrence(int[] arr, int start, int end, int target){
        int index=-1;
        if (arr[end]>=target){
            //write the code for binary search
            while (start<=end){
                int mid=start+(end-start)/2;
                if(arr[mid]==target){
                    index=mid;
                    end=mid-1;  //we store the index and look if the target has duplicates on the left side
                } else if (arr[mid]<target) {
                    start=mid+1;
                }else {
                    end=mid-1;
                }
            }
        }
        if(index==-1){
            System.out.println("The element "+target+" is not present in the array");
        }else {
            System.out.println("The element "+target+" is found at index: "+index);
        }
    }
}



