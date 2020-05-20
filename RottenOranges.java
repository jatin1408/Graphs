import java.util.LinkedList;
import java.util.Queue;

public class RottenOranges {
    static  class Node{
        int x;
        int y;
        int t;

        public Node(int x, int y, int t) {
            this.x = x;
            this.y = y;
            this.t = t;
        }
    }
    static int rot(Queue<Node> queue,int c,int r,int[][] arr){
        int t=0;
        while (queue.size()!=0){
            Node temp=queue.poll();
            if(temp.x-1>=0 && arr[temp.x-1][temp.y]==1){
                arr[temp.x-1][temp.y]=2;
                Node n=new Node(temp.x-1,temp.y,temp.t+1);
                queue.add(n);
                t=temp.t+1;
            }
            if(temp.x+1<=r && arr[temp.x+1][temp.y]==1){
                arr[temp.x+1][temp.y]=2;
                Node n=new Node(temp.x+1,temp.y,temp.t+1);
                queue.add(n);
                t=temp.t+1;
            }
            if(temp.y+1<=c && arr[temp.x][temp.y+1]==1){
                arr[temp.x][temp.y+1]=2;
                Node n=new Node(temp.x,temp.y+1,temp.t+1);
                queue.add(n);
                t=temp.t+1;
            }
            if(temp.y-1>=0 && arr[temp.x][temp.y-1]==1){
                arr[temp.x][temp.y-1]=2;
                Node n=new Node(temp.x,temp.y-1,temp.t+1);
                queue.add(n);
                t=temp.t+1;
            }
        }
        return t;
    }
    public static void main(String[] args) {
        int[][] a={{2,1,0,2,1},{1,0,1,2,1},{1,0,0,2,1}};
        Queue<Node> queue=new LinkedList<>();
        for(int i=0;i<a.length;i++){
            for(int j=0;j<a[i].length;j++){
                if(a[i][j]==2){
                    Node n=new Node(i,j,0);
                    queue.add(n);
                }
            }
        }
        System.out.println(rot(queue,4,2,a));
        for(int[] obj:a){
            for(int onj:obj){
                System.out.print(onj+" ");
            }
            System.out.println();
        }
    }
}