class PRIMEMST {
    private static final  int v=5;
    int minkey(int key[],Boolean[] mst){
        int index=-1,min=Integer.MAX_VALUE;
        for(int i=0;i<v;i++){
            if(mst[i]==false && key[i]<min){
                min=key[i];
                index=i;
            }
        }
        return index;
    }
    void primeMST(int[][] graphs) {
        int[] parent = new int[v];
        int[] key = new int[v];
        Boolean[] mst = new Boolean[v];
        for (int i = 0; i < v; i++) {
            mst[i] = false;
            key[i] = Integer.MAX_VALUE;
        }
        key[0] = 0;
        parent[0] = -1;

        for (int j = 0; j < v - 1; j++) {
            int u = minkey(key, mst);
            mst[u] = true;
            for (int i = 0; i < v; i++) {


                if (graphs[u][i] != 0 && mst[i] == false && graphs[u][i] < key[i]) {
                    parent[i] = u;
                    key[i] = graphs[u][i];
                }
            }

        }
        printMST(parent, graphs);

    }
    void printMST(int parent[], int graph[][])
    {
        System.out.println("Edge \tWeight");
        for (int i = 1; i < v; i++)
            System.out.println(parent[i] + " - " + i + "\t" + graph[i][parent[i]]);
    }

    public static void main(String[] args) {
        PRIMEMST p=new PRIMEMST();
        int graph[][] = new int[][] { { 0, 2, 0, 6, 0 },
                { 2, 0, 3, 8, 5 },
                { 0, 3, 0, 0, 7 },
                { 6, 8, 0, 0, 9 },
                { 0, 5, 7, 9, 0 } };
        p.primeMST(graph);
    }
}