import java.util.List;

public interface Trie {
    public void insert(String word);
    //Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    public boolean search(String word);

    //Returns true if there is a previously inserted string word that has the prefix, and false otherwise.
    public boolean startsWith(String prefix);

    public String longestPrefixOf(String  word);

    public List<String> keysWithPrefix(String prefix);

    // check if string has char not in alphabet
    default boolean validation(String str) {
        str = str.toLowerCase();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (c - 'a' < 0 || c - 'z' > 0) {
                return false;
            }
        }
        return true;
    }
}


