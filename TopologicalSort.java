
import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

public class TopologicalSort {
    private int V;
    private LinkedList<Integer> adj[];
    public TopologicalSort(int v) {
        V = v;
        adj=new LinkedList[v];
        for(int i=0;i<V;i++)
            adj[i]=new LinkedList<>();
    }
    void addEdge(int v,int u){
        adj[v].add(u);
    }
    public void topSortUtil(boolean[] visited,int e,Stack<Integer> stack){
        visited[e]=true;
        Integer temp;
        Iterator<Integer> integerIterator=adj[e].listIterator();
        while (integerIterator.hasNext()){
             temp=integerIterator.next();
            if(!visited[temp]){

                topSortUtil(visited,temp,stack);
            }

        }
        stack.push(e);
    }
    public void topSort(){
        Stack<Integer> res=new Stack<>();
        boolean[] visited=new boolean[V];
        for(int i=0;i<V;i++){
            if(!visited[i]){
                topSortUtil(visited,i,res);
            }
        }
        while (!res.isEmpty()){
            System.out.print(res.pop()+" ");
        }
;    }

    public static void main(String[] args) {
        TopologicalSort g = new TopologicalSort(6);
        g.addEdge(5, 2);
        g.addEdge(5, 0);
        g.addEdge(4, 0);
        g.addEdge(4, 1);
        g.addEdge(2, 3);
        g.addEdge(3, 1);
        g.topSort();
    }

}
