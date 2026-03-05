package math_for_dsa;

public class GCD {
    public static void main(String[] args) {
           findGCD(0,36);
    }

    static void findGCD(int num1, int num2) {
        int min = num1 < num2 ? num1 : num2;  //Using ternary operator
        while(min>0){
            if(num1%min==0 && num2%min==0){ // that is min is a divisor for both the numbers
                System.out.println("GCD is "+min);
                break; //we come out of the loop
            }
            else {
                min--;
            }
        }
        if(num1==0){
            System.out.println("GCD is "+num2);
        } else if(num2==0){
            System.out.println("GCD is "+num1);
        }
    }
}
