public class WeightedQuickUnionDSWithPathCompression implements DisjointSets{
    int[] partents;
    int[] size;

    public WeightedQuickUnionDSWithPathCompression(int n) {
        partents = new int[n];
        for (int i = 0; i < n; i++) {
            partents[i] = i;
        }
        size = new int[n];
        for (int i = 0; i < n; i++) {
            size[i] = 1;
        }
    }
    @Override
    public boolean isConnected(int p, int q) {
        return findParent(p) == findParent(q);
    }

    @Override
    public void connect(int p, int q) {
        int i = findParent(p);
        int j = findParent(q);
        if (i == j) return;
        if (size[i] >= size[j]) {
            size[i] = size[j] + size[i];
            partents[j] = i;
        } else {
            size[j] = size[j] + size[i];
            partents[i] = j;
        }
    }

    private int  findParent(int p) {
        if (p == partents[p]) return p;
        partents[p] = findParent(partents[p]);

        return partents[p];
    }


}
