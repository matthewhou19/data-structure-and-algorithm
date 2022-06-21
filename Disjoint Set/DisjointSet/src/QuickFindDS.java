public class QuickFindDS implements DisjointSets{
    private int[] id;

    public QuickFindDS(int n) {
        id = new int[n];
        for (int i = 0; i < n; i++) {
            id[i] = i;
        }
    }


    @Override
    public boolean isConnected(int p, int q) {
        return id[p] == id[q];
    }

    @Override
    public void connect(int p, int q) {
        int pid = id[p];
        int qid = id[q];
        for (int i = 0; i < id.length; i++) {
            if (id[i] == pid) {
                id[i] = qid;
            }
        }
    }
}
