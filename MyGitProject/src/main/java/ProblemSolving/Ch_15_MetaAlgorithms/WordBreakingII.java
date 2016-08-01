package ProblemSolving.Ch_15_MetaAlgorithms;

import java.util.*;

public class WordBreakingII {
    public static List<String> wordBreakIterative(String s, Set<String> dict) {
        boolean[][] isWord = new boolean[s.length()][s.length()];
        boolean[] possible = new boolean[s.length() + 1];
        possible[s.length()] = true;

        ArrayList<String> result = new ArrayList<>();
        List<Integer> path = new ArrayList<>();

        if (s.length() == 0) {
            return result;
        }

        /*
         * Try every possible combination using a 2 X 2 grid and update the grid cells.
         */
        for (int i = 0; i < s.length(); i++) {
            for (int j = i; j < s.length(); j++) {
                String word = s.substring(i, j +1);
                isWord[i][j] = dict.contains(word);
            }
        }

        printGrid(isWord);

        /*
         * Create a vector which has the beginning of the indices in the given length
         * where the word could be formed.
         */
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (isWord[i][j] && possible[j + 1]) {
                    possible[i] = true;
                    break;
                }
            }
        }
        printArray(possible);

        search(0, s, path, isWord, possible, result);
        return result;
    }

    private static void search(int index, String s, List<Integer> path, boolean[][] isWord, boolean[] possible,
                               ArrayList<String> result) {
        /*
         * Since the legal word could not be found using the given index, we'll not proceed with the search.
         */
        if (!possible[index]) {
            return;
        }

        /*
         * If a legit sentence could be formed with the given length of index, we'll create it and add it to the results.
         */
        if (createStringWithSpaces(index, s, path, result))
            return;

        /*
         * Not yet ready to add the sentence to the results, hence continuing the search with the next index.
         */
        for (int i = index; i < s.length(); i++) {
            if (!isWord[index][i]) {
                continue;
            }
            path.add(i + 1);
            search(i + 1, s, path, isWord, possible, result);
            path.remove(path.size() - 1);
        }
    }

    private static boolean createStringWithSpaces(int index, String s, List<Integer> path, ArrayList<String> result) {
        if (index == s.length()) {
            StringBuilder sb = new StringBuilder();
            int lastIndex = 0;
            for (int i = 0; i < path.size(); i++) {
                Integer currentIndex = path.get(i);
                sb.append(s.substring(lastIndex, currentIndex));
                if (i != path.size() - 1) {
                    sb.append(" ");
                }
                lastIndex = currentIndex;
            }
            result.add(sb.toString());
            return true;
        }
        return false;
    }

    private static void printGrid(boolean[][] isWord) {
        for(int i = 0 ; i < isWord.length*2 ; i++)
            System.out.print("-");
            System.out.println();
        for (int i = 0; i < isWord.length; i++) {
            for (int j = 0; j < isWord.length; j++) {
                System.out.print(isWord[i][j] ? "T " : "F ");
            }
            System.out.println();
        }
        for(int i = 0 ; i < isWord.length*2 ; i++)
            System.out.print("-");
    }

    private static void printArray(boolean[] isPossible) {
        System.out.print("\n\n");
        for (int i = 0; i < isPossible.length; i++) {
            System.out.print(isPossible[i] ? "T " : "F ");
        }
    }

    public static void main(String... args) {
        Set<String> dictionary = new HashSet<>();

        //Test-word-1
        dictionary.add("cats");
        dictionary.add("cat");
        dictionary.add("dog");
        dictionary.add("sand");
        dictionary.add("and");

        //Test-word-2
        dictionary.add("i");
        dictionary.add("like");
        dictionary.add("icecream");
        dictionary.add("ice");
        dictionary.add("cream");

        //Test-word-3
        dictionary.add("a");
        dictionary.add("aa");
        dictionary.add("aaa");
        dictionary.add("aaaa");
        dictionary.add("aaaaaaaaaa");

        //Case-1
        String testString = "catsanddog";
        System.out.println("\nGiven string:: "+testString);
        List<String> actual = WordBreakingII.wordBreakIterative(testString, dictionary);
        System.out.println();
        System.out.println("\nOutcome:: "+actual);

        //Case-2
        testString = "ilikeicecream";
        System.out.println("\nGiven string:: "+testString);
        actual = WordBreakingII.wordBreakIterative(testString, dictionary);
        System.out.println();
        System.out.println("\nOutcome:: "+actual);

        //Case-3
        testString = "aaa";
        System.out.println("\nGiven string:: "+testString);
        actual = WordBreakingII.wordBreakIterative(testString, dictionary);
        System.out.println();
        System.out.println("\nOutcome:: "+actual);

        //Case-4
        testString = "like";
        System.out.println("\nGiven string:: "+testString);
        actual = WordBreakingII.wordBreakIterative(testString, dictionary);
        System.out.println();
        System.out.println("\nOutcome:: "+actual);
    }
}
