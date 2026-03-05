package special_binary_search_problems;

public class K_th_Smallest_Element_In_Sorted_Matrix_Leetcode_378 {
    public static void main(String[] args) {
        int[][] example1= {{1, 5, 9},
                           {10, 11, 13},
                           {12, 13, 15}
        };
        int[][] example2={{-5}};
        System.out.println(kthSmallest(example1,8));
        System.out.println(kthSmallest(example2,1));
    }
    // Binary search
    static int kthSmallest(int matrix[][],int k) {
        int m=matrix.length; //number of rows
        int n=matrix[0].length; //number of columns
        int res=-1;
        int start= matrix[0][0], end=matrix[m-1][n-1];
        while (start<=end){
            int mid=start+(end-start)/2;
            int smallerThanEqualsTo=blackBox(matrix,mid);//
           if(smallerThanEqualsTo<k){
                start=mid+1; // move right
            }
           else { // if smallerThanEqualsTo>=k
                res=mid;
                end=mid-1; //move right
            }
        }
        return res;
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

    // this method calculates the number of element <= num in the matrix
    static int blackBox(int mat[][], int num){
        int count=0;
        for(int i=0;i<=mat.length-1;i++) { //will go through each row and find the upper bound of num
            count += implementUpperBound(mat[i], num);
        }
        return count;
    }
}
