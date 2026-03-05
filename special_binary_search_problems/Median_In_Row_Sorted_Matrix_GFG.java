package special_binary_search_problems;

public class Median_In_Row_Sorted_Matrix_GFG {
    public static void main(String[] args) {
        int[][] example1={{1,5,7,9,11},
                         {2,3,4,5,10},
                         {9,10,12,14,16}
        };
        int[][] example2={{1,3,5},
                         {2,6,9},
                         {3,6,9}
        };
        System.out.println(median(example1));
        System.out.println(median(example2));
    }
    // Binary search
   static int median(int mat[][]) {
        int m=mat.length; //number of rows
        int n=mat[0].length; //number of columns
       int res=-1;
       int start=Integer.MAX_VALUE,end=Integer.MIN_VALUE;
        for(int i=0;i<=m-1;i++){ //for loop through each rows
           start=Math.min(Integer.MAX_VALUE,mat[i][0]); //compare the elements in 0th column
           end=Math.max(Integer.MIN_VALUE,mat[i][n-1]); //compare the elements in (n-1)th ie the last column
        }
        while (start<=end){
            int mid=start+(end-start)/2;
            int smallerThanEqualsTo=blackBox(mat,mid);//
            if(smallerThanEqualsTo<=(m*n)/2){
                start=mid+1; // move right
            }else { // if smallerThanEqualsTo>(m*n)/2
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
