package math_for_dsa;

public class TrailingZeroInFactorial {
    public static void main(String[] args) {
        findTrailingZerosInFactorial1(130);
        findTrailingZerosInFactorial2(130);
    }

    //method 1
    static  void findTrailingZerosInFactorial1(double num){
        if(num<5){
            System.out.println("The number of trailing zeros in "+num+"! is 0");
        }
        else if(num>=5 && num<25){
            double x= Math.floor(num/5);
            System.out.println("The number of trailing zeros in "+num+"! is: "+x);
        } else if (num>=25 && num<125) {
            double x= Math.floor(num/25)+Math.floor(num/5);
            System.out.println("The number of trailing zeros in "+num+"! is: "+x);
        }else if (num>=125 && num<625) {
            double x= Math.floor(num/125)+Math.floor(num/25)+Math.floor(num/5);
            System.out.println("The number of trailing zeros in "+num+"! is: "+x);
        }

    }

    //method-2
    static  void findTrailingZerosInFactorial2(int num){
        int res=0;
        for(int i=5; i<=num; i=i*5){  //the value of 'i' increases as 5*5 then 25*5 then 125*5 and so on
            res= res+ (num/i); // no need to use floor function as we are doing integer division
        }
        System.out.println("The number of trailing zeros in "+num+"! is: "+res);
    }

}
