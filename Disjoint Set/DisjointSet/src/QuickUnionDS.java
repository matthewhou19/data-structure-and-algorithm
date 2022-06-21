public class QuickUnionDS implements DisjointSets{
    int[] partents;

    public QuickUnionDS(int n) {
        partents = new int[n];
        for (int i = 0; i < n; i++) {
            partents[i] = i;
        }
    }
    @Override
    public boolean isConnected(int p, int q) {
        return findParent(p) == findParent(q);
    }

    @Override
    public void connect(int p, int q) {
        int pParent = findParent(p);
        int qParent = findParent(q);
        partents[q] = pParent;
    }

    private int  findParent(int p) {
        while(partents[p] != p) {
            p = partents[p];
        }
        return p;
    }
}
