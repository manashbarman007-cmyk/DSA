package math_for_dsa;

public class AnyBaseToDecimal {
    public static void main(String[] args) {
      anyBaseToDeci(101,2);
    }
    static void anyBaseToDeci(int binaryNum,int base){
        int resNum=0;
        int pow=0;
        while(binaryNum>0){
            int x=binaryNum%10; //unit digit
            binaryNum/=10; //integer division
            resNum+=x* Math.pow(base,pow);
            pow++;
        }
        System.out.println(resNum);
    }
}
