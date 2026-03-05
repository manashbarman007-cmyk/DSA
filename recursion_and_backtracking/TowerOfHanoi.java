package recursion_and_backtracking;

public class TowerOfHanoi {
    public static void main(String[] args) {
        tOH(3,'A','B','C');
    }

    static void tOH(int n,char src,char aux,char dest){
        if(n==1){ //base case
            System.out.println(src+" -> "+dest);
            return;
        }
        tOH(n-1,src,dest,aux);
        tOH(1,src,aux,dest);
        tOH(n-1,aux,src,dest);
    }
}
