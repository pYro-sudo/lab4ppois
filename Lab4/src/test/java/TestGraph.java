import by.losik.lab4.Edge;
import by.losik.lab4.Graph;
import by.losik.lab4.Iterator;
import by.losik.lab4.Vertex;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

public class TestGraph {
    @Test
    public void testGraph(){
        Graph<Integer> graph = new Graph<>();
        graph.setIterator(new Iterator<Integer>(new ArrayList<>(),new ArrayList<>()));
        Assert.assertTrue(graph.getIterator() instanceof Iterator<Integer>);
        Assert.assertEquals(graph.amountOfVertices(),0);
        List<Vertex<Integer>> vertexList = new ArrayList<>();
        vertexList.add(new Vertex<Integer>("name",8,0));
        vertexList.add(new Vertex<Integer>("name1",10,0));
        List<Edge<Integer>> edgeList = new ArrayList<>();
        edgeList.add(new Edge<>("edgeName",vertexList.get(0),new Vertex("name2",7,0)));
        edgeList.add(new Edge<>("edgeName2",vertexList.get(1),new Vertex("name3",16,0)));
        graph.getIterator().setVertexList(vertexList);
        graph.getIterator().setEdgeList(edgeList);
        Assert.assertEquals(graph.amountOfEdges(),2);
    }
}
