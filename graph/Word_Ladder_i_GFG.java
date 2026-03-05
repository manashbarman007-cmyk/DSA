package graph;

import java.util.*;

public class Word_Ladder_i_GFG {
    public static void main(String[] args) {

        Word_Ladder_i_GFG wordLadderIGfg = new Word_Ladder_i_GFG();
        String[] wordList1 = {"des", "der", "dfr", "dgt", "dfs"};
        String[] wordList2 = {"poon", "plee", "same", "poie", "plea", "plie", "poin"};
        System.out.println(wordLadderIGfg.wordLadderLength("der", "dfs", wordList1));
        System.out.println(wordLadderIGfg.wordLadderLength("toon", "plea", wordList2));

    }
    public int wordLadderLength(String startWord, String targetWord,
                                String[] wordList) {
        // Code here
        int n = wordList.length;
        Set<String> set = new HashSet<>();
        Set<String> visitedWords = new HashSet<>();
        for (int i = 0; i < n; i++) {
            set.add(wordList[i]);
        }

        Queue<Pair6> queue = new LinkedList<>();

        return bfs(startWord, targetWord, queue, set, visitedWords);
    }

    public int bfs (String startWord, String targetWord,
                     Queue<Pair6> queue, Set<String> set, Set<String> visitedWords) {
        queue.offer(new Pair6(startWord, 1));
        visitedWords.add(startWord);
        while (!queue.isEmpty()) {
            String curWord = queue.peek().word;
            int curSeqLength = queue.peek().seqLength;
            queue.poll();
            int n = curWord.length();
            for (int i = 0; i < n; i++) {
                for (char ch = 'a'; ch <= 'z'; ch++) {
                    char[] chars = curWord.toCharArray();
                    chars[i] = ch;
                    String replacedString = new String(chars);
                    if (set.contains(replacedString) && !visitedWords.contains(replacedString)) {
                        int replacedSeqLength = curSeqLength + 1;
                        visitedWords.add(replacedString);
                        queue.add(new Pair6(replacedString, replacedSeqLength));
                        if (targetWord.equals(replacedString)) {
                            return replacedSeqLength;
                        }
                    }
                }
            }
        }
        return 0;
    }
}
class Pair6 {
    String word;
    int seqLength;

    public Pair6(String word, int seqLength) {
        this.word = word;
        this.seqLength = seqLength;
    }
}
