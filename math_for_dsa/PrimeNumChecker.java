package math_for_dsa;

public class PrimeNumChecker {
    public static void main(String[] args) {
        isPrime(2 );
    }
    static void isPrime(int num){
        int counter=2;
        boolean isNumPrime=true;
        while(counter<num && num!=1){

           if (num%counter==0){  //it is not a prime number
               isNumPrime=false;
               break; //we will come out of the while loop
           }
            counter++;
        }if(num==1){
            System.out.println("It is not a prime number");
        }
       else if(isNumPrime==false){
            System.out.println("It is not a prime number");
        }
      else {
            System.out.println("It is a prime number");
        }
    }
}
