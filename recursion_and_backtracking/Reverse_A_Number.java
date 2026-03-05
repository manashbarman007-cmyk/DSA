package recursion_and_backtracking;

public class Reverse_A_Number {
    public static void main(String[] args) {
        System.out.println(reverseNum(600));
    }

    static int reverseNum(int num){
        int pow=-1,copy=num;
        if(num==0){  //base case
            return 0;
        }

        while(copy>0){ //to count the number of digits in num
            copy/=10;
            pow++;
        }

        int rem=num%10; //to extract the last digit

        return rem*(int)Math.pow(10,pow)+reverseNum(num/10);
    }
}
