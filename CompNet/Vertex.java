package CompNet;

public class Vertex {
    private String nama;
    private String IP;
    private String jenis;
    private Vertex next;
    private Edge edge;
    private int minJarak = 999;
    private boolean visited;
    private Vertex prev;

    public Vertex(String nama, String IP, String jenis){
        this.nama = nama;
        this.IP = IP;
        this.jenis = jenis;
        this.next = null;
        this.edge = null;
    }

    public String getIP() {
        return IP;
    }

    public String getJenis() {
        return jenis;
    }

    public Vertex getNext() {
        return next;
    }
    public String getNama() {
        return nama;
    }

    public void setNama(String n){
        this.nama = n;
    }

    public void setIP(String ip){
        this.IP = ip;
    }

    public void setJenis(String jns){
        this.jenis = jns;
    }

    public void setNext(Vertex next) {
        this.next = next;
    }

    public Edge getEdge() {
        return edge;
    }

    public void setEdge(Edge edge) {
        this.edge = edge;
    }
    public int getMinJarak(){
        return this.minJarak;
    }
    public void setMinJarak(int j){
        this.minJarak = j;
    }

    public void setVisited(boolean v){
        this.visited = v;
    }
    public boolean getVisited(){
        return this.visited;
    }
    public void setPrev(Vertex v){
        this.prev = v;
    }
    public Vertex getPrev(){
        return this.prev;
    }
}
