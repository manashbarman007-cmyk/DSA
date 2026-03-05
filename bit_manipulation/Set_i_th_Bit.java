package bit_manipulation;

public class Set_i_th_Bit {
    public static void main(String[] args) {
        setBit(8,2);
    }
    static void setBit(int num,int i){ //'i' denotes the i-th bit
      num=(num|1<<i);  //The i-th bit will always be set no matter what
      if((num&(1<<i))!=0){
          System.out.println("The bit is set");
      }
      else{
          System.out.println("The bit is not set");
      }
    }
}
