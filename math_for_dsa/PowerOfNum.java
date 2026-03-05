package math_for_dsa;

public class PowerOfNum {
    public static void main(String[] args) {
//        powFinder(4,3);
        fastExponentiation(2,7);
    }
    static void powFinder(int num, int pow){ // by brute force
        double resNum=1;
        for(int i=0;i<pow;i++){ //as we know the number of how many times, we use for loop
           resNum*=num;
        }
        System.out.println(resNum);
    }
    static void fastExponentiation(int num, int pow){ //by Fast Exponentiation
        double resNum=1;
        while(pow>0){   //as we do not know the number how many times, we use for loop
            if(pow%2!=0){ //odd powers
               resNum*=num; //storing the num
               pow=(pow-1)/2; // for odd powers
            }
            else {
                pow/=2;
            }
            num*=num;
        }
        System.out.println(resNum);
    }
}
