public interface MinPQ<Item extends Comparable<Item>> {
    public void add(Item x);
    public Item getSmallest();
    public Item removeSmallest();
    public int size();
}
