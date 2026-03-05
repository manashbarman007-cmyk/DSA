package binary_search;

public class Binary_Search_Applications {
    public static void main(String[] args) {
        int[] age = {2, 2, 3, 4, 4, 4, 4, 8, 8, 9, 14};  //ascending sorted array
//        toFindFirstAndLAstOccurrence(age,4,true); //to find first occurrence
//        toFindFirstAndLAstOccurrence(age,4,false); //to find last occurrence
//        System.out.println("Counter: " + toCountTarget(age, 2));
        toFindFloor(age,5);
        toFindCeil(age, 5);

    }

    //To find the first and last occurrence if target
    static void toFindFirstAndLAstOccurrence(int[] arr, int target, boolean toFindFirst) {
        int start = 0, end = arr.length - 1;
        int index = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                index = mid;
                if (toFindFirst) {   //That is we have to find the first occurrence
                    end = mid - 1;
                } else {
                    start = mid + 1; //That is to find the last occurrence
                }
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (index == -1) {
            System.out.println(target + " is not present in array");
        } else {
            System.out.println("The occurrence of " + target + " is at: " + index);
        }

    }


    //To count the occurrence of target
    static int toCountTarget(int[] arr, int target) {
        int UL = -1, LL = -1, start = 0, end = arr.length - 1;
        int start1 = 0, end1 = arr.length - 1;

        //we find the lower limit first
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == target) {
                LL = mid;
                end = mid - 1;   //to find the first occurrence
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }

        //we find the upper limit of target
        while (start1 <= end1) {
            int mid = start1 + (end1 - start1) / 2;
            if (arr[mid] == target) {
                UL = mid;
                start1 = mid + 1;  //to find the last occurrence
            } else if (arr[mid] < target) {
                start1 = mid + 1;
            } else {
                end1 = mid - 1;
            }
        }
        if (UL == -1 || LL == -1) {
            return 0;
        } else {
            int count = UL - LL + 1;
            return count;
        }
    }


    //Finding the floor value of target
    static void toFindFloor(int[] arr, int target){
        int ans=-1, start=0, end=arr.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (arr[mid]==target) {
                ans=arr[mid];
                break;   //we exit the loop
            } else if (arr[mid]>target) {
                end=mid-1;
            }else {   //this condition applies when arr[mid]<target
                start=mid+1;
                ans=arr[mid];
            }
        }
        if(ans==-1){
            System.out.println("The floor value of "+target+" is not present in the array");
        }else {
            System.out.println("The floor value of "+target+" is: "+ans);
        }
    }

    //Finding the ceil value of target
    static void toFindCeil(int[] arr, int target){
        int ans=-1, start=0, end=arr.length-1;
        while (start<=end){
            int mid=start+(end-start)/2;
            if (arr[mid]==target) {
                ans=arr[mid];
                break;   //we exit the loop
            } else if (arr[mid]>target) {
                end=mid-1;
                ans=arr[mid];
            }else {   //this condition applies when arr[mid]<target
                start=mid+1;
            }
        }
        if(ans==-1){
            System.out.println("The ceil value of "+target+" is not present in the array");
        }else {
            System.out.println("The ceil value of "+target+" is: "+ans);
        }
    }
}
