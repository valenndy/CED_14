package model.data_structures;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

public class Graph{

    private int v;
    private LinkedList<Edge> adj[];

    public Graph(int v) {
        this.v = v;
        adj = new LinkedList[v];
        for (int i = 0; i < v; i++) {
            adj[i] = new LinkedList<>();
        }
    }

    public LinkedList<Edge>[] getAdj() {
        return adj;
    }

    public void addEdge(int s, int d) {
        Edge e = new Edge(s, d);
        adj[(int) s].add(e);
    }

    public ArrayList BFS(int s) {
        ArrayList<Integer> msg = new ArrayList<>();

        boolean visited[] = new boolean[v];
        LinkedList<Integer> queue = new LinkedList<>();
        visited[s] = true;
        queue.add(s);
        while (!queue.isEmpty()) {
            s = queue.poll();
            msg.add(s);
            Iterator<Edge> i = getAdj()[s].listIterator();
            while (i.hasNext()) {
                int n = i.next().getD();
                if (!visited[n]) {
                    visited[n] = true;
                    queue.add(n);
                }
            }
        }
        return msg;
    }

    public int getSize() {
        return v;
    }


}
