package math_for_dsa;

public class DecimalToAnyBase   {
    public static void main(String[] args) {
        deciToAnyBase(79,8);
    }
    static void deciToAnyBase(int decimalNum,int base) {
        int resNum=0;
        int pow =0;

        while(decimalNum>0){
            int rem= decimalNum%base;
            decimalNum/=base;
            resNum+=rem* Math.pow(10,pow); // this is 10/\pow and we have to multiply the incoming modulo number by this
            pow++;
        }
        System.out.println(resNum);

    }
}
