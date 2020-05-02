import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Set;

public class CycleInDirectedGraph  {
    int v;
    LinkedList[] adj;

    public CycleInDirectedGraph(int v) {
        this.v=v;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList();
        }

    }
    public boolean hasCycle(){
        Set<Integer> whiteSet=new HashSet<>();
        Set<Integer> blackSet=new HashSet<>();
        Set<Integer> graySet=new HashSet<>();
        for(int i=0;i<adj.length;i++){
            Iterator<Integer> iterator=adj[i].listIterator();
            while (iterator.hasNext()){
                whiteSet.add(iterator.next());
            }
        }
        while (whiteSet.size()>0){
            int current=whiteSet.iterator().next();
            if(dfs(current,blackSet,graySet,whiteSet)){
                return true;
            }
        }
        return false;
    }
    public boolean dfs(int current,Set<Integer> blackSet,Set<Integer> graySet,Set<Integer> whiteSet){
        moveVertex(current,whiteSet,graySet);
        Iterator<Integer> iterator=adj[current].listIterator();
        while(iterator.hasNext()){
            int n=iterator.next();
            if(blackSet.contains(n)){
                continue;
            }
            if(graySet.contains(n)){
                return true;
            }
            if(dfs(n, blackSet, graySet, whiteSet)){
                return true;
            }
        }
        moveVertex(current, graySet, blackSet);
        return false;
    }
    public void moveVertex(int current,Set<Integer> source,Set<Integer> destination){
        source.remove(current);
        destination.add(current);
    }
    public void addEdge(int v,int u){
        adj[v].add(u);
    }
    public static void main(String[] args) {
        CycleInDirectedGraph graph=new CycleInDirectedGraph(2);
        graph.addEdge(1, 0);
        graph.addEdge(0, 1);
        //graph.addEdge(3, 2);
        //graph.addEdge(2, 0);
        //graph.addEdge(2, 3);
        //graph.addEdge(3, 3);
        System.out.println(graph.hasCycle());



        
    }
}