import java.util.Iterator;
import java.util.LinkedList;
import java.util.Queue;

public class MinDistance {
    LinkedList<Integer> linkedList[];
    int vertex;

    public MinDistance(int vertex) {
        this.vertex = vertex;
        linkedList=new LinkedList[vertex];
        for(int i=0;i<vertex;i++){
            linkedList[i]=new LinkedList<>();
        }
    }
    void addEdge(int v,int u){
        linkedList[v].add(u);
        
    }
    int minEdge(int s,int e){
        boolean visited[]=new boolean[vertex];
        int[] distance=new int[vertex];
        for(int i=0;i<vertex;i++){
            visited[i]=false;
            distance[i]=0;
        }
        Queue queue=new LinkedList();
        distance[s]=0;
        queue.add(s);
        while (queue.size()!=0){
            int x=(int)queue.peek();
            queue.poll();
            Iterator<Integer> iterator=linkedList[x].listIterator();
            while (iterator.hasNext()){
                int t=iterator.next();
                if(visited[t]==false){
                    visited[t]=true;
                    distance[t]=distance[x]+1;
                    queue.add(t);
                }

            }
        }
        return distance[e];
    }

    public static void main(String[] args) {
        MinDistance m=new MinDistance(9);
        m.addEdge(0,1);
        m.addEdge(0,7);
        m.addEdge(1,7);
        m.addEdge(1,2);
        m.addEdge(2,3);
        m.addEdge(2,5);
        m.addEdge(2,8);
        m.addEdge(3,4);
        m.addEdge(3,5);
        m.addEdge(4,5);
        m.addEdge(5,6);
        m.addEdge(6,7);
        m.addEdge(7,8);
        System.out.println(m.minEdge(0,5));


    }
}