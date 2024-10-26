package by.losik.lab4;

import java.util.ArrayList;
import java.util.List;

public class Iterator<K> {
    private List<Vertex<K>> vertexList;
    private List<Edge<K>> edgeList;
    private Vertex<K> currentVertex;
    private Edge<K> currentEdge;

    public Iterator(List<Vertex<K>> vertexList, List<Edge<K>> edgeList){
        this.vertexList = vertexList;
        this.edgeList = edgeList;
        this.currentVertex = (vertexList.isEmpty() || vertexList.equals(null)) ? null : this.vertexList.get(0);
        this.currentEdge = (edgeList.isEmpty()|| edgeList.equals(null)) ? null : this.edgeList.get(0);
    }

    public Vertex<K> addItem(String name, K value){
        for(Vertex<K> item: vertexList){
            if(item.getName().equals(name)){
                System.out.println("Such vertex exists");
                return null;
            }
        }
        Vertex<K> vertex = new Vertex<K>(name, value, 0);
        this.vertexList.add(vertex);
        return vertex;
    }

    public List<Vertex<K>> getVertexList() {
        return vertexList;
    }

    public void setVertexList(List<Vertex<K>> vertexList) {
        this.vertexList = vertexList;
    }

    public Edge<K> addEdge(String name, Vertex<K> first, Vertex<K> second){
        for(Edge<K> edge: edgeList){
            if(edge.getName().equals(name)){
                System.out.println("Such edge exists");
                return null;
            }
        }
        if(this.findVertex(first.getName()) != null && this.findVertex(second.getName()) != null){
            Edge<K> edge = new Edge<K>(name,first,second);
            this.edgeList.add(edge);
            second.setCount(second.getCount()+1);
            return edge;
        }
        else if(this.findVertex(first.getName()) == null && this.findVertex(second.getName()) != null){
            this.vertexList.add(first);
            addEdge(name,first,second);
        } else if (this.findVertex(first.getName()) != null && this.findVertex(second.getName()) == null) {
            this.vertexList.add(second);
            addEdge(name,first,second);
        } else{
            vertexList.add(first);
            vertexList.add(second);
            addEdge(name,first,second);
        }
        return null;
    }

    public List<Edge<K>> getEdgeList() {
        return edgeList;
    }

    public void setEdgeList(List<Edge<K>> edgeList) {
        this.edgeList = edgeList;
    }

    public Vertex<K> deleteVertex(String name){
        Vertex<K> removedVertex = null;
        for(Vertex<K> vertex: vertexList){
            if(vertex.getName().equals(name)){
                for(Edge<K> edge: edgeList){
                    if(edge.getFirst().equals(vertex) && edge.getSecond().equals(vertex)){
                        this.edgeList.remove(edge);
                    }
                }
                removedVertex = vertex;
                break;
            }
        }
        return removedVertex;
    }

    public Edge<K> deleteEdge(String name){
        Edge<K> removedEdge = null;
        for(Edge<K> edge: edgeList){
            if(edge.getName().equals(name)){
                edge.getFirst().getIncidental().remove(edge);
                edge.getSecond().setCount(edge.getSecond().getCount()-1);
                removedEdge = edge;
                this.edgeList.remove(edge);
                break;
            }
        }
        return removedEdge;
    }

    public Vertex<K> findVertex(String name){
        for(Vertex vertex1: vertexList){
            if(vertex1.getName().equals(name)){
                return vertex1;
            }
        }
        return null;
    }

    public Edge<K> findEdge(String name){
        for(Edge edge: edgeList){
            if(edge.getName().equals(name)){
                return edge;
            }
        }
        return null;
    }

    public boolean hasNext(Vertex<K> vertex){
        return this.vertexList.contains(vertex) ? (this.vertexList.contains(vertexList.get(vertexList.indexOf(vertex)+1)) && !vertex.equals(null)) : false;
    }

