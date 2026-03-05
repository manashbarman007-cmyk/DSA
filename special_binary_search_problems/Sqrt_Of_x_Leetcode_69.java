package special_binary_search_problems;

public class Sqrt_Of_x_Leetcode_69 {
    public static void main(String[] args) {
        Sqrt_Of_x_Leetcode_69 obj=new Sqrt_Of_x_Leetcode_69();
        int ex1=0;
        System.out.println(obj.mySqrt(ex1));
    }
    public int mySqrt(int x){
        if(x==0){
            return 0;
        }
        int start=1, end=Integer.MAX_VALUE,ans=-1;
        while(start<=end){
            int mid=start+(end-start)/2;
            double deci=(double)x/mid;
            double deciNew=(double)x/(mid+1);
            if(mid<=deci && (mid+1)>deciNew){
               ans=mid;
               break;
            }else if(mid<deci){
                start=mid+1;
            }else {
                end=mid-1;
            }
        }
        return ans;
    }
}
