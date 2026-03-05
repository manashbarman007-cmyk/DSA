package greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Minimum_Platforms_GFG {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1200, 1120, 1130, 1900, 2000};
        System.out.println(findPlatform(arr, dep));

    }
    static int findPlatform(int arr[], int dep[]) {
        // add your code here
        int n = arr.length;
        if (n == 1) {
            return 1;
        }
        Platforms[] array = new Platforms[2 * n];
        for (int i = 0; i < n; i++) {
            array[i] = new Platforms(arr[i], 'A');
        }
        for (int i = n; i < 2 * n; i++) {
            array[i] = new Platforms(dep[i % n], 'D');
        }
        Arrays.sort(array, new sortByTiming());
        return solve(array);
    }

    static int solve(Platforms[] array) {
        int count = 0;
        int maxCount = -1;
        int n = array.length;
        for (int i = 0; i < n; i++) {
            if (array[i].status == 'A') {
                count++;
                maxCount = Math.max(count, maxCount);
            }
            else { // if (array[i].status == 'D')
                count--; // reset count as 1
            }
        }
        return maxCount;
    }
}

class Platforms {
    int timing;
    char status;

    public Platforms(int timing, char status) {
        this.timing = timing;
        this.status = status;
    }
}

class sortByTiming implements Comparator<Platforms> {
    @Override
    public int compare(Platforms o1, Platforms o2) {
        return o1.timing - o2.timing; // sort timing by ascending order
    }
}
