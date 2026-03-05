package recursion_and_backtracking;

public class Print_Patterns_By_Recursion {
    public static void main(String[] args) {
//        printPattern();
        printPatternByRecursion(0,5);
    }


    //using for loop
    static void printPattern() {
        int b = 1;
        for (int i = 0; i < 4; i++) {
            for (int j = 0; j <= i; j++) {
                System.out.print(b + " ");
                b++;
            }
            System.out.println();
        }
    }

    //using recursion
    static void printPatternByRecursion(int i, int n) {
        int b = 0;
        //base case
        if (i < n - 1) {
            for (int j = 0; j <= i; j++) {
                System.out.print(b + " ");
                b++;
            }
            System.out.println();
        }
        printPatternByRecursion(i+1,n);
    }
}
