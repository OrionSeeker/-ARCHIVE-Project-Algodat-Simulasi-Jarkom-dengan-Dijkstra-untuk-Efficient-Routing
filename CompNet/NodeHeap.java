package CompNet;
public class NodeHeap {
    private Vertex vertex;
    private NodeHeap next;

    public NodeHeap(Vertex vertex) {
        this.vertex = vertex;
        this.next = null;
    }
    public Vertex getVertex() {
        return vertex;
    }
    public void setVertex(Vertex vertex) {
        this.vertex = vertex;
    }
    public NodeHeap getNext() {
        return next;
    }
    public void setNext(NodeHeap next) {
        this.next = next;
    }
}