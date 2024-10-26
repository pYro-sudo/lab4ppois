package by.losik.lab4;

import java.util.ArrayList;
import java.util.List;

public class Vertex<K> {
    private List<Edge<K>> incidental = new ArrayList<>();
    private List<Vertex<K>> adjacent = new ArrayList<>();
    private Iterator<K> iterator = new Iterator<>(adjacent,incidental);
    private String name;
    private K value;
    private int Count = 0;

    public Vertex(String name, K value, int count){
        this.name = name;
        this.value = value;
        this.Count = count;
    }

    public List<Edge<K>> getIncidental() {
        return this.incidental;
    }
    public int getDegree(){
        return this.incidental.size();
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public K getValue() {
        return this.value;
    }

    public void setValue(K value) {
        this.value = value;
    }

    public int getCount() {
        return Count;
    }

    public void setCount(int count) {
        Count = count;
    }

    public void setIncidental(List<Edge<K>> incidental) {
        this.incidental = incidental;
    }

    public void setAdjacent(List<Vertex<K>> adjacent) {
        this.adjacent = adjacent;
    }

    public List<Vertex<K>> getAdjacent() {
        return adjacent;
    }

    public Iterator<K> getIterator() {
        return iterator;
    }

    public void clear(){
        this.getIncidental().clear();
        this.getAdjacent().clear();
    }
}
