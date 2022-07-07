import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class DFSPaths<K>{
    private Set<K> marked;
    private Map<K, K> edgeTo;
    private K head;

    public DFSPaths(Graph<K> graph, K head) {
        if (head == null) {
            throw new  IllegalArgumentException("path head can not be null");
        }
        this.head = head;
        marked = new HashSet<>();
        edgeTo = new HashMap<>();
        dfs(graph, head);
    }

    private void dfs(Graph<K> graph, K head) {
        marked.add(head);
        for (K child : graph.adj(head)) {
            if (!marked.contains(child)) {
                edgeTo.put(head, child);
                dfs(graph,child);
            }
        }
    }

    boolean hasPathTo(K s){
        return marked.contains(s);
    }

}
