import java.util.*;
public class KruskalMST {
    int v;
    LinkedList[] adj;
    ArrayList<Edge> arrayList;
    private Map<Integer,Node> map=new HashMap<>();
    static class Edge{
        int src;
        int des;
        int w;

        public Edge(int src, int des, int w) {
            this.src = src;
            this.des = des;
            this.w = w;
        }
    }
    static class Node{
        Node parent;
        int data;
        int rank;
        public Node(int data) {
            this.data = data;
            this.rank=0;
        }
    }

    public KruskalMST(int v) {
      this.v=v;
      adj=new LinkedList[v];
      for(int i=0;i<v;i++){
          adj[i]=new LinkedList();
      }
      arrayList=new ArrayList<>();
    }

    void addEdge(int v,int u,int w){
        adj[v].add(u);
        Edge edge=new Edge(v,u,w);
        arrayList.add(edge);
    }
    void sort(){
        class MyComprator implements Comparator<Edge>{
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.w-o2.w;
            }
        }
        arrayList.sort(new MyComprator());
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
    ArrayList<Edge> mst(){
        sort();
        make_all();
        ArrayList<Edge> res=new ArrayList<>();
        for(Edge obj:arrayList){
            Node e1=findSet(map.get(obj.src));
            Node e2=findSet(map.get(obj.des));
            if(e1!=e2){
                union(obj.src,obj.des);
                res.add(obj);
            }
        }
        return res;
    }

    public static void main(String[] args) {
        KruskalMST s=new KruskalMST(6);
        s.addEdge(0,1,10);
        s.addEdge(0,2,6);
        s.addEdge(0,3,5);
        s.addEdge(2,3,4);
        s.addEdge(1,3,15);
        ArrayList<Edge> arrayList=s.mst();
        for(Edge obj:arrayList){
            System.out.println("Source: "+obj.src+" destination: "+obj.des+" weight: "+obj.w);
        }

    }
}