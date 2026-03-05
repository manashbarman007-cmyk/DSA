package math_for_dsa;

public class BinaryToDecimal {
    public static void main(String[] args) {
       biToDeci(0);
    }
    static void biToDeci(int binaryNum){
        int resNum=0;
        int pow=0;
        while(binaryNum>0){
            int x=binaryNum%10;
            binaryNum/=10; //integer division
            resNum+=x* Math.pow(2,pow);
            pow++;
        }
        System.out.println(resNum);
    }
}
