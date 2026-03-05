package different_searching_algorithms;

public class TernarySearchAlgorithm {
    public static void main(String[] args) {
        int[] ex={2,3,5,7,11,16,19,24,30,42};
        System.out.println(performTernarySearch(ex,16));
    }
    static int performTernarySearch(int[] arr,int target){
        int start=0,end=arr.length-1,res=-1;
        while(start<=end){
            int mid1=start+(end-start)/3;
            int mid2=end-(end-start)/3;
            if(target<=arr[mid1]){
                if(target==arr[mid1]){
                    res=mid1;
                    break;
                }else {
                    end=mid1-1;
                }
            }else if(target>=arr[mid2]){
                if(target==arr[mid2]){
                    res=mid2;
                    break;
                }else {
                    start=mid2+1;
                }
            }else {  //else target lies between mid1 and mid2
                start=mid1+1;
                end=mid2-1;
            }
        }
        return res;
    }
}
