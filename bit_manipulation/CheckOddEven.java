package bit_manipulation;

import java.util.Scanner;
public class CheckOddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while (true) {  //infinite while loop
            System.out.print("Enter number: ");
            int num = sc.nextInt();
            if ((num & 1) != 0) {
                System.out.println("It is an odd number");
            } else {
                System.out.println("It is an even number");
            }
        }
    }
}
