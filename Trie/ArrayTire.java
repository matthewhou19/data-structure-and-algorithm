import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ArrayTire implements Trie{
    private TrieNode root;

    private class TrieNode{
        boolean exist;
        TrieNode[] links;

        public TrieNode() {
            exist = false;
            links = new TrieNode[26];
        }
    }



    public ArrayTire() {

    }

    @Override
    public void insert(String word) {
        if(validation(word)) {
            word = word.toLowerCase();
        }
        root = insert(0, word, root);
    }

    private TrieNode insert(int index, String word, TrieNode root) {
        if (root == null) {
            root = new TrieNode();
        }
        if (index != word.length()) {
            char c = word.charAt(index);
            root.links[getIndex(c)] = insert(index + 1, word, root.links[getIndex(c)]);

        } else {
            root.exist = true;
        }
        return root;
    }

    @Override
    public boolean search(String word) {
        if (validation(word)) {
            return search(0, word, root);
        }
        return false;
    }

    private boolean search(int index, String word, TrieNode root) {
        if (root == null) return false;
        if (index == word.length()) return root.exist;
        char c = word.charAt(index);
        return search(index + 1, word, root.links[getIndex(c)]);
    }

    @Override
    public boolean startsWith(String prefix) {
        if (validation(prefix)) {
            return startsWith(0, prefix, root);
        }
        return false;
    }

    private boolean startsWith(int index, String word, TrieNode root) {
        if (root == null) return false;
        if (index == word.length()) return true;
        char c = word.charAt(index);
        return startsWith(index + 1, word, root.links[getIndex(c)]);
    }

    @Override
    public String longestPrefixOf(String word) {
        StringBuilder st = new StringBuilder();
        return longestPrefixOf(st, 0, word, root);
    }

    private String longestPrefixOf(StringBuilder st, int index, String word, TrieNode root) {
        if (index == word.length() || root == null) {
            if (root != this.root) {
                st.deleteCharAt(st.length() - 1);
            }
            return st.toString();
        }
        char c = word.charAt(index);
        if (!validateChar(c)) {
            return st.toString();
        }
        st.append(c);
        return longestPrefixOf(st, index + 1, word, root.links[getIndex(c)]);
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
            if (cur == null) return res;
            char c = prefix.charAt(index);
            index++;
            cur = cur.links[getIndex(c)];
        }

        List<String> suffixes = new ArrayList<>();
        StringBuilder st = new StringBuilder();
        getSuffixes(cur, suffixes, st);
        for (String suffix : suffixes) {
            String word = prefix +suffix;
            res.add(word);
        }
        return res;
    }

    private void getSuffixes(TrieNode root, List<String> list, StringBuilder st) {
        if (root.exist == true) {
            list.add(st.toString());
        }

        for (int i = 0; i < 26; i++) {
            if (root.links[i] != null) {
                char c = (char) ('a' + i);
                st.append(c);
                getSuffixes(root.links[i], list, st);
                st.deleteCharAt(st.length() - 1);
            }
        }

    }

    private boolean validateChar(Character c) {
        if (c - 'a' >= 0 && 'z' - c >= 0 ) return true;
        return false;
    }


    private int getIndex(char c) {
        return c - 'a';
    }

}
