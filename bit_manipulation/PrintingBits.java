package bit_manipulation;

public class PrintingBits {
    public static void main(String[] args) {
       printBitsMethod1(8);
       printBitsMethod2(8);
    }
    static void printBitsMethod1(int num){
        for(int i=31;i>=0;i--){  //as int has 32 bits
            if((num & (1<<i))!=0){
                System.out.print("1");
            }
            else {
                System.out.print("0");
            }
        }
        System.out.println();

    }
    static void printBitsMethod2(int num){
        for(int i =31;i>=0;i--){
            System.out.print(((num>>i) & 1));
        }
    }
}
