package graph;

import java.util.*;


public class Merging_Details_GFG {
    public static void main(String[] args) {

        Merging_Details_GFG merge = new Merging_Details_GFG();

        List<List<String>> details = new ArrayList<>();

        List<String> sublist1 = new ArrayList<>();
        sublist1.add("John");
        sublist1.add("j1@.com");
        sublist1.add("j2@.com");
        sublist1.add("j3@.com");
        List<String> sublist2 = new ArrayList<>();
        sublist2.add("John");
        sublist2.add("j4@.com");
        List<String> sublist3 = new ArrayList<>();
        sublist3.add("Raj");
        sublist3.add("r1@.com");
        sublist3.add("r2@.com");
        List<String> sublist4 = new ArrayList<>();
        sublist4.add("John");
        sublist4.add("j1@.com");
        sublist4.add("j5@.com");
        List<String> sublist5 = new ArrayList<>();
        sublist5.add("Raj");
        sublist5.add("r2@.com");
        sublist5.add("r3@.com");
        List<String> sublist6 = new ArrayList<>();
        sublist6.add("Mary");
        sublist6.add("m1@.com");

        details.add(sublist1);
        details.add(sublist2);
        details.add(sublist3);
        details.add(sublist4);
        details.add(sublist5);
        details.add(sublist6);

        System.out.println(merge.mergeDetails(details));
    }
    public List<List<String>> mergeDetails(List<List<String>> details) {
        // Your code here

        int n = details.size();
        List<List<String>> ans = new ArrayList<>();
        HashMap<String, Integer> map = new HashMap<>();
        DisjointSet ds = new DisjointSet(n);

        for (int i = 0; i < n; i++) {
            int m = details.get(i).size();
            for (int j = 1; j < m; j++) {
                String key = details.get(i).get(j);
                Integer value = i;
                if (!map.containsKey(key)) {
                    map.put(key, value);
                }
                else {
                    int prevKey = map.get(key);
                    ds.unionByRank(prevKey, i);
                }
            }
        }


        ArrayList<String>[] mergedArray = new ArrayList[n]; // an array of arraylist

        for (int i = 0; i < n; i++) {
            mergedArray[i] = new ArrayList<>();
        }

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            String key = entry.getKey();
            int value = entry.getValue();
            int root = ds.find(value);
            mergedArray[root].add(key);
        }

        for (int i = 0; i < n; i++) {
            if (mergedArray[i].isEmpty()) continue;

            String name = details.get(ds.find(i)).getFirst();
            Collections.sort(mergedArray[i]);
            mergedArray[i].addFirst(name);
            ans.add(mergedArray[i]);
        }

        return ans;
    }
}
