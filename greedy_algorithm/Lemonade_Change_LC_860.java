package greedy_algorithm;

import java.util.Arrays;

public class Lemonade_Change_LC_860 {
    public static void main(String[] args) {
        int[] bills1 = {5, 5, 5, 10, 20};
        int[] bills2 = {5, 5, 10, 10, 20};
        System.out.println(lemonadeChange(bills1));
        System.out.println(lemonadeChange(bills2));
    }
    public static boolean lemonadeChange(int[] bills) {
        int n = bills.length;
        int totalSale = 5 * n;
        int count_5 = 0, count_10 = 0, count_20 = 0;
        for (int i = 0; i < n; i++) {
            int curBill = bills[i];
            if (curBill == 5) {
                count_5++;
            }
            else if (curBill == 10) {
                count_10++;
                if (count_5 > 0) {
                    count_5--; // as we have to give a $5 bill back
                }
                else {
                    return false;
                }
            }
            else { // if (curBill == 20)
                count_20++;
                if (count_10 > 0) {
                    count_10--; // we return a $10 bill
                    if (count_5 > 0) {
                        count_5--; // we return a $5 bill
                    }
                    else {
                        return false;
                    }
                }
                else { // if count_10 == 0
                    if (count_5 >= 3) {
                        count_5 = count_5 - 3; // we return three $5 bills
                    }
                    else {
                        return false;
                    }
                }
            }
        }
        int totalSalesAtEnd = (5 * count_5) + (10 * count_10) + (20 * count_20);
        if (totalSalesAtEnd == totalSale) {
            return true;
        }
        return false; // just a dummy return
    }
}
