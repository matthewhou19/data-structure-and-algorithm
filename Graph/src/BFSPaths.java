import java.util.*;

public class BFSPaths<K> {
    private Set<K> marked;
    private Map<K, K> edgeTo;
    private K head;

    public BFSPaths(Graph<K> graph, K head) {
        if (head == null) {
            throw new IllegalArgumentException("path head can not be null");
        }
        this.head = head;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();

        Queue<K> q = new ArrayDeque<>();
        marked.add(head);
        q.add(head);
        while (!q.isEmpty()) {
            K cur = q.poll();
            for (K child : graph.adj(cur)) {
                if (!marked.contains(child)) {
                    marked.add(child);
                    edgeTo.put(cur, child);
                    q.add(child);
                }
            }
        }
    }

}
