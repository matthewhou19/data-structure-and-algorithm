public class InsertionSort {
    public static <Item extends Comparable> void sort(Item[] items) {
        if (items == null || items.length <= 1) return;
        for (int i = 0; i < items.length; i++) {
            int curIndex = i;
            while (curIndex > 0 && items[curIndex].compareTo(items[curIndex - 1]) < 0) {
                Item temp = items[curIndex];
                items[curIndex] = items[curIndex - 1];
                items[curIndex - 1] = temp;
                curIndex--;
            }
        }

    }
}
