package recursion_and_backtracking;

import java.util.Arrays;

public class Merge_Sort {
    public static void main(String[] args) {
     int[] ex1={2,10,8,12,6,4};
        System.out.println(Arrays.toString(ex1));
     Merge_Sort obj =new Merge_Sort();
     obj.mergeSort(ex1,0, ex1.length-1);
        System.out.println(Arrays.toString(ex1));
    }
    void mergeSort (int arr[], int l, int r) {
        // code here

        //base case
        if(l >= r){
            return;
        }
        int m = l + (r - l) / 2;
        mergeSort(arr, l, m); //left half of arr
        mergeSort(arr,m + 1, r); //right half of arr

        merge(arr, l, m, r); //this func merge and sort the array while returning (ie backtracking)
    }

    void merge(int arr[], int l, int m, int r){
        int n1 = m - l + 1; //size of first temporary array
        int n2 = r - m; //size of the second temporary array
        int[] temp1 = new int[n1];
        int[] temp2 = new int[n2];

        for(int i = 0; i < n1; i++){
            temp1[i] = arr[l + i]; // fill the temp1 from left half of arr
        }
        for(int i = 0; i < n2; i++){
            temp2[i] = arr[m + 1 + i]; //fill the temp2 from right half of arr
        }

        int p1 = 0, p2 = 0, k = l; //pointers and k=l, as we insert the elements from the left side of arr

        //storing the elements back to the original array while sorting

        //when both temp1 and temp2 are not empty
        while(p1 < n1 && p2 < n2){
            if(temp1[p1] <= temp2[p2]){
                arr[k] = temp1[p1];
                p1++; //move to the next index of temp1
            }
            else { //if temp1[p1] > temp2[p2]
                arr[k] = temp2[p2];
                p2++; //move to the next element of temp2
            }
            k++;
        }

        //when temp2 is empty, we simply store the element of temp1 in arr as temp1 is sorted
        while (p1 < n1){
            arr[k] = temp1[p1];
            k++;
            p1++;
        }

        //when temp1 is empty, we simply store the element of temp2 in arr as temp2 is sorted
        while (p2 < n2){
            arr[k] = temp2[p2];
            k++;
            p2++;
        }
    }
}

// study this
// class Solution {
//     public int[] sortArray(int[] nums) {
//         mergeSort(nums);
//         return nums;
//     }

//     public void mergeSort (int[] nums) {
//         int n = nums.length;
//         // base case
//         if (n == 1) return;


//         int mid = n / 2;
//         int[] left = new int[mid];
//         for (int i = 0; i < mid; i++) {
//             left[i] = nums[i];
//         }

//         int[] right = new int[n - mid];
//         for (int i = mid; i < n; i++) {
//             right[i - mid] = nums[i];
//         }


//         mergeSort(left);
//         mergeSort(right);

//         // merge the left and right arrays
//         merge(nums, left, right);
//     }

//     public void merge (int[] nums, int[] left, int[] right) {
//         int l = 0;
//         int r = 0;
//         int k = 0;

//         int lSize = left.length;
//         int rSize = right.length;

//         while (l < lSize && r < rSize) {
//             if (left[l] <= right[r]) {
//                 nums[k] = left[l];
//                 l++;
//             }
//             else {
//                 nums[k] = right[r];
//                 r++;
//             }
//             k++;
//         }

//         // remaining left element
//         while (l < lSize) {
//             nums[k] = left[l];
//             l++;
//             k++;
//         }

//         // remaining right element
//         while (r < rSize) {
//             nums[k] = right[r];
//             r++;
//             k++;
//         }

//     }
// }
