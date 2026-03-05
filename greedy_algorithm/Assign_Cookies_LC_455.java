package greedy_algorithm;

import java.util.Arrays;

public class Assign_Cookies_LC_455 {
    public static void main(String[] args) {
        int[] g1 = {1, 2, 3}, s1 = {1, 1};
        int[] g2 = {1, 2}, s2 = {1, 2, 3};
        int[] g3 = {1, 5, 3, 3, 4}, s3 = {4, 2, 1, 2, 1, 3};

        System.out.println(findContentChildren(g1, s1));
        System.out.println(findContentChildren(g2, s2));
        System.out.println(findContentChildren(g3, s3));
    }
    public static int findContentChildren(int[] g, int[] s) {
        int n = g.length;
        int m = s.length;
        Arrays.sort(g);
        Arrays.sort(s);
        int contentChild = 0, l = 0, r = 0;
        while (l < n && r < m) {
            if (s[r] >= g[l]) {
                contentChild++;
                l++;
                r++;
            }
            else {
                r++;
            }
        }
        return contentChild;
    }
}
