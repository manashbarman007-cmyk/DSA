package bit_manipulation;

public class Unset_Rightmost_Set_Bit {
    public static void main(String[] args) {
      printBitsMethod2(55);
      toUnsetRightmostSetBit(55);
    }
    static void printBitsMethod2(int num){
        for(int i =7;i>=0;i--){
            System.out.print(((num>>i) & 1));
        }
        System.out.println();
    }
    static void toUnsetRightmostSetBit(int num){
        num=num&(num-1);
        printBitsMethod2(num);
    }
}
