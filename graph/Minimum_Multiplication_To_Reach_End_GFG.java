package graph;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Minimum_Multiplication_To_Reach_End_GFG {
    public static void main(String[] args) {
        Minimum_Multiplication_To_Reach_End_GFG min = new Minimum_Multiplication_To_Reach_End_GFG();
        int[] arr1 = {2, 5, 7};
        int[] arr2 = {3, 4, 65};
//        System.out.println(min.minimumMultiplications(arr1, 3, 30));
        System.out.println(min.minimumMultiplications(arr2, 7, 66175));

    }
    int minimumMultiplications(int[] arr, int start, int end) {

        // Your code here
        Queue<Pair10> queue = new LinkedList<>();
        int[] multi = new int[100000 + 1];
        func(arr, start, multi, queue);

        return (multi[end] != Integer.MAX_VALUE) ? multi[end] : -1;
    }

    public void func(int[] arr, int start, int[] multi, Queue<Pair10> queue) {
        Arrays.fill(multi, Integer.MAX_VALUE);
        multi[start] = 0;
        queue.offer(new Pair10(start, 0));
        while (!queue.isEmpty()) {
            Pair10 curPair = queue.poll();
            int curNum = curPair.num;
            int curTimes = curPair.times;
            for (int number : arr) {
                int newNum = (curNum * number) % 100000;
                if (multi[newNum] > curTimes + 1) { // we will store the min number of times
                    multi[newNum] = curTimes + 1;
                    queue.offer(new Pair10(newNum, multi[newNum]));
                }
            }
        }
    }


}
class Pair10 {
    int num;
    int times;

    public Pair10(int num, int times) {
        this.num = num;
        this.times = times;
    }
}
