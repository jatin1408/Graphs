import java.util.*;

public class PossiblePaths
{

    static class Graph
    {
        private int V;

        private LinkedList<Integer>[] adj;
        private boolean[] visited;


        Graph(int V) {
            this.V = V;
            adj = new LinkedList[V];
            visited=new boolean[V];
            for(int i=0;i<V;i++){
                adj[i]=new LinkedList<>();
                visited[i]=false;
            }

        }

        void addEdge(int v, int w)
        {
            adj[v].add(w);
        }
        void reset(){
            for(int i=0;i<V;i++){
                visited[i]=false;
            }
        }

        void all(int k,int t){
            ArrayList<Integer> arrayList=new ArrayList<>();
            Iterator<Integer> iterator=adj[k].listIterator();
            reset();
            visited[k]=true;
            int count=0;
            while (iterator.hasNext()){
                int n=iterator.next();
                if(visited[n]==false){
                    arrayList.add(n);
                    visited[n]=true;
                    Iterator<Integer> iterator1=adj[n].listIterator();
                    while (iterator1.hasNext()){
                        n=iterator1.next();
                        if(visited[n]==false){
                            arrayList.add(n);
                            visited[n]=true;
                        }
                    }
                }
            }

            for(Integer obj:arrayList){
                reset();
                if(DFS(obj,t)){
                    count++;
                }
            }
            System.out.println(count);
        }
        boolean DFS(int s,int k)
        {

            Stack<Integer> stack = new Stack<>();
            stack.push(s);

            while(stack.empty() == false)
            {
                s = stack.peek();
                stack.pop();

                if(visited[s] == false)
                {

                    visited[s]=true;
                }
                if(s==k){
                    return true;
                }
                Iterator<Integer> itr = adj[s].iterator();

                while (itr.hasNext())
                {
                    int v = itr.next();
                    if(!visited[v])
                        stack.push(v);
                }

            }
            return false;
        }
    }


    public static void main(String[] args)
    {

        Graph g = new Graph(5);
        g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 4);
        g.addEdge(1, 3);
        g.addEdge(1, 4);
        g.addEdge(2, 4);
        g.addEdge(3,2);
       /* g.addEdge(0, 1);
        g.addEdge(0, 2);
        g.addEdge(0, 3);
        g.addEdge(2, 0);
        g.addEdge(2, 1);
        g.addEdge(1, 3);*/
        g.all(0,4);
    }
}
