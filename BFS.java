import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class BFS {
    private int v;
    private LinkedList<Integer> adj[];
    public BFS(int vertex) {
        v=vertex;
        adj=new LinkedList[v];
        for(int i=0;i<vertex;i++){
            adj[i]=new LinkedList<>();
        }

    }

    public static void main(String[] args) {
        BFS bfs=new BFS(4);

        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(1, 2);
        bfs.addEdge(2, 0);
        bfs.addEdge(2, 3);
        bfs.addEdge(3, 3);
        bfs.bfs(0);
        System.out.println();
        System.out.println("Following is the representation of dfs: ");
        bfs.dfsIterative(2);
    }
     void addEdge(int v,int e){
        adj[v].add(e);
    }
    void bfs(int s){
        boolean[] visited=new boolean[v];
        LinkedList<Integer> queue=new LinkedList<>();
        visited[s]=true;
        queue.add(s);
        while (queue.size()!=0){
            s=queue.poll();
            System.out.print(s+" ");
            Iterator<Integer> i=adj[s].listIterator();
            while (i.hasNext()){
                int n=i.next();
                if(!visited[n]){
                    visited[n]=true;
                    queue.add(n);
                }
            }
        }

    }
    void dfsUtil(int s,boolean[] visited){
        visited[s]=true;
        System.out.print(s+" ");
        Iterator<Integer> iterator=adj[s].iterator();

        while (iterator.hasNext()){
            int n=iterator.next();
            if(!visited[n]){
                dfsUtil(n,visited);

            }
        }
    }
    void dfs(int s){
        boolean[] visited=new boolean[v];
        dfsUtil(s,visited);
    }
    void dfsIterative(int s){
        boolean[] visited=new boolean[v];
        for(int i=0;i<v;i++){
            visited[i]=false;
        }
        Stack<Integer> stack=new Stack<>();
        stack.push(s);
        while (!stack.empty()){
            s=stack.peek();
            stack.pop();
            if(!visited[s]){
                visited[s]=true;
                System.out.print(s+" ");
            }


        Iterator<Integer> iterator=adj[s].listIterator();
        while (iterator.hasNext()){
            s=iterator.next();
            if(!visited[s]){
                stack.push(s);
            }
        }
    }

}}