package special_binary_search_problems;

public class MedianOfTwoSortedArrays_Leetcode_4 {
    public static void main(String[] args) {
        MedianOfTwoSortedArrays_Leetcode_4 obj=new MedianOfTwoSortedArrays_Leetcode_4();
        int[] ex1={1,3};
        int[] ex2={2,7};
        System.out.println(obj.findMedianSortedArrays(ex1,ex2));

    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n1=nums1.length,n2= nums2.length;

        //we swap the two arrays, such that binary search takes place on the smaller array always
        if(n1>n2) return  findMedianSortedArrays(nums2,nums1);

        int n=n1+n2; //total length of the merged array
        int left=(n1+n2+1)/2;//number of elements on the left side of the merged array and this is integer division
        int start=0,end=n1;
        while(start<=end){
            int mid1=start+(end-start)/2, mid2=left-mid1;
            //set the values of l1,l2,r1,r2 using ternary operator
            int l1=(mid1>0)?nums1[mid1-1]:Integer.MIN_VALUE;
            int l2=(mid2>0)?nums2[mid2-1]:Integer.MIN_VALUE;
            int r1=(mid1<n1)?nums1[mid1]:Integer.MAX_VALUE;
            int r2=(mid2<n2)?nums2[mid2]:Integer.MAX_VALUE;

            if(l1<=r2 && l2<=r1){
                if(n%2==0){
                    return ((double) Math.max(l1,l2)+Math.min(r1,r2))/2;
                }
                else {
                    return Math.max(l1,l2);
                }
            } else if(l1>r2){
                end=mid1-1;
            } else if (l2>r1) {
                start=mid1+1;
            }

        }

        //simply returning a dummy value 0, this will never be returned if our code is correct
      return  0;
    }
}
