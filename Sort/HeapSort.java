public class HeapSort {
    public static <Item extends Comparable> void sort(Item[] items) {
        heapify(items);
        int nextlarge = items.length - 1;
        int size = items.length;
        while (nextlarge > 0) {
            Item temp = items[nextlarge];
            items[nextlarge] = items[0];
            items[0] = temp;

            size--;
            sink(0, items, size);
            nextlarge--;

        }

    }

    private static  <Item extends Comparable> void heapify(Item[] items) {
        for (int i = items.length - 1; i > -1; i--) {
            sink(i, items, items.length);
        }
    }

    private static <Item extends Comparable> void sink(int i,Item[] items, int size) {
        int left = 2 * i + 1;
        int rihgt = 2 * i + 2;
        int largest = i;
        if (left < size && items[left].compareTo(items[largest]) > 0) {
            largest = left;
        }
        if (rihgt < size && items[rihgt].compareTo(items[largest]) > 0) {
            largest = rihgt;
        }

        if (largest != i) {
            Item temp = items[largest];
            items[largest] = items[i];
            items[i] = temp;
            sink(largest, items, size);
        }
    }


    public static void main(String[] args) {
        Integer[] nums = generateIntArray();
        heapify(nums);
        printArray(nums);
        sort(nums);
        printArray(nums);
    }


    private static void printArray(Object[] objects) {
        for (Object o : objects) {
            System.out.print(o);
            System.out.print("||");
        }
        System.out.println();
    }

    private String[] generateStringArray(){
        return new String[]{"xxbc", "ffg", "mmc", "bbc", "aab", "ddc", "ppo", "llg", "eec", "ccac", "iic"};
    }

    private static Integer[] generateIntArray(){
        return new Integer[]{1, 2 , 3 , 4 , 5 , 6, 7, 8, 9};
    }

}
