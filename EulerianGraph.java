import java.util.Iterator;
import java.util.LinkedList;

public class EulerianGraph {
    int v;
    LinkedList[] adj;

    public EulerianGraph(int e) {
        this.v = e;
        adj=new LinkedList[v];
        for(int i=0;i<v;i++){
            adj[i]=new LinkedList<Integer>();
        }
    }

    void dfs(int v, boolean[] visited){
        visited[v]=true;
        Iterator<Integer> iterator=adj[v].listIterator();
        while (iterator.hasNext()){
            int n=iterator.next();
            if(!visited[n]){
                dfs(n,visited);
            }
        }
    }
    boolean check_connected(){
        boolean[] visited=new boolean[v];
        int i;
        for(i=0;i<v;i++){
            visited[i]=false;
        }

        for(i=0;i<v;i++){
            if(adj[i].size()!=0){
              break;
            }
        }
        dfs(i,visited);
        for(i=0;i<v;i++){
            if(!visited[i]){
                return false;
            }
        }
        return true;
    }
    public int isEulerian(){
        if(!check_connected()){
            return 0;
        }
        int odd=0;
        for(int i=0;i<v;i++){
            if(adj[i].size()%2!=0){
                odd++;
            }

        }
        if(odd>2){
            return 0;
        }
        return (odd==2)? 1:2;
    }
    public void addEdge(int v,int u){
        adj[v].add(u);
        adj[u].add(v);
    }
    public static void main(String[] args) {
        EulerianGraph e=new EulerianGraph(5);
        e.addEdge(1, 0);
        e.addEdge(0, 2);
        e.addEdge(2, 1);
        e.addEdge(0, 3);
        e.addEdge(3, 4);
        System.out.println(e.isEulerian());

    }
}