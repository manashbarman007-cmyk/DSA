package math_for_dsa;

public class DigitCounter {
    public static void main(String[] args) {
//        System.out.println(digCounter(9876678));
        System.out.println("The number of digits are: "+ digCounterNew(764547));
    }
    static int digCounter(int num){ //using iterative method
        int count=0;
        if(num==0){   //if we enter 0, we will get 1
            return 1;}

        while(num>0){
           num/=10; // we remove unit's place digit until num becomes 0
           count++;
         }

        return count;
    }
    static int digCounterNew(int num){ //using log10
        if(num==0){
            return 1;
        }
       return (int) Math.floor(Math.log10(num)+1);  //type cast
    }
}

