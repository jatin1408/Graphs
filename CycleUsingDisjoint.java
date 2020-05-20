import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
public class CycleUsingDisjoint {
    int v;
    LinkedList[] arr;
    ArrayList<Edge> edges=new ArrayList<>();
    Map<Integer,Node> map=new HashMap<>();
    public CycleUsingDisjoint(int v) {
        this.v = v;
        arr=new LinkedList[v];
        for(int i=0;i<v;i++){
            arr[i]=new LinkedList<>();
        }
    }
    static class Edge{
        int src;
        int des;
        public Edge(int src, int des) {
            this.src = src;
            this.des = des;
        }
    }
   static class  Node{
        Node parent;
        int data;
        int rank;

        public Node(int data) {
            this.data = data;
            this.rank=0;
        }
    }
    void addEdge(int v,int u){
        arr[v].add(u);
        Edge e=new Edge(v,u);
        edges.add(e);
    }
    void make_all(){
        for(int i=0;i<v;i++){
            makeSet(i);
        }
    }
    void makeSet(int data){
        Node n=new Node(data);
        n.parent=n;
        map.put(data,n);
    }
    boolean hasCycle()
    {
        for(Edge obj:edges){
            Node parent1=findSet(map.get(obj.src));
            Node parent2=findSet(map.get(obj.des));
            if(parent1==parent2){
                return true;
            }
            union(obj.src,obj.des);
        }
        return false;
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
    public static void main(String[] args) {
       CycleUsingDisjoint graph=new CycleUsingDisjoint(6);
        graph.addEdge(0, 1);
        graph.addEdge(1, 2);
        graph.addEdge(0, 3);
        graph.addEdge(3, 4);
        graph.addEdge(4, 5);
        graph.make_all();
        System.out.println(graph.hasCycle());
    }
}