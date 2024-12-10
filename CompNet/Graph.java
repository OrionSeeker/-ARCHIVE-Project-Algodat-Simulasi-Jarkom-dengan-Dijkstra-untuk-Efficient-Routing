package CompNet;

public class Graph {
    private Vertex head;

    public void addVertex(String nama, String IP, String jenis) {
        Vertex newVertex = new Vertex(nama, IP, jenis);
        newVertex.setNext(head);
        head = newVertex;
    }

    public void addEdge(String source, String destination, int jarak) {
        Vertex sourceVertex = getVertexbyNama(source);
        Vertex destinationVertex = getVertexbyNama(destination);

        if (sourceVertex == null || destinationVertex == null) {
            return;
        }

        Edge newEdge = new Edge(destinationVertex, jarak);
        newEdge.setNextEdge(sourceVertex.getEdge());
        sourceVertex.setEdge(newEdge);

        Edge newEdge2 = new Edge(sourceVertex, jarak);
        newEdge2.setNextEdge(destinationVertex.getEdge());
        destinationVertex.setEdge(newEdge2);
    }

    private Vertex getVertexbyNama(String nama) {
        Vertex current = head;
        while (current != null) {
            if (current.getNama().equals(nama)) {
                return current;
            }
            current = current.getNext();
        }
        return null;
    }

    public Vertex getVertexbyIP(String IP){
        Vertex curr = head;
        while(curr!=null){
            if(curr.getIP().equals(IP)){
                return curr;
            }
            curr = curr.getNext();
        }
        return null;
    }

    public void dijkstra(String start, String jenis){
        if(getVertexbyNama(start) == null && jenis.equals("nama")){
            return;
        }
        if(getVertexbyIP(start) == null && jenis.equals("IP")){
            return;
        }
        MinHeap unvisited = new MinHeap();
        Vertex startV;
        if(jenis.equals("nama")){
            startV = getVertexbyNama(start);
        }
        else{
            startV = getVertexbyIP(start);
        }
        startV.setMinJarak(0);
        unvisited.add(startV);

        while(unvisited.getSize()!=0){
            Vertex curr = unvisited.getMin();
            curr.setVisited(true);
            Edge adjEdge = curr.getEdge();
            while(adjEdge!=null){
                Vertex adjVertex = adjEdge.getDestination();
                if(!adjVertex.getVisited()){
                    int newJar = curr.getMinJarak() + adjEdge.getJarak();
                    if(newJar < adjVertex.getMinJarak()){
                        adjVertex.setMinJarak(newJar);
                        adjVertex.setPrev(curr);
                        unvisited.add(adjVertex);
                    }
                }
                adjEdge = adjEdge.getNextEdge();
            }
        }
    }

    public void printPath(Vertex v){
        if(v.getPrev()!=null){
            printPath(v.getPrev());
            System.out.print("->");
        }
        System.out.print(v.getNama());
    }
    public void printDijkstraPath(String end, String jenis){
        Vertex endV;
        if(jenis.equals("nama")){
            endV = getVertexbyNama(end);
        }
        else{
            endV = getVertexbyIP(end);
        }
        if(endV == null || endV.getMinJarak() == 999){
            System.out.println("Tidak ada rute routing yang dapat digunakan");
            return;
        }
        System.out.println("Rute routing: ");
        printPath(endV);
        System.out.println(" | Total jarak: " + endV.getMinJarak());
        System.out.println("Ping BERHASIL!!");
    }

    public void resetDijkstra(){
        Vertex curr = head;
        while(curr!=null){
            curr.setMinJarak(999);
            curr.setPrev(null);
            curr.setVisited(false);
            curr = curr.getNext();
        }
    }
    public void routingbyNama(String start, String end){
        dijkstra(start, "nama");
        printDijkstraPath(end, "nama");
        resetDijkstra();
    }
    public void routingbyIP(String start, String end){
        dijkstra(start, "IP");
        printDijkstraPath(end, "IP");
        resetDijkstra();
    }

    public void dfs(String start) {
        Vertex startV = getVertexbyNama(start);
        if (startV == null) {
            return;
        }
        resetVisited();
        LinkedList list = new LinkedList();
        dfsSearch(startV, list);
        list.selectionSort();
        list.printAll();
        resetVisited();
    }

    private void dfsSearch(Vertex vertex, LinkedList list) {
        if (vertex == null) {
            return;
        }
        list.addLast(vertex);
        vertex.setVisited(true);
        Edge edge = vertex.getEdge();
        while (edge != null) {
            Vertex adjVertex = edge.getDestination();
            if (!adjVertex.getVisited()) {
                dfsSearch(adjVertex, list);
            }
            edge = edge.getNextEdge();
        }
    }

    private void resetVisited() {
        Vertex current = head;
        while (current != null) {
            current.setVisited(false);
            current = current.getNext();
        }
    }

    public boolean cekDuplikatNama(String nm){
        if(getVertexbyNama(nm)!=null){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean cekDuplikatIP(String ip){
        if(getVertexbyIP(ip)!=null){
            return true;
        }
        else{
            return false;
        }
    }

    public boolean cekDuplikatEdge(String start, String end){
        Vertex startV = getVertexbyNama(start);
        Vertex endV = getVertexbyNama(end);
        if(startV == null || endV == null){
            return false;
        }
        Edge cekEdge = startV.getEdge();
        while(cekEdge!=null){
            if(cekEdge.getDestination().getNama().equals(end)){
                return true;
            }
            cekEdge = cekEdge.getNextEdge();
        }
        return false;
    }
}
