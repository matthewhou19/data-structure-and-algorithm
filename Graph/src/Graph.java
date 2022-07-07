public interface Graph<K> {

    public void addEdge(K v, K w); //add an edge v-w
    Iterable<K> adj(K v);      //vertices adjacent to v
    int vertics();                           //number of vertices
    int edges();// number of edges



}
