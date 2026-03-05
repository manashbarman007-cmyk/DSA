package greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class N_Meetings_In_One_Room_GFG {
    public static void main(String[] args) {
        int[] start = {0, 3, 1, 5, 5, 8};
        int[] end = {5, 4, 2, 9, 7, 9};
//        int[] start = {7, 18, 24};
//        int[] end = {30, 26, 28};
        System.out.println(maxMeetings(start, end));
    }
    public static int maxMeetings(int start[], int end[]) {
        // add your code here
        int n = start.length;
        Meetings[] arr = new Meetings[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Meetings(start[i], end[i], i + 1);
        }
        Arrays.sort(arr, new sortByEnd());
        return solve(arr);
    }

    static int solve(Meetings[] arr) {
        int count = 1; // as the minimum meeting that can be held is 1
        int n = arr.length;
        int freeTime = arr[0].end;
        int[] ds = new int[n]; // ds : data structure to store the position of the meetings that can be held
                               // ds will be helpful if it is asked to return the positions of the meetings in some problem
        ds[0] = arr[0].position;
        for (int i = 1; i < n; i++) {
           if (arr[i].start > freeTime) {
              count++;
              freeTime = arr[i].end;
              ds[i] = arr[i].position;
           }
        }
        return count;
    }
}

class Meetings {
    int start, end, position;

    public Meetings(int start, int end, int position) {
        this.start = start;
        this.end = end;
        this.position = position;
    }
}

class sortByEnd implements Comparator<Meetings> {
    @Override
    public int compare(Meetings o1, Meetings o2) {
        return o1.end - o2.end; // sort end by ascending order
    }
}
