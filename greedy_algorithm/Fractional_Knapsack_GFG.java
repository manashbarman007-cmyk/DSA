package greedy_algorithm;

import java.util.Arrays;
import java.util.Comparator;

public class Fractional_Knapsack_GFG {
    public static void main(String[] args) {
        int[] values = {1, 5, 7, 2, 7, 10};
        int[] weights = {4, 9, 6, 3, 7, 3};
        System.out.println(fractionalKnapsack(values, weights, 24));
    }
    static double fractionalKnapsack(int[] values, int[] weights, int W) {
        // code here
        int n = values.length;
        Knapsack[] arr = new Knapsack[n];
        for (int i = 0; i < n; i++) {
            arr[i] = new Knapsack(values[i], weights[i], (double)values[i] / weights[i]);
        }
        Arrays.sort(arr, new SortByValPerUnitWeight());
        return solve(arr, W);
    }

    static double solve (Knapsack[] arr, int W) {
        int n = arr.length;
        double maxValue = 0;
        int ind = 0;
        while (W >= 0 && ind < n) {
            if (W >= arr[ind].weight) {
                W -= arr[ind].weight;
            }
            else {
                break;
            }
            maxValue += arr[ind].values;
            ind++;
        }
        if (W != 0 && ind != n) {
            double remainingVal = arr[ind].valPerUnitWeight * W;
            maxValue += remainingVal;
        }
        return maxValue;
    }
}

class Knapsack {
    int values, weight;
    double valPerUnitWeight;

    public Knapsack(int values, int weight, double valPerUnitWeight) {
        this.values = values;
        this.weight = weight;
        this.valPerUnitWeight = valPerUnitWeight;
    }
}

class SortByValPerUnitWeight implements Comparator<Knapsack> {
    @Override
    public int compare(Knapsack o1, Knapsack o2) {
        double delta= o2.valPerUnitWeight - o1.valPerUnitWeight; // sort the valPerUnitWeight in descending order
                                                                 // we do this as delta is a double quantity but the
                                                                 // method's return type is 'int'
        if(delta > 0){
            return 1;
        }
        if(delta < 0) {
            return -1;
        }
        else {
            return 0;
        }
    }
}

