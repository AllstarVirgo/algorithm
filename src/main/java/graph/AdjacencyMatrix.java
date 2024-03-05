package graph;

public class AdjacencyMatrix {

    /**
     * 顶点count
     */
    private int v;

    private int[][] matrix;

    public AdjacencyMatrix(int v) {
        this.v = v;
        matrix = new int[v][v];
    }

    public void add(int i, int j) {
        matrix[i][j] = 1;
    }

    public void add(int i, int j, int weight) {
        matrix[i][j] = weight;
    }

    public void addIfUnDirect(int i, int j) {
        matrix[i][j] = 1;
        matrix[j][i] = 1;
    }
}
