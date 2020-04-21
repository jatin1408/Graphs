import java.util.ArrayList;

class Graphs {
    public static void main(String[] args) {
        int v=5;
        ArrayList<ArrayList<Integer>> arrayLists=new ArrayList<ArrayList<Integer>>(v);
        for(int i=0;i<v;i++){
            arrayLists.add(new ArrayList<>());
        }
        addEdge(arrayLists,0,1);
        addEdge(arrayLists,0,4);
        addEdge(arrayLists,1,2);
        addEdge(arrayLists, 1, 3);
        addEdge(arrayLists, 1, 4);
        addEdge(arrayLists, 2, 3);
        addEdge(arrayLists, 3, 4);
        print(arrayLists);

    }
    static void addEdge(ArrayList<ArrayList<Integer>> arrayLists,int u,int v){
        arrayLists.get(u).add(v);
        arrayLists.get(v).add(u);
    }
    static void print(ArrayList<ArrayList<Integer>> arrayLists){
        for(int i=0;i<arrayLists.size();i++){
            for(int j=0;j<arrayLists.get(i).size();j++){
                System.out.print(" >> "+arrayLists.get(i).get(j));
            }
            System.out.println();
        }
    }
}