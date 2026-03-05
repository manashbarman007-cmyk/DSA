package bit_manipulation;

public class Find_Number_Of_Set_Bits {

    public static void main(String[] args) {
        printBitsMethod2(67);
        toFindNumberOfSetBits(67);
    }
    static void printBitsMethod2(int num){
        for(int i =7;i>=0;i--){
            System.out.print(((num>>i) & 1));
        }
        System.out.println();
    }
    static void toFindNumberOfSetBits(int num){
       int counter=0,copy=num;
       while(num>0){ //Used while loop as we do not know the number of iterations required
           num=num&(num-1);
           counter++;
       }
        System.out.println("The number of set bits in "+copy+" are: "+counter);
    }
}
