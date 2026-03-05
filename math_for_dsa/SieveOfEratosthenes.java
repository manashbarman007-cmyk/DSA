package math_for_dsa;

public class SieveOfEratosthenes {
    public static void main(String[] args) {
        sieveOfEratosthenes(10);
    }

    static void sieveOfEratosthenes(int n){
        //create a boolean array of size n+1 and set all the values to be true
        boolean[] isPrime=new boolean[n+1];
        for(int i=0;i<=n;i++){
            isPrime[i]=true;  //all the array elements are set true
        }

        //check every number >=2 for prime
        for(int p=2; p<=n;p++){

            //p is prime if it has  not crossed off yet
            if(isPrime[p]){

                //now our goal is to cross off the multiple of this prime
                //for(int j=2*p; j<=n+1;j+=p ){
                for(int j=p*p; j<=n;j+=p ){  //this for loop is more efficient, see notes foe reference
                                            //j increases as multiple of p, since j+=p
                   isPrime[j]=false;
                }
            }
        }

        //for loop to print the prime numbers
        for (int i=2;i<=n;i++){
            if(isPrime[i]){
                System.out.print(i + " ");
            }
        }
    }

}
