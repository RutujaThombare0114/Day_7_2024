import java.util.Arrays;

public class PrimAlgorithm {
    private static final int V = 5;
    private int minKey(int key[], boolean mstSet[]) {
        int min = Integer.MAX_VALUE, minIndex = -1;

        for (int v = 0; v < V; v++) {
            if (!mstSet[v] && key[v] < min) {
                min = key[v];
                minIndex = v;
            }
        }
        return minIndex;
    }
    private void printMST(int parent[], int graph[][]) {
        System.out.println("Edge   Weight");
        for (int i = 1; i < V; i++) {
            System.out.println(parent[i] + " - " + i + "    " + graph[i][parent[i]]);
        }
    }
    private void primMST(int graph[][]) {
        
        int parent[] = new int[V];
        int key[] = new int[V];
        boolean mstSet[] = new boolean[V];
        Arrays.fill(key, Integer.MAX_VALUE);
        key[0] = 0;
        parent[0] = -1; // First node is always root of MST
        for (int count = 0; count < V - 1; count++) {
             int u = minKey(key, mstSet);
            mstSet[u] = true;
            for (int v = 0; v < V; v++) {
                if (graph[u][v] != 0 && !mstSet[v] && graph[u][v] < key[v]) {
                    parent[v] = u;
                    key[v] = graph[u][v];
                }
            }
        }
        printMST(parent, graph);
    }
    public static void main(String[] args) {
        PrimAlgorithm t = new PrimAlgorithm();
        int graph[][] = new int[][] {
                {0, 2, 0, 6, 0},
                {2, 0, 3, 8, 5},
                {0, 3, 0, 0, 7},
                {6, 8, 0, 0, 9},
                {0, 5, 7, 9, 0}
        };

        t.primMST(graph);
    }
}

