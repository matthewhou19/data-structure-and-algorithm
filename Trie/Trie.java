import java.util.List;

public interface Trie {
    public void insert(String word);
    //Returns true if the string word is in the trie (i.e., was inserted before), and false otherwise.
    public boolean search(String word);

    //Returns true if there is a previously inserted string word that has the prefix, and false otherwise.
    public boolean startsWith(String prefix);

    public String longestPrefixOf(String  word);

    public List<String> keysWithPrefix(String prefix);
}
