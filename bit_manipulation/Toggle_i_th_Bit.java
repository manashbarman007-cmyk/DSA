package bit_manipulation;

public class Toggle_i_th_Bit {
    public static void main(String[] args) {
        printBitsMethod2(15);
        toToggleBitMethod2(15,2);
        toToggleBitMethod1(32,2);

    }

    //To print num for better understanding
    static void printBitsMethod2(int num){
        for(int i =7;i>=0;i--){
            System.out.print((num>>i & 1));
        }
        System.out.println();
    }
    //Using bitwise NOT
    static void toToggleBitMethod1(int num, int i){ //'i' denotes the i-th bit
      num=~num;
        System.out.println((num>>i & 1));
    }

    //Using bitwise XOR
    static void toToggleBitMethod2(int num, int i) { //'i' denotes the i-th bit
        num=num^(1<<i); //Using XOR to toggle the i-th index
        printBitsMethod2(num);
    }
}
