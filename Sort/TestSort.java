import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;

public class TestSort {
    @Test
    public void selectionSortTest() {
        String[] words = generateStringArray();
        SelectionSort.sort(words);
        String[] ourWords = Arrays.copyOf(words, words.length);
        Arrays.sort(words);
        assertArrayEquals(ourWords, words);
    }

    @Test
    public void bubbleSortTest() {
        String[] words = generateStringArray();
        BubbleSort.sort(words);
        String[] ourWords = Arrays.copyOf(words, words.length);
        Arrays.sort(words);
        assertArrayEquals(ourWords, words);
    }


    private String[] generateStringArray(){
        return new String[]{"xxbc", "ffg", "mmc", "bbc", "aab", "ddc", "ppo", "llg", "eec", "ccac", "iic"};
    }
}
