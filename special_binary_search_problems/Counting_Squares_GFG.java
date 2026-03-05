package special_binary_search_problems;

public class Counting_Squares_GFG {
    public static void main(String[] args) {
        int ex = 17;
        System.out.println(countSquares(ex));
    }

    static int countSquares(int n) {
        int start = 1, end = Integer.MAX_VALUE, res = -1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            double deci = (double) n / mid;
            double deciNew = (double) n / (mid + 1);
            if (mid <= deci && (mid + 1) > deciNew) {
                res = mid;
                break;
            } else if (mid < deci) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        if (Math.sqrt(n) % 1 == 0) {
            return res - 1;
        } else {
            return res;
        }
    }
}
