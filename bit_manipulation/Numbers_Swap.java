package bit_manipulation;

public class Numbers_Swap {
    public static void main(String[] args) {
        toSwap(3,5);
    }
    static void toSwap(int num1,int num2){
        System.out.println("num1:"+num1+", num2: "+num2); //Before swap
        num1=num1^num2;
        num2=num1^num2;
        num1=num1^num2;
        System.out.println("num1:"+num1+", num2: "+num2); //After swap
    }
}
