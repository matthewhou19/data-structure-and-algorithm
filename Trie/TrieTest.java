import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class TrieTest {
    @Test
    public void ArrayTireTest() {
        Trie t = new ArrayTire();
        testEmpty(t);
        testSample(t);
    }

    @Test
    public void MapTrieTest() {
        Trie t = new MapTrie();
        testEmpty(t);
        testSample(t);
    }


    public void testEmpty(Trie t) {
        t.insert("");
        assertEquals(false, t.search("abc"));
        assertEquals(true, t.search(""));
        assertEquals(false, t.search(" "));
        assertEquals(false, t.startsWith("abc"));
        assertEquals(true, t.startsWith(""));
        assertEquals(false, t.startsWith(" "));
        assertEquals("", t.longestPrefixOf(""));
        assertEquals("", t.longestPrefixOf("abc"));
        List<String> words = t.keysWithPrefix("");
        assertEquals(1, words.size());
        assertEquals("", words.get(0));
        words = t.keysWithPrefix("abc");
        assertEquals(0, words.size());
    }

    public void testSample(Trie t) {
        t.insert("am");
        t.insert("bad");
        t.insert("bed");
        t.insert("so");
        assertEquals(true, t.search("am"));
        assertEquals(true, t.search("bad"));
        assertEquals(true, t.search("bed"));
        assertEquals(true, t.search("so"));
        assertEquals(false, t.search("a"));
        assertEquals(false, t.search("be"));
        assertEquals(true,t.startsWith("b"));
        assertEquals(true, t.startsWith("ba"));
        assertEquals(true, t.startsWith("s"));
        assertEquals(false,t.startsWith("act"));
        assertEquals("a", t.longestPrefixOf("apple"));
        assertEquals("bed",t.longestPrefixOf("bedroom"));
        t.insert("a");
        t.insert("be");
        List<String> list = t.keysWithPrefix("a");
        assertEquals(2, list.size());
        assertEquals("a", list.get(0));
        assertEquals("am", list.get(1));
        list = t.keysWithPrefix("b");
        assertEquals(3, list.size());

    }

}
