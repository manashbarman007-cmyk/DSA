package graph;

import java.util.*;

public class Word_Ladder_ii_GFG {
    public static void main(String[] args) {
        Word_Ladder_ii_GFG wordLadder2Gfg = new Word_Ladder_ii_GFG();
        String[] wordList1 = {"des", "der", "dfr", "dgt", "dfs"};
        String[] wordList2 = {"poon", "plee", "same", "poie", "plea", "plie", "poin"};
        System.out.println(wordLadder2Gfg.findSequences("der", "dfs", wordList1));
        System.out.println(wordLadder2Gfg.findSequences("toon", "plea", wordList2));

    }

    // Approach 1 : Brute Force
    public ArrayList<ArrayList<String>> findSequences(String startWord, String targetWord, String[] wordList) {
        // Code here
        int n = wordList.length;
        Set<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(wordList[i]);
        }
        ArrayList<ArrayList<String>> ans = new ArrayList<>();
        Queue<ArrayList<String>> queue = new LinkedList<>();
        bfs(startWord, targetWord, queue, set, ans);

        return ans;
    }

    public void bfs(String startWord, String targetWord, Queue<ArrayList<String>> queue,
                    Set<String> set, ArrayList<ArrayList<String>> ans) {
        ArrayList<String> sublist = new ArrayList<>();
        sublist.add(startWord);
        queue.add(sublist);
        int level = 0;
        int minSize = Integer.MAX_VALUE;

        while (!queue.isEmpty()) {
            ArrayList<String> curArrayList = queue.poll();
            String curWord = curArrayList.getLast();
            int n = curWord.length();

            // most important step
            if (curArrayList.size() > level) {
                level++;
                for (String word : curArrayList) {
                    set.remove(word);
                }
            }
            for (int i = 0; i < n; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] chArr = curWord.toCharArray();
                    chArr[i] = ch;
                    String replacedWord = new String(chArr);
                    if (set.contains(replacedWord)) {
                        ArrayList<String> newList = new ArrayList<>(curArrayList);
                        newList.add(replacedWord);
                        queue.offer(newList);
                        if (replacedWord.equals(targetWord)) {
                            minSize = Math.min(minSize, newList.size());
                            if (newList.size() == minSize) {
                                ans.add(newList);
                            }
                        }
                    }
                }
            }
        }
    }
}
