package graph;

import java.util.ArrayList;
import java.util.List;

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

    }

}
