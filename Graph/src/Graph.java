public interface Graph<K> {

    public void addEdge(K v, K w); //add an edge v-w
    Iterable<Integer> adj(K v);      //vertices adjacent to v
    int vertics();                           //number of vertices
    int edges();// number of edges



}
