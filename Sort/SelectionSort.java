import edu.princeton.cs.algs4.Queue;

public class SelectionSort {
    public static <Item extends Comparable> void sort(Item[] items) {
        if (items == null || items.length <= 1) return;
        for (int i = 0; i < items.length; i++) {
            int minIndex = i;
            for (int j = i + 1; j < items.length; j++) {
                if (items[j].compareTo(items[minIndex]) < 0) {
                    minIndex = j;
                }
            }
            swap(i, minIndex, items);
        }
    }

    private static <Item extends Comparable> void swap(int i, int j, Item[] items){
        if (i  == j) return;
        Item cur = items[i];
        items[i] = items[j];
        items[j] = cur;
    }


    public static void main(String[] args) {
        String[] letters = new String[]{"xxbc", "ffg", "mmc", "bbc", "aab", "ddc", "ppo", "llg", "eec", "ccac", "iic"};

        printArray(letters);
        SelectionSort.sort(letters);
        printArray(letters);
    }
    private static void printArray(Object[] objects) {
        for (Object o : objects) {
            System.out.print(o);
            System.out.print("||");
        }
        System.out.println();
    }

}
