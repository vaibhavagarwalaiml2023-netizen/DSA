import java.util.*;

class Solution {

    Map<String, List<String>> parents = new HashMap<>();
    List<List<String>> ans = new ArrayList<>();

    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {

        Set<String> dict = new HashSet<>(wordList);

        if (!dict.contains(endWord))
            return ans;

        bfs(beginWord, endWord, dict);

        List<String> path = new ArrayList<>();
        path.add(endWord);

        dfs(endWord, beginWord, path);

        return ans;
    }

    private void bfs(String beginWord, String endWord, Set<String> dict) {

        Queue<String> q = new LinkedList<>();
        q.offer(beginWord);

        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        boolean found = false;

        while (!q.isEmpty() && !found) {

            int size = q.size();

            Set<String> levelVisited = new HashSet<>();

            for (int i = 0; i < size; i++) {

                String word = q.poll();

                char[] arr = word.toCharArray();

                for (int j = 0; j < arr.length; j++) {

                    char old = arr[j];

                    for (char c = 'a'; c <= 'z'; c++) {

                        arr[j] = c;

                        String next = new String(arr);

                        if (!dict.contains(next))
                            continue;

                        if (!visited.contains(next)) {

                            if (!levelVisited.contains(next)) {
                                q.offer(next);
                                levelVisited.add(next);
                            }

                            parents.computeIfAbsent(next, k -> new ArrayList<>()).add(word);

                            if (next.equals(endWord))
                                found = true;
                        }

                    }

                    arr[j] = old;
                }

            }

            visited.addAll(levelVisited);
        }

    }

    private void dfs(String word, String beginWord, List<String> path) {

        if (word.equals(beginWord)) {

            List<String> temp = new ArrayList<>(path);
            Collections.reverse(temp);
            ans.add(temp);
            return;
        }

        if (!parents.containsKey(word))
            return;

        for (String parent : parents.get(word)) {

            path.add(parent);

            dfs(parent, beginWord, path);

            path.remove(path.size() - 1);
        }

    }
}