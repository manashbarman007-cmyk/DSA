package bit_manipulation;

public class Clear_LSB_To_i_th_Bit {
    public static void main(String[] args) {
        printBitsMethod2(127);
        toClearBit(127,4);

    }
    static void printBitsMethod2(int num){
        for(int i =7;i>=0;i--){
            System.out.print(((num>>i) & 1));
        }
        System.out.println();
    }
    static void toClearBit(int num,int i){
        int newNum=num&~((1<<(i+1))-1);
        printBitsMethod2(newNum);

    }
}
