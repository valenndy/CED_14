package model.data_structures;

import java.util.Comparator;

public class Edge {
    private int s;
    private int d;

    public Edge() {
    }

    public Edge(int s, int d) {
        this.s = s;
        this.d = d;
    }

    public int getS() {
        return s;
    }

    public int getD() {
        return d;
    }

}
