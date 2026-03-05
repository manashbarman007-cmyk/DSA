package math_for_dsa;

public class Armstrong {
    public static void main(String[] args) {
       isArmstrong(9474);
    }
    static void isArmstrong(int num) {
        int copy=num; //after running through the while loop num will become 0. So, we create a copycat
        int sum=0;
        String ref= Integer.toString(num);
        int count=ref.length();

        while(num>0){  //use while as we do not know the number of loops required and we run the while loop until the
                       // num becomes 0
          int reNum=1; //we want reNum to have value 1 when starting the for loop for each iteration in while loop
          int x = num%10; //store the one's place digit
          num/=10; // remove the one's place digit
          for(int i=0;i<count;i++){
              reNum*=x;
          }

          sum+=reNum;
        }
      if(copy==sum){
          System.out.println("It is an armstrong number");
      }else {
          System.out.println("Not an armstrong number");
      }
    }
}
