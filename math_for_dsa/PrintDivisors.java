package math_for_dsa;

public class PrintDivisors {
    public static void main(String[] args) {
        findDivisors(36);
    }
    static void findDivisors(int num){
        System.out.println("The divisors of "+num+" are: ");
        for(int i=1;i<=num/2;i++){ //important concept, we only need to go till num/2 as after that the digits repeat
            if(num%i==0){
                System.out.print(i + " ");
            }
        }
    }
}
