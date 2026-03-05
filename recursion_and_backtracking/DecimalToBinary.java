package recursion_and_backtracking;

public class DecimalToBinary {
    public static void main(String[] args) {
        System.out.println(toBinary(1632));
        System.out.println(decToBinary(1632));

    }

    static long toBinary(int decimalVal){

        if(decimalVal==0) {   //base case

            return 0;
        }

        long remainder=decimalVal%2;


        return remainder+10*toBinary(decimalVal/2);
    }

    //alternate way
    static String decToBinary(int n) {
        // code here
        if(n==0) return "0";
        if(n==1) return "1";
        return decToBinary(n/2) + n%2;
    }
}


