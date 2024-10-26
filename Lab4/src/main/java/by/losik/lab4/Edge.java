package by.losik.lab4;

public class Edge<K> {
    private String name;
    private Vertex<K> first;
    private Vertex<K> second;

    public Edge(String name, Vertex<K> first, Vertex<K> second){
        this.name = name;
        this.first= first;
        this.second = second;
    }

    public int getEdgeDegree() {
        System.out.println("("+first.getDegree()+", "+second.getDegree()+")");
        return first.getDegree()+ second.getDegree();
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
