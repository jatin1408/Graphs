import java.util.Iterator;
import java.util.LinkedList;
import java.util.Stack;

class StronglyConnected {
    int v;
    LinkedList<Integer> adj[];

    public StronglyConnected(int v) {
        this.v=v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }
        void addEdge(int v,int e){
            adj[v].add(e);

        }
        void DFSUtil(int v,boolean[] visited){
            visited[v]=true;
            System.out.print(v+" ");
            int n;
            Iterator<Integer> iterator=adj[v].listIterator();
            while (iterator.hasNext()){
                n=iterator.next();
                if(!visited[n]){
                    DFSUtil(n,visited);
                }
            }

        }
        StronglyConnected transpose(){
        StronglyConnected g=new StronglyConnected(v);
        for(int i=0;i<v;i++){
            Iterator<Integer> iterator=adj[i].listIterator();
            while (iterator.hasNext()){
                g.adj[iterator.next()].add(i);
            }

        }
            return g;
        }
        void fillOrder(int v, boolean[] visited, Stack stack){
            visited[v]=true;

            Iterator<Integer> iterator=adj[v].iterator();
            while (iterator.hasNext()){

                int n=iterator.next();
                if(!visited[n]){
                    fillOrder(n,visited,stack);
                }
            }

            stack.push(new Integer(v));

        }
        void printSSC(){
            Stack stack=new Stack();
            boolean[] visited=new boolean[v];
            for(int i=0;i<v;i++){
                visited[i]=false;
            }
            for(int i=0;i<v;i++){

                if(!visited[i]){
                    fillOrder(i,visited,stack);
                }
            }

            StronglyConnected s=transpose();
            for(int i=0;i<v;i++){
                visited[i]=false;
            }
            while (stack.empty()==false){
                int v=(int)stack.pop();
                if(visited[v]==false){
                    s.DFSUtil(v,visited);
                    System.out.println();
                }


            }
        }

    public static void main(String[] args) {
        StronglyConnected g = new StronglyConnected(5);
        g.addEdge(1, 0);
        g.addEdge(0, 2);
        g.addEdge(2, 1);
        g.addEdge(0, 3);
        g.addEdge(3, 4);

        System.out.println("Following are strongly connected components "+
                "in given graph ");
        g.printSSC();
    }
}