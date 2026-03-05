package math_for_dsa;

public class NumberFactorial {
    public static void main(String[] args) {
        System.out.println(findFactorial(4));
    }
    static int findFactorial(int num){
        int factorial=1;
        for(int i=num;i>=1;i--){
            factorial*=i;
        }
        return factorial;
    }
}
