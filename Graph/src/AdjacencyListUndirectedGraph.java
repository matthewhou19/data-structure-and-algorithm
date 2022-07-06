import java.util.*;

public class AdjacencyListUndirectedGraph<K> implements Graph<K>{
    Map<K, Integer> map;
    Set<K> set;

    List<List<Integer>> buckets;


    public AdjacencyListUndirectedGraph () {
        map = new HashMap<>();
        set = new HashSet<>();
        buckets = new ArrayList<>();
    }

    public void addvertex(K v) {
        if (!set.contains(v)) {
            //  buckets have the same index as the size of the set
            map.put(v, set.size());
            set.add(v);
            buckets.add(new ArrayList<Integer>());
        }
    }

    @Override
    public void addEdge(K v, K w) {
        addvertex(v);
        addvertex(w);
        int a = map.get(v);
        int b = map.get(w);
        addEdgeByIndex(a, b);
    }

    private void addEdgeByIndex(int a, int b) {
        List<Integer> list1 = buckets.get(a);
        List<Integer> list2 = buckets.get(b);
        boolean find = false;
        for (int m : list1) {
            if (m == b) {
                find = true;
            }
        }
        if (!find) {
            list1.add(b);
            list2.add(a);
        }
    }

    @Override
    public Iterable<Integer> adj(K v) {
        if (!set.contains(v)) {
            return  null;
        }
        return buckets.get(map.get(v));
    }

    @Override
    public int vertics() {
        return set.size();
    }

    @Override
    public int edges() {
        int count = 0;
        for (List<Integer> bucket: buckets) {
            count = count + bucket.size();
        }
        return count;
    }



}
