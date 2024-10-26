package by.losik.lab4;

public class Graph<K> {
    private Iterator<K> iterator;

    public int amountOfVertices(){
        return iterator.getVertexList() == null ? 0 : iterator.getVertexList().size();
    }

    public int amountOfEdges(){
        return iterator.getEdgeList() == null ? 0 : iterator.getEdgeList().size();
    }

    public void setIterator(Iterator<K> iterator) {
        this.iterator = iterator;
    }

    public Iterator<K> getIterator() {
        return iterator;
    }
}
