package bit_manipulation;

public class Check_If_i_th_Bit_Set {
    public static void main(String[] args) {
        isBitSet(35,2);
    }
    static void isBitSet(int num, int i){ //'i' denotes the i-th bit
        if((num & 1<<i)!=0){
            System.out.println(i+ "-th bit is set");
        }
        else{
            System.out.println(i+ "-th bit is not set");
        }
    }
}
