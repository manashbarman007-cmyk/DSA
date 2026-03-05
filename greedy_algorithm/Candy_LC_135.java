package greedy_algorithm;

import java.util.Arrays;

public class Candy_LC_135 {
    public static void main(String[] args) {
        int[] ratings1 = {1, 0, 2};
        int[] ratings2 = {1, 2, 2};
        int[] ratings3 = {1, 3, 2, 1};
        System.out.println(candy(ratings1));
        System.out.println(candy(ratings2));
        System.out.println(candy(ratings3));
    }
//    public static int candy(int[] ratings) {
//        int n = ratings.length;
//        int[] left = new int[n];
//        left[0] = 1;
//        int[] right = new int[n];
//        right[n - 1] = 1;
//        for (int i = 1; i < n; i++) {
//            if (ratings[i] > ratings[i - 1]) {
//                left[i] = left[i - 1] + 1;
//            }
//            else { //if (ratings[i] <= ratings[i - 1])
//                left[i] = 1;
//            }
//        }
//        for (int i = n - 2; i >= 0; i--) {
//            if (ratings[i] > ratings[i + 1]) {
//                right[i] = right[i + 1] + 1;
//            }
//            else { // if (ratings[i] <= ratings[i + 1])
//                right[i] = 1;
//            }
//        }
//        int sum = 0;
//        for (int i = 0; i < n; i++) {
//            sum += Math.max(left[i], right[i]);
//        }
//        return sum;
//    }

    public static int candy(int[] ratings) {
        int n = ratings.length;
        int[] left = new int[n];
        left[0] = 1;
        int[] right = new int[n];
        right[n - 1] = 1;
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
            else { //if (ratings[i] <= ratings[i - 1])
                left[i] = 1;
            }
        }
        int sum = 0;
        for (int i = n - 2; i >= 0; i--) {
            if (ratings[i] > ratings[i + 1]) {
                right[i] = right[i + 1] + 1;
            }
            else { // if (ratings[i] <= ratings[i + 1])
                right[i] = 1;
            }
            sum += Math.max(left[i + 1], right[i + 1]);
        }
        sum += Math.max(left[0], right[0]);
        return sum;
    }
}
