package math_for_dsa;

public class NRMethodToFindSqrt {
   static final double tolerance=0.0001; //made static so that we can call directly
    static double error,root;

    public static void main(String[] args) {
       findSqrt(4,19);
    }

    static void findSqrt(double x,double num){

        while(true){ //we set an infinite while loop as we do not know the number of iterations required


            root=0.5*(x+num/x);
            error=x-root;
            if(Math.abs(error)<tolerance){  //we set a tolerance as in some cases we can not get 100% accurate answer
                break; // we will exit the while loop
            }
            else {
                x=root;//x stores the value of root for the next iteration
            }
        }

        System.out.println("The square root of "+num+" is: "+ root);
    }
}
