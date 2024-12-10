package CompNet;

public class MyNode {
    private Vertex vertex;
    private MyNode next;
    private MyNode prev;

    public MyNode(Vertex v){
        this.vertex = v;
    }

    public void setVertex(Vertex v){
        this.vertex = v;
    }
    public void setNext(MyNode n){
        this.next = n;
    }
    public void setPrev(MyNode n){
        this.prev = n;
    }
    public Vertex getVertex(){
        return this.vertex;
    }
    public MyNode getNext(){
        return this.next;
    }
    public MyNode getPrev(){
        return this.prev;
    }
}
