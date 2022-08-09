


public class BubbleSort {
   public static <Item extends Comparable> void sort(Item[] items) {
       boolean hasSwap = true;
       while (hasSwap) {
           hasSwap = false;
           for (int i = 0; i < items.length - 1; i++) {
               if (items[i].compareTo(items[i + 1]) > 0) {
                   Item temp = items[i];
                   items[i] = items[i + 1];
                   items[i + 1] = temp;
                   hasSwap = true;
               }
           }
       }
   }
}
