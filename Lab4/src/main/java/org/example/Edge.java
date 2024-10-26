package org.example;

import org.jetbrains.annotations.NotNull;

public class Edge<K> {
    private String name;
    private Tuple edge;
    private Vertex<K> first;
    private Vertex<K> second;

    public Edge(String name, @NotNull Vertex<K> first, @NotNull Vertex<K> second){
        this.name = name;
        this.first= first;
        this.second = second;
        this.edge = new Tuple(first.getDegree(), second.getDegree());
    }

    public Tuple getEdgeDegree() {
        System.out.println("("+edge.getV1()+", "+edge.getV2()+")");
        return this.edge;
    }

    public String getName() {
        return name;
    }

    public Vertex<K> getFirst() {
        return first;
    }

    public Vertex<K> getSecond() {
        return second;
    }
}