    public boolean hasPrevious(Vertex<K> vertex){
        return this.vertexList.contains(vertex) ? (this.vertexList.contains(vertexList.get(vertexList.indexOf(vertex)-1)) && !vertex.equals(null)) : false;
    }

    public Vertex<K> next(Vertex<K> vertex){
        return hasNext(vertex) ? vertexList.get(vertexList.indexOf(vertex)+1) : null;
    }

    public Vertex<K> previous(Vertex<K> vertex){
        return hasPrevious(vertex) ? vertexList.get(vertexList.indexOf(vertex)-1) : null;
    }

    public int nextIndex(Vertex<K> vertex){
        return hasNext(vertex) ? vertexList.indexOf(vertex)+1 : -1;
    }

    public int previousIndex(Vertex<K> vertex){
        return hasNext(vertex) ? vertexList.indexOf(vertex)-1 : -1;
    }

    public void set(Vertex<K> vertex){
        this.currentVertex = vertex;
    }

    public boolean hasNext(Edge<K> edge){
        return this.edgeList.contains(edge) ? (this.edgeList.contains(edgeList.get(edgeList.indexOf(edge)+1)) && !edge.equals(null)) : false;
    }

    public boolean hasPrevious(Edge<K> edge){
        return (this.edgeList.contains(edge)) ? (this.edgeList.contains(edgeList.get(edgeList.indexOf(edge)-1)) && !edge.equals(null)) : false;
    }

    public Edge<K> next(Edge<K> edge){
        return hasNext(edge) ? edgeList.get(edgeList.indexOf(edge)+1) : null;
    }

    public Edge<K> previous(Edge<K> edge){
        return hasPrevious(edge) ? edgeList.get(edgeList.indexOf(edge)-1) : null;
    }

    public int nextIndex(Edge<K> edge){
        return hasNext(edge) ? vertexList.indexOf(edge)+1 : -1;
    }

    public int previousIndex(Edge<K> edge){
        return hasPrevious(edge) ? vertexList.indexOf(edge)-1 : -1;
    }

    public void set(Edge<K> edge){
        this.currentEdge = edge;
    }

    public Vertex<K> removeVertexByIterator(){
        Vertex<K> vertex;
        if(hasNext(currentVertex)){
            vertex=next(currentVertex);
            vertexList.remove(currentVertex);
            return vertex;
        }
        else if(hasPrevious(currentVertex)){
            vertex=previous(currentVertex);
            vertexList.remove(currentVertex);
            return vertex;
        }
        return null;
    }

    public Edge<K> removeEdgeByIterator(){
        Edge<K> edge;
        if(hasNext(currentEdge)){
            edge=next(currentEdge);
            vertexList.remove(currentEdge);
            return edge;
        }
        else if(hasPrevious(currentEdge)){
            edge=previous(currentEdge);
            vertexList.remove(currentEdge);
            return edge;
        }
        return null;
    }

    public void swap(Object first, Object second){
        Object temporary = first;
        first = second;
        second = temporary;
    }

    public List<Vertex<K>> reverseVertexList(){
        List<Vertex<K>> vertexList1 = new ArrayList<>();
        for(int i=vertexList.size()-1;i >= 0;--i){
            vertexList1.add(vertexList.get(i));
        }
        vertexList = vertexList1;
        return vertexList;
    }

    public List<Edge<K>> reverseEdgeList(){
        List<Edge<K>> edgeList1 = new ArrayList<>();
        for(int i=edgeList.size()-1;i >= 0;--i){
            edgeList1.add(edgeList.get(i));
        }
        edgeList = edgeList1;
        return edgeList;
    }

    public Vertex<K> getCurrentVertex(){
        return this.currentVertex;
    }

    public Edge<K> getCurrentEdge(){
        return this.currentEdge;
    }

    public void clear(){
        this.vertexList.clear();
        this.edgeList.clear();
        this.currentVertex = null;
        this.currentEdge = null;
    }
}
