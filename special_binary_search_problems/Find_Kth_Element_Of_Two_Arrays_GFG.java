package special_binary_search_problems;

public class Find_Kth_Element_Of_Two_Arrays_GFG {
    public static void main(String[] args) {
        Find_Kth_Element_Of_Two_Arrays_GFG obj=new Find_Kth_Element_Of_Two_Arrays_GFG();
        int[] ex1={2, 3, 6, 7, 9};
        int[] ex2={1, 4, 8, 10};
        System.out.println(obj.kthElement(ex1,ex2,5));

    }
    public int kthElement(int a[], int b[], int k) {
      int n1=a.length,n2=b.length;

      //we swap the arrays, so that binary search always takes place in the smaller array
      if(n1>n2) return kthElement(b,a,k);
      int start=Math.max(0,k-n2), end=Math.min(n1,k);
      while(start<=end){
          int mid1=start+(end-start)/2;
          int mid2= k-mid1;
          int l1=(mid1>0)?a[mid1-1]: Integer.MIN_VALUE;
          int l2=(mid2>0)?b[mid2-1]: Integer.MIN_VALUE;
          int r1=(mid1<n1)?a[mid1]: Integer.MAX_VALUE;
          int r2=(mid2<n2)?b[mid2]: Integer.MAX_VALUE;
          if(l1<=r2 && l2<=r1){
              return Math.max(l1,l2);
          } else if (l1>r2) {
              end=mid1-1;
          } else if (l2>r1) {
              start=mid1+1;
          }
      }
      //returning a dummy value
      return 0;
    }
}
