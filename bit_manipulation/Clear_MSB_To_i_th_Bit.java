package bit_manipulation;

public class Clear_MSB_To_i_th_Bit {
    public static void main(String[] args) {
        printBitsMethod2(180);
        toClearBit(180,5);
        toClearBitNew(180,5);

    }
    static void printBitsMethod2(int num){
        for(int i =7;i>=0;i--){
            System.out.print(((num>>i) & 1));
        }
        System.out.println();
    }

    //i-th bit is also included
    static void toClearBit(int num,int i){
        int newNum=num&((1<<i)-1);
        printBitsMethod2(newNum);
    }

    //i-th bit is excluded
    static void toClearBitNew(int num,int i){
        int newNum=num&((1<<(i+1))-1);
        printBitsMethod2(newNum);
    }
}
