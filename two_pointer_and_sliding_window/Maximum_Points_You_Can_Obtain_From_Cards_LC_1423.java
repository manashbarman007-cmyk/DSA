package two_pointer_and_sliding_window;

public class Maximum_Points_You_Can_Obtain_From_Cards_LC_1423 {
    public static void main(String[] args) {
        int[] cardPoints1 = {1, 2, 3, 4, 5, 6, 1};
        int[] cardPoints2 = {11, 49, 100, 20, 86, 29, 72};
        System.out.println(maxScore(cardPoints1, 3));
        System.out.println(maxScore(cardPoints2, 4));

    }
//    public static int maxScore(int[] cardPoints, int k) {
//        int n = cardPoints.length;
//        int leftSum = 0;
//        int maxSum = -1;
//        int rl = -1; // right pointer of left window
//        int rr = n - k; // initialize the left and right pointer of right window as 'n'
//        while (rl < k) {
//            if (rl > -1) {
//                leftSum = leftSum + cardPoints[rl];
//            }
//            int rightSum = 0;
//            while (rr < n) {
//                rightSum = rightSum + cardPoints[rr];
//                rr++;
//            }
//            rr = n - k + rl + 2; // we reset the rr
//
//            rl++;
//            int sum = leftSum + rightSum;
//            maxSum = Math.max(maxSum, sum);
//
//        }
//       return maxSum;
//    }

    public static int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        int leftSum = 0;
        int rightSum = 0;
        int maxSum = -1;
        for (int i = 0; i < k; i ++) {
            leftSum += cardPoints[i];
        }
        maxSum = Math.max(maxSum, leftSum);

        int rl = k - 1; // right pointer of left window
        int lr = n - 1; // initialize the right pointer of right window as 'n - 1'

        while (rl >= 0) {
            leftSum = leftSum - cardPoints[rl]; // we shrink the left window
            rl--;
            rightSum = rightSum + cardPoints[lr]; // we expand the right window
            lr--;
            int sum = leftSum + rightSum;
            maxSum = Math.max(maxSum, sum);
        }
       return maxSum;
    }
}
