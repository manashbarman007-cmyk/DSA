package math_for_dsa;

public class EuclideanGCD_And_LCM {
    public static void main(String[] args) {
      isGCD1(36,24);
      isGCD2(6,24);
      findLCM(24,36);
    }
    static void isGCD1(int num1,int num2) {
        while(num1!=0 && num2!=0){  //The loop stops when either num1 or num2 become 0
            if(num1>num2){
                num1-=num2;
            }
            else {
                num2-=num1;
            }
        }
        if(num1==0){
            System.out.println("GCD is "+num2);
        }
        else {
            System.out.println("GCD is "+num1);
        }
    }


    //This method is more efficient as it takes less number of loops
    static void isGCD2(int num1,int num2){
        while(num1!=0 && num2!=0){  //The loop stops when either num1 or num2 become 0
            if(num1>num2){
                num1%=num2;
            }
            else {
                num2%=num1;
            }
        }
        if(num1==0){
            System.out.println("GCD is "+num2);
        }
        else {
            System.out.println("GCD is "+num1);
        }
    }

    static void findLCM(int num1,int num2){
        int copy1=num1, copy2=num2;
        while(num1!=0 && num2!=0){ // the loop stops if either num1 or num2 become 0
            if(num1>num2){
                num1%=num2;
            }
            else{
                num2%=num1;
            }
        }
        if(num1==0){
            int lcm= (copy1*copy2)/num2;
            System.out.println("LCM is "+lcm);
        }
        else {
            int lcm= (copy1*copy2)/num1;
            System.out.println("GCD is "+lcm);
        }

    }
}
