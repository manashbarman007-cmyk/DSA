package special_binary_search_problems;

public class Allocate_Min_Num_Of_Pages {
    public static void main(String[] args) {
        int[] example1={12,34,67,90}; //array may or may not be sorted
        int[] example2={25,46,28,49,24};
        // n=number of books   m=number of students
        System.out.println("The maximum number of pages assigned to a student which is minimum is "+toFindMinAllocation(example1,4,2));
        System.out.println("The maximum number of pages assigned to a student which is minimum is "+toFindMinAllocation(example2,5,4));
    }

    static int toFindMinAllocation(int[] arr, int n, int m){
        //n:number of books    m:number of students
        if(m>n){
            return -1;
        }
        else {
            int max= Integer.MIN_VALUE;  //use this to find the maximum element in array
            int sum=0; // to find the sum of array
            for(int i=0;i< arr.length;i++){
                if(max<arr[i]){  //to find the max element
                    max=arr[i];
                }
                sum+=arr[i];  //to find sum
            }

            int start=max, end=sum, ans=-1;

            //binary search
            while(start<=end){
                int mid=start+(end-start)/2;
                int noOfStudents=countStudent(arr, mid);
                if(noOfStudents<=m){
                    ans=mid;
                    end=mid-1; //move left
                }else{
                    start=mid+1;  //move right
                }
            }
            return ans;
        }
    }

    static int countStudent(int[] arr,int maxPages){
        int student=1, pagesStudent=0; //initially the number of student is 1 with 0 pages
        for(int i=0;i<arr.length;i++){
            if((pagesStudent+arr[i])<=maxPages){
                pagesStudent+=arr[i];
            }else {
                student++;
                pagesStudent=arr[i];
            }
        }
        return student;
    }
}
