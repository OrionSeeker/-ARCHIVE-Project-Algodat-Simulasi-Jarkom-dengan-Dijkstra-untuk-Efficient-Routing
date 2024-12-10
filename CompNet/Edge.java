package CompNet;

public class Edge {
    private Vertex destination;
    private int jarak;
    private Edge nextEdge;

    public Edge(Vertex destination, int jarak) {
        this.destination = destination;
        this.jarak = jarak;
        this.nextEdge = null;
    }

    public Vertex getDestination() {
        return destination;
    }

    public Edge getNextEdge() {
        return nextEdge;
    }

    public int getJarak() {
        return jarak;
    }

    public void setNextEdge(Edge nextEdge) {
        this.nextEdge = nextEdge;
    }

}
