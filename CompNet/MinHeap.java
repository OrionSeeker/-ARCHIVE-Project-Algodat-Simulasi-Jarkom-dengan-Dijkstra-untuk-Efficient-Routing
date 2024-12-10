package CompNet;

public class MinHeap {
    private NodeHeap root = null;
    private int size = 0;

    public NodeHeap getLast(NodeHeap startV){
        NodeHeap curr = startV;
        while(curr.getNext()!=null){
            curr = curr.getNext();
        }
        return curr;
    }
    public void add(Vertex v){
        NodeHeap n = new NodeHeap(v);
        size++;
        if(root==null){
            root = n;
        }
        else{
            NodeHeap last = getLast(root);
            last.setNext(n);
            heapifyUp(n);
        }
    }

    public void removeLast(NodeHeap startV){
        NodeHeap curr = startV;
        while(curr.getNext().getNext()!=null){
            curr = curr.getNext();
        }
        curr.setNext(null);
    }

    public Vertex getMin(){
        if(size==0){
            return null;
        }
        Vertex min = root.getVertex();
        size--;

        if(size>0){
            NodeHeap last = getLast(root);
            root.setVertex(last.getVertex());
            removeLast(root);
            heapifyDown(root);
        }
        else{
            root = null;
        }
        return min;
    }

    public NodeHeap getParent(NodeHeap root, NodeHeap n){
        if(n == root || root == null || n == null){
            return null;
        }
        NodeHeap parent = root;
        while(parent!=null && parent.getNext()!=n){
            parent = parent.getNext();
        }
        return parent;
    }

    public void swap(NodeHeap n1, NodeHeap n2){
        Vertex tmp = n1.getVertex();
        n1.setVertex(n2.getVertex());
        n2.setVertex(tmp);
    }

    public void heapifyUp(NodeHeap n){
        while(n!=root){
            NodeHeap parent = getParent(root, n);
            if(n.getVertex().getMinJarak() >= parent.getVertex().getMinJarak()){
                break;
            }
            swap(n, parent);
            n = parent;
        }
    }

    public void heapifyDown(NodeHeap n){
        while(n!=null){
            NodeHeap min = n;
            NodeHeap leftChild = n.getNext();
            NodeHeap rightChild;
            if(leftChild !=null){
                rightChild = leftChild.getNext();
            }
            else{
                rightChild = null;
            }

            if(leftChild!=null && leftChild.getVertex().getMinJarak() < min.getVertex().getMinJarak()){
                min = leftChild;
            }
            if(rightChild!=null && rightChild.getVertex().getMinJarak() < min.getVertex().getMinJarak()){
                min = rightChild;
            }
            if(min!=n){
                swap(n,min);
                n = min;
            }
            else{
                break;
            }
        }
    }

    public int getSize(){
        return this.size;
    }
}
