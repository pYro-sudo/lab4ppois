import by.losik.lab4.Edge;
import by.losik.lab4.Graph;
import by.losik.lab4.Iterator;
import by.losik.lab4.Vertex;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class TestIterator {
    @Test
    public void testIterator(){
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
        Assert.assertEquals(Optional.ofNullable(graph.getIterator().addItem("vertex8", 64).getValue()),Optional.ofNullable(64));
        Assert.assertEquals(Optional.ofNullable(graph.getIterator().addItem("vertex9", 66).getName()),Optional.ofNullable("vertex9"));
        Assert.assertEquals(graph.getIterator().getEdgeList(),edgeList);
        Assert.assertEquals(graph.getIterator().getVertexList(),vertexList);
        Assert.assertEquals(graph.getIterator().addEdge("edge",vertexList.get(0),vertexList.get(1)).getName(),"edge");
        Assert.assertEquals(graph.getIterator().addEdge("edge",vertexList.get(0),new Vertex<>("vrtx",89,0)), null);
        Assert.assertEquals(graph.getIterator().deleteEdge("edgeName").getName(),"edgeName");
        Assert.assertEquals(graph.getIterator().deleteVertex("name").getName(),"name");
        graph.getIterator().set(new Edge<>("name", new Vertex<>("name2",9,0),new Vertex<>("name8",89,0)));
        Assert.assertTrue(String.valueOf((graph.getIterator().getCurrentEdge().getName().equals("name") && graph.getIterator().getCurrentEdge().getFirst().getName().equals("name2") && graph.getIterator().getCurrentEdge().getSecond().getName().equals("name8"))), true);
        graph.getIterator().setVertexList(new ArrayList<>());
        Assert.assertFalse(graph.getIterator().hasNext(new Vertex<>("vertex1",9,0)) && graph.getIterator().hasPrevious(new Vertex<>("vertex1",9,0)));
        Assert.assertFalse(graph.getIterator().hasNext(new Edge<>("name",new Vertex<>("name2",9,0),new Vertex<>("name8",89,0))) && graph.getIterator().hasPrevious(new Edge<>("name",new Vertex<>("name2",9,0),new Vertex<>("name8",89,0))));
        Assert.assertEquals(graph.getIterator().next(new Edge<>("name",new Vertex<>("name2",9,0),new Vertex<>("name8",89,0))),null);
        Assert.assertEquals(graph.getIterator().previous(new Edge<>("name",new Vertex<>("name2",9,0),new Vertex<>("name8",89,0))),null);
        Assert.assertEquals(graph.getIterator().next(new Vertex<>("vertex1",9,0)),null);
        Assert.assertEquals(graph.getIterator().nextIndex(new Vertex<>("vertex1",9,0)),-1);
        Assert.assertEquals(graph.getIterator().previousIndex(new Vertex<>("vertex1",9,0)),-1);
        Assert.assertEquals(graph.getIterator().nextIndex(new Edge<>("name",new Vertex<>("name2",9,0),new Vertex<>("name8",89,0))),-1);
        Assert.assertEquals(graph.getIterator().previousIndex(new Edge<>("name",new Vertex<>("name2",9,0),new Vertex<>("name8",89,0))),-1);
        Assert.assertNull(graph.getIterator().findVertex("name10"));
        Assert.assertNull(graph.getIterator().findEdge("someEdge"));
        Assert.assertTrue(graph.getIterator().reverseEdgeList() instanceof List);
        Assert.assertTrue(graph.getIterator().reverseVertexList() instanceof  List);
        Assert.assertTrue(graph.getIterator().getCurrentEdge() instanceof Edge);
    }
}
