import java.util.HashMap;
import java.util.Map;

public class DisjointSet {
    static class Node{
        Node parent;
        int data;
        int rank;

        public Node(int data) {
            this.data = data;
            this.rank=0;
        }
    }
    private Map<Integer,Node> map=new HashMap<>();
    void makeSet(int data){
        Node n=new Node(data);
        n.parent=n;
        map.put(data,n);
    }
    boolean union(int data1,int data2){
        Node node1=map.get(data1);
        Node node2=map.get(data2);
        Node parent1=findSet(node1);
        Node parent2=findSet(node2);
        if(parent1==parent2){
            return false;
        }
        if(parent1.rank>=parent2.rank){
            parent1.rank=(parent1.rank==parent2.rank)?parent1.rank+1:parent1.rank;
            parent2.parent=parent1;
        }
        else {

            parent1.parent=parent2;
        }
        return true;
    }
    private Node findSet(Node node){
        Node parent=node.parent;
        if(parent==node){
            return parent;
        }
        node.parent=findSet(node.parent);
        return node.parent;
    }
    void find(int data){
        if(map.get(data)!=null){
            System.out.println(findSet(map.get(data)).data);
        }
        return;
    }
    public static void main(String[] args) {
        DisjointSet ds = new DisjointSet();
        ds.makeSet(1);
        ds.makeSet(2);
        ds.makeSet(3);
        ds.makeSet(4);
        ds.makeSet(5);
        ds.makeSet(6);
        ds.makeSet(7);

        ds.union(1, 2);
        ds.union(2, 3);
        ds.union(4, 5);
        ds.union(6, 7);
        ds.union(5, 6);
        ds.union(3, 7);

        ds.find(1);
        ds.find(4);
        ds.find(3);

    }
}