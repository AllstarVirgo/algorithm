package graph.practice;

public class NumIslands {

    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        int sum = 0;
        for (int k = 0; k < grid.length; k++) {
            for (int l = 0; l < grid[k].length; l++) {
                if (grid[k][l] == '1' && !visited[k][l]) {
                    sum++;
                    numIslandsHelper(visited, grid, k, l);
                }
            }
        }
        return sum;
    }

    private void numIslandsHelper(boolean[][] visited, char[][] grid, int i, int j) {
        int row = grid.length;
        int column = grid[0].length;
        if (i < 0 || i >= row || j < 0 || j >= column) {
            return;
        }
        if (visited[i][j]) {
            return;
        }
        visited[i][j] = true;
        if (grid[i][j] == '0') {
            return;
        }
        numIslandsHelper(visited, grid, i + 1, j);
        numIslandsHelper(visited, grid, i - 1, j);
        numIslandsHelper(visited, grid, i, j + 1);
        numIslandsHelper(visited, grid, i, j - 1);
    }
}
