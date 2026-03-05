package graph;

import java.util.*;

public class Alien_Dictionary_GFG {
    public static void main(String[] args) {
        Alien_Dictionary_GFG alien = new Alien_Dictionary_GFG();
        String[] words1 = {"baa", "abcd", "abca", "cab", "cad"};
        String[] words2 = {"ab", "cd", "ef", "ad"};
        String[] words3 = {"aa", "aab", "ab", "b", "babbb"};
        System.out.println(alien.findOrder(words1));
        System.out.println(alien.findOrder(words2));
        System.out.println(alien.findOrder(words3));
    }

    public String findOrder(String[] words) {
        // code here

        Set<Character> set = new TreeSet<>(); // store unique chars in set in ascending order

        for (String word : words) {
            int n = word.length();
            for (int i = 0; i < n; i++) {
                set.add(word.charAt(i));
            }
        }
        HashMap<Character, Integer> lettersMap = new HashMap<>();
        int ind = 0;
        for (Character character : set) {
            lettersMap.put(character, ind);
            ind++;
        }
        ArrayList<ArrayList<Integer>> adjList = constructAdjList(words, lettersMap);

        if (adjList == null) return "";

        ArrayList<Integer> topoSort = topoSort(lettersMap.size(), adjList);

        String ans = "";

        for (int i = 0; i < topoSort.size(); i++) {
            ans = ans + getKeyByValue(lettersMap, topoSort.get(i));
        }

        if (ans.length() == lettersMap.size()) {
            return ans;
        }
        return "";
    }

    public Character getKeyByValue(HashMap<Character, Integer> lettersMap, Integer value) {
        for (Map.Entry<Character, Integer> entry : lettersMap.entrySet()) {
            if (value == entry.getValue()) {
                return entry.getKey();
            }
        }
        return null;
    }

    public ArrayList<ArrayList<Integer>> constructAdjList(String[] words, HashMap<Character, Integer> lettersMap) {
        int n = words.length;
        int m = lettersMap.size();
        ArrayList<ArrayList<Integer>> adjList = new ArrayList<>();
        for (int i = 0; i < m; i++) {
            adjList.add(new ArrayList<>());
        }
        for (int i = 0; i <= n - 2; i++) {
            String a = words[i];
            String b = words[i + 1];
             int length = Math.min (a.length(), b.length());
             for (int j = 0; j < length; j++) {

                 // edge case (not valid lexicographical order)
                 if (a.startsWith(b) && a.length() > b.length()) return null;


                 if (a.charAt(j) != b.charAt(j)) {
                     adjList.get(lettersMap.get(a.charAt(j))).add(lettersMap.get(b.charAt(j)));
                     break; // get out of the inner for loop
                 }
             }
        }
        return adjList;
    }
    public ArrayList<Integer> topoSort(int V, ArrayList<ArrayList<Integer>> adjList) {
        // code here
        int[] countIndegree = findIndegree(adjList);
        Queue<Integer> queue = new LinkedList<>();
        ArrayList<Integer> topo = new ArrayList<>();

        bfs(V, adjList, countIndegree, queue, topo);

        return topo;
    }

    public void bfs (int V, ArrayList<ArrayList<Integer>> adjList,
                     int[] countIndegree, Queue<Integer> queue,
                     ArrayList<Integer> topo) {

        for (int i = 0; i < V; i++) {
            if (countIndegree[i] == 0) queue.offer(i); // offer the 0 in-degree elements into the queue
        }

        while (!queue.isEmpty()) {
            int curNode = queue.poll();
            for (int adjNode : adjList.get(curNode)) {
                int updateIndegree = countIndegree[adjNode] - 1; // reduce the indegree count of the adjNode by 1
                countIndegree[adjNode] = updateIndegree; // update the new indegree
                if (updateIndegree == 0) { // if the count is 0 add it to the queue
                    queue.offer(adjNode);
                }
            }
            topo.add(curNode);
        }
    }

    public int[] findIndegree(ArrayList<ArrayList<Integer>> adjList) {
        int n = adjList.size();
        int[] countIndegree = new int[n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < adjList.get(i).size(); j++) {
                int curEle = adjList.get(i).get(j);
                countIndegree[curEle]++;
            }
        }
        return countIndegree;
    }
}
