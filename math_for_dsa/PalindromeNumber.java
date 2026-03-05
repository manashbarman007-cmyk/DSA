package math_for_dsa;

public class PalindromeNumber {
    public static void main(String[] args) {
           isPalindrome(1331);
    }
    static void isPalindrome(int num){ //our first objective is to reverse the number
      int copy=num; //we create a copycat as num will finally become 0
      String ref= Integer.toString(num);
      int count=ref.length();
      int resSum=0;
      while(num>0){
          int x = num%10; // to obtain the unit's place digit
          num/=10; //to remove the unit's place digit
          count--;
          resSum+=x*Math.pow(10,count);
      }
        System.out.println("The reversed number is: "+ resSum);
      if(resSum==copy){
          System.out.println("It is a palindrome number");
      }else {
          System.out.println("It is not a palindrome number");
      }
    }
}
