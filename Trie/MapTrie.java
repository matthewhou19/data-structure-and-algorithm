import edu.princeton.cs.algs4.ST;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapTrie implements Trie{
    private class TrieNode {
        boolean exist;
        Map<Character, TrieNode> map;

        public TrieNode() {
            exist = false;
            map = new HashMap<>();
        }
    }
    private TrieNode root;

    public MapTrie() {
        root = new TrieNode();
    }

    @Override
    public void insert(String word) {
        if (validation(word)) {
            insert(0, word, root);
        }
    }

    private void insert(int index, String word, TrieNode node) {
        if (index == word.length()) {
            node.exist = true;
        } else {
            char c = word.charAt(index);
            if (node.map.containsKey(c)) {
                insert(index + 1, word, node.map.get(c));
            } else {
                node.map.put(c, new TrieNode());
                insert(index + 1, word, node.map.get(c));
            }
        }
    }

    @Override
    public boolean search(String word) {
        if (validation(word)) {
            return search(0, word, root);
        }
        return false;
    }

    private boolean search(int index, String word, TrieNode root) {
        if (index == word.length()) {
            return root.exist;
        }
        char c = word.charAt(index);
        if (!root.map.containsKey(c)) {
            return false;
        } else {
            return search(index + 1, word, root.map.get(c));
        }
    }

    @Override
    public boolean startsWith(String prefix) {
        if (validation(prefix)) {
            return startsWith(0, prefix, root);
        }
        return false;
    }

    private boolean startsWith(int index, String prefix, TrieNode node) {
        if (index == prefix.length()) {
            return true;
        }
        char c = prefix.charAt(index);
        if (!node.map.containsKey(c)) {
            return false;
        } else {
            return startsWith(index + 1, prefix, node.map.get(c));
        }
    }

    @Override
    public String longestPrefixOf(String word) {
        StringBuilder st = new StringBuilder();
        return longestPrefixOf(st, 0, word, root);
    }

    private String longestPrefixOf(StringBuilder st, int index, String word, TrieNode root) {
        if (index == word.length()) {
            return st.toString();
        }
        char c = word.charAt(index);
        if (!root.map.containsKey(c)) {
            return st.toString();
        } else {
            st.append(c);
            return longestPrefixOf(st, index + 1, word, root.map.get(c));
        }
    }

    @Override
    public List<String> keysWithPrefix(String prefix) {
        List<String> res = new ArrayList<String>();
        if (!validation(prefix)) {
            return res;
        }

        TrieNode cur = root;
        int index = 0;

        while (index < prefix.length()) {
            char c = prefix.charAt(index);
            if (!cur.map.containsKey(c)) {
                return res;
            } else {
                index++;
                cur = root.map.get(c);
            }
        }

        List<String> suffixes = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        getSuffixes(cur, suffixes, st);

        for (String suffix : suffixes) {
            String word = prefix + suffix;
            res.add(word);
        }
        return res;
    }

    private void getSuffixes(TrieNode node, List<String> list, StringBuilder st) {
        if (node.exist == true) {
            list.add(st.toString());
        }
        for (char c : node.map.keySet()) {
            st.append(c);
            getSuffixes(node.map.get(c), list, st);
            st.deleteCharAt(st.length() - 1);
        }

    }
}
