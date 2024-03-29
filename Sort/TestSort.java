import static org.junit.Assert.*;
import org.junit.Test;

import java.util.Arrays;
import java.util.HashSet;

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

    @Test
    public void insertionSortTest() {
        String[] words = generateStringArray();
        InsertionSort.sort(words);
        String[] ourWords = Arrays.copyOf(words, words.length);
        Arrays.sort(words);
        assertArrayEquals(ourWords, words);
    }

    @Test
    public void HeapSortTest() {
        String[] words = generateStringArray();
        HeapSort.sort(words);
        String[] ourWords = Arrays.copyOf(words, words.length);
        Arrays.sort(words);
        assertArrayEquals(ourWords, words);
    }

    @Test
    public void CountingSortTest() {
        int[] nums = generateIntArray();
        CountingSort.sort(nums);
        int[] ourNums = Arrays.copyOf(nums, nums.length);
        Arrays.sort(nums);
        assertArrayEquals(ourNums, nums);
    }





    private String[] generateStringArray(){
        return new String[]{"xxbc", "ffg", "mmc", "bbc", "aab", "ddc", "ppo", "llg", "eec", "ccac", "iic"};
    }

    private static int[] generateIntArray(){
        return new int[]{1, 2 , 3 , 4 , 5 , 6, 7, 8, 9, 1, 2, 3, 5, 6, 8, 9, 10, 10, 9, 8};
    }
}
