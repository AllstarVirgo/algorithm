package graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class AdjacencyList {

    private int v;

    private List<List<Integer>> list;

    public AdjacencyList(int v) {
        this.v = v;
        list = new ArrayList<>(v);
        for (int i = 0; i < v; i++) {
            list.add(new ArrayList<>());
        }
    }

    public void addDirect(int s, int t) {
        list.get(s).add(t);
    }

    public void addUnDirect(int s, int t) {
        list.get(s).add(t);
        list.get(t).add(s);
    }

    public void bfs(int s, int t) {
        boolean[] visited = new boolean[v];
        visited[s] = true;
        Queue<Integer> queue = new LinkedList<>();
        queue.offer(s);
        int[] prev = new int[v];
        for (int i = 0; i < v; i++) {
            prev[i] = -1;
        }
        while (!queue.isEmpty()) {
            Integer v = queue.poll();
            List<Integer> adjacencyVs = list.get(v);
            for (Integer adjacencyV : adjacencyVs) {
                if (!visited[adjacencyV]) {
                    prev[adjacencyV] = v;
                    if (t == adjacencyV) {
                        print(prev, adjacencyV);
                        return;
                    }
                    visited[adjacencyV] = true;
                    queue.offer(adjacencyV);
                }
            }
        }
    }

    public void dfs(int s, int t) {
        boolean[] visited = new boolean[v];
        dfsHelper(s, t, visited);
    }

    private boolean findT = false;

    public void dfsHelper(int s, int t, boolean[] visited) {
        if (findT) return; // 提前终止递归如果已经找到目标
        List<Integer> adjacencyVs = list.get(s);
        visited[s] = true;
        for (Integer adjacencyV : adjacencyVs) {
            if (adjacencyV == t) {
                findT = true;
                return;
            }
            if (!visited[adjacencyV]) {
                dfsHelper(adjacencyV, t, visited);
                if (findT) return; // 提前终止递归如果已经找到目标
            }
        }
    }

    private void print(int[] prev, int start) {
        if (prev[start] != -1) {
            print(prev, prev[start]);
        }
        System.out.println(start);
    }

}
