package math_for_dsa;

public class LengthOfNumber {
    public static void main(String[] args) {
        numReverse(590876);
    }
    static void numReverse(int num){
        int sum=0;
        String ref=Integer.toString(num); //converting the integer to a string
        int y= ref.length();
        while(num>0){
            int x=num%10;  //to obtain the one's ; / unit's place digit
            num/=10; // to remove the one's / unit's place digit
            y--;
            sum+=x*Math.pow(10,y);
        }
        System.out.println(sum);
    }
}
