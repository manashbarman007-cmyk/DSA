package recursion_and_backtracking;
import java.util.*;

public class Josephus_Problem_GFG {
    public static void main(String[] args) {
        Josephus_Problem_GFG obj=new Josephus_Problem_GFG();
        System.out.println(obj.josephus(5,3));
        System.out.println(obj.josephus(3,2));

    }
    public int josephus(int n, int k) {
        // Your code here
        List<Integer> killPerson =new ArrayList<>();
        for (int i=0;i<n;i++){
            killPerson.add(i+1);
        }
        return helperFunc(killPerson,n,k,0);
    }

    static int helperFunc(List<Integer> list,int n,int k,int ind){
        //base case
        if(n==1){
            return list.get(0);
        }
        list.remove((ind+k-1)%n);
        return helperFunc(list,n-1,k,(ind+k-1)%n); //ie when we obtain the solution,  we return the solution to
                                                          //all the previous recursive calls
    }
}
