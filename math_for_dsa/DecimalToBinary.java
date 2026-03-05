package math_for_dsa;

public class DecimalToBinary {
    public static void main(String[] args) {
    deciToBi(9);// as it is static we can directly call it without object creation
    }

    static void deciToBi(int decimalNum) {
       int resNum=0;
       int pow =0;

        while(decimalNum>0){
          int rem= decimalNum%2;
          decimalNum/=2;
          resNum+=rem* Math.pow(10,pow); // this is 10/\pow and we have to multiply the incoming modulo number by this
          pow++;
       }
        System.out.println(resNum);

    }
}
