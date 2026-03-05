package greedy_algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

public class Job_Sequencing_GFG{
    public static void main(String[] args) {
        int[] deadline = {3, 1, 2, 2}, profit = {50, 10, 20, 30};
        System.out.println(jobSequencing(deadline, profit));
    }
    public static ArrayList<Integer> jobSequencing(int[] deadline, int[] profit) {
        // code here
        int n = deadline.length;
        Jobs[] arr = new Jobs[n]; // creating a Jobs array
        for (int i = 0; i < n; i++) {
            arr[i] = new Jobs(i + 1, deadline[i], profit[i]);
        }
        Arrays.sort(arr, new SortDescending());
        return solve(arr);
    }

    public static ArrayList<Integer> solve (Jobs[] arr) {
        int maxProfit = 0, count = 0, maxDeadline = -1;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            maxDeadline = Math.max(maxDeadline, arr[i].deadline); // we will get the maxDeadLine
        }
        int[] newArr = new int[maxDeadline + 1];
        Arrays.fill(newArr, -1);
        for (int i = 0; i < n; i++) {
            for (int j = arr[i].deadline; j > 0; j--) {
                if (newArr[j] == -1) {
                    count++;
                    newArr[j] = arr[i].id;
                    maxProfit += arr[i].profit;
                    break;
                }
            }
        }
        ArrayList<Integer> list = new ArrayList<>();
        list.add(count);
        list.add(maxProfit);
        return list;
    }
}

class Jobs {
    int id, deadline, profit;

    // constructor
    Jobs(int id, int deadline, int profit) {
        this.id = id;
        this.deadline = deadline;
        this.profit = profit;
    }

//    @Override
//    public String toString() {
//        return "Jobs{" +
//                "id=" + id +
//                ", deadline=" + deadline +
//                ", profit=" + profit +
//                '}';
//    }
}

class SortDescending implements Comparator<Jobs> {
    @Override
    public int compare (Jobs o1, Jobs o2) {
        return o2.profit - o1.profit; // to sort in descending order based on profit
    }
}
