import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

class Scratch {
    private int v;
    private LinkedList<Integer> linkedList[];
    private boolean[] visited;
    public Scratch(int v) {
        this.v = v;
        linkedList=new LinkedList[v];
        visited=new boolean[v];
        for(int i=0;i<v;i++){
            linkedList[i]=new LinkedList<>();
            visited[i]=false;
        }


    }
    public void addEdge(int v,int u){
        linkedList[v].add(u);
    }
    public void Bfs(int v,int k){
        int level=0;
        int u=linkedList[0].size();
        int count=u-1;
        LinkedList<Integer> queue=new LinkedList<>();
        visited[v]=true;
        queue.add(v);

        int prev=u;
        while (queue.size()!=0){

            v=queue.poll();

            Iterator<Integer> iterator=linkedList[v].listIterator();
            while (iterator.hasNext()){

                v=iterator.next();
                if(visited[v]==false){
                    visited[v]=true;
                    queue.add(v);
                }
            }
            count++;
            if(count==prev){
                int s=queue.size();
                level++;
               
                prev=s;
                count=0;
                if(level==k){
                    System.out.println(s);
                    break;
                }

            }


        }
    }

    public static void main(String[] args) {
        Scratch bfs=new Scratch(8);

        bfs.addEdge(0, 1);
        bfs.addEdge(0, 2);
        bfs.addEdge(0,3);
        bfs.addEdge(1, 4);
        bfs.addEdge(1, 5);
        bfs.addEdge(1, 6);
        bfs.addEdge(2, 7);
        bfs.Bfs(0,2);
    }
}