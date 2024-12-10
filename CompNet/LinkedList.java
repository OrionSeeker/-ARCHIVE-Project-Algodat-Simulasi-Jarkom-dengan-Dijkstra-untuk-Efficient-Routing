package CompNet;

public class LinkedList {
    private MyNode head;
    private MyNode tail;
    public void addLast(Vertex v){
        MyNode n = new MyNode(v);
        if(head==null){
            head = n;
            tail = n;
        }
        else{
            tail.setNext(n);
            n.setPrev(tail);
            tail = n;
        }
    }

    public void swap(MyNode a, MyNode b){
        MyNode tmpNext = a.getNext();
        a.setNext(b.getNext());
        b.setNext(tmpNext);
        if(a.getNext() != null){
            a.getNext().setPrev(a);
        }
        if(b.getNext() != null){
            b.getNext().setPrev(b);
        }
        MyNode tmpPrev = a.getPrev();
        a.setPrev(b.getPrev());
        b.setPrev(tmpPrev);
        if(a.getPrev() != null){
            a.getPrev().setNext(a);
        }
        else{
            head = a;
        }
        if(b.getPrev() != null){
            b.getPrev().setNext(b);
        }
        else{
            head = b;
        }
    }

    public void selectionSort(){
        MyNode curr = head;
        while(curr!=null){
            MyNode min = curr;
            MyNode curr2 = curr;
            while(curr2!=null){
                if(curr2.getVertex().getNama().compareTo(min.getVertex().getNama()) < 0){
                    min = curr2;
                }
                curr2 = curr2.getNext();
            }
            swap(curr,min);
            curr = min.getNext();
        }
    }
    public void printAll(){
        MyNode curr = head;
        while(curr!=null){
            System.out.print(curr.getVertex().getNama());
            if(!curr.getVertex().getIP().equals("0")){
                System.out.print(" (" + curr.getVertex().getIP() + ")");
            }
            System.out.print(" terhubung dengan: ");
            Edge edge2 = curr.getVertex().getEdge();
            while(edge2!=null){
                System.out.print(edge2.getDestination().getNama() + "(" + edge2.getJarak() + ") ");
                edge2 = edge2.getNextEdge();
            }
            System.out.println();
            curr = curr.getNext();
        }
    }

}
