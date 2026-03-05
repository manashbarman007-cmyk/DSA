package recursion_and_backtracking;

public class Types_Of_Recursion {
    public static void main(String[] args) {
//        tailRecursion(3);
//        headRecursion(3);
//        System.out.println(linearRecursion(6));
        System.out.println(treeRecursion(0));
    }

    static void tailRecursion(int n){
        if(n>=0){ //base case
            System.out.print(" "+n);
            tailRecursion(n-1); //recursive call as the last statement and there is no statement after the call
        }
    }

    static void headRecursion(int n){
        if(n>=0){ //base case
            headRecursion(n-1); //recursive call as the first statement and there is statement aster the call
            System.out.print(" "+n);
        }
    }

    //implementing linear recursion using tail recursion
    static int linearRecursion(int n){
        if(n<=0){
            return 0;
        }
        return n+linearRecursion(n-1); //The sum of first n whole numbers
    }

    //Tree recursion (example:Finding the n-th term of Fibonacci sequence)
    static int treeRecursion(int n){
        //base case 1
        if(n==0){
            return 0;
        }
        //base case 2
        else if(n==1){
            return 1;
        }
        return treeRecursion(n-1)+treeRecursion(n-2); //the recursive function is called more than once, so
                                                            //it is a tree recursion
    }
}
