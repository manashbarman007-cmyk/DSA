package bit_manipulation;

public class Unset_i_th_Bit {
    public static void main(String[] args) {
    printBitsMethod2(35);
    toUnsetBitMethod1(35,1);
    toUnsetBitMethod2(35,1);
    }

    //To print num for better understanding
    static void printBitsMethod2(int num){
        for(int i =7;i>=0;i--){
            System.out.print((num>>i & 1));
        }
        System.out.println();
    }

    //To unset the bit by method 1
    static void toUnsetBitMethod1(int num,int i){
        if((num&(1<<i))!=0){
           num= num^(1<<i); //Using XOR
        }
        printBitsMethod2(num);
    }

    //To unset bit by method 2
    static void toUnsetBitMethod2(int num,int i){
        num=num&~(1<<i);
        printBitsMethod2(num);
    }
}
