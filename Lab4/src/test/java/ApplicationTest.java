import org.example.*;
import org.junit.Assert;
import org.junit.Test;

import java.util.List;
import java.util.ArrayList;
import java.util.Optional;
import java.util.Vector;

public class ApplicationTest {
    @Test
    public void testBozoSort(){
        BozoSort bozoSort = new BozoSort();
        Assert.assertTrue(bozoSort.getArray() == null);
        bozoSort.setArray(new Vector<>());
        Assert.assertTrue(bozoSort.getArray().isEmpty());
        bozoSort.getArray().add(9.1);
        bozoSort.PrintArray(bozoSort.getArray());
        Assert.assertFalse(!bozoSort.isSorted(bozoSort.getArray()));
        bozoSort.BozoSort();
        Assert.assertTrue(bozoSort.isSorted(bozoSort.getArray()));
    }

    @Test
    public void testMergeSort(){
        MergeSort mergeSort = new MergeSort();
        double arr[] = {9.9,0,1.2,1.1,-8};
        mergeSort.setArr(arr);
        Assert.assertEquals(mergeSort.getArr(),arr);
        mergeSort.printArray(mergeSort.getArr());
        mergeSort.MergeSort();
        Assert.assertTrue(mergeSort.isSorted());
    }

    @Test
    public void testTuple(){
        Tuple tuple = new Tuple(10,20);
        Assert.assertTrue(tuple.getV1() == 10 && tuple.getV2() == 20);
    }

    @Test
    public void testEdge(){
        Vertex<String> first = new Vertex<>("v1","home",0);
        Vertex<String> second = new Vertex<>("v2","school",0);
        Edge<String> edge = new Edge<>("path",first,second);
        Assert.assertTrue(edge.getEdgeDegree() instanceof Tuple);
        Assert.assertEquals(edge.getFirst(),first);
        Assert.assertEquals(edge.getSecond(),second);
        Assert.assertEquals(edge.getName(),"path");
    }

    @Test
    public void testVertex(){
        Vertex<Double> vertex = new Vertex<>("vertex",12.5,0);
        vertex.setName("v");
        Assert.assertEquals(vertex.getName(),"v");
        vertex.setCount(8);
        Assert.assertEquals(vertex.getCount(),8);
        vertex.setValue(18.7);
        Assert.assertEquals(Optional.ofNullable(vertex.getValue()),Optional.ofNullable(18.7));
        vertex.setAdjacent(new ArrayList<>());
        Assert.assertTrue(vertex.getAdjacent().isEmpty());
        vertex.setIncidental(new ArrayList<>());
        Assert.assertTrue(vertex.getIncidental().isEmpty());
        vertex.getIncidental().add(new Edge<Double>("name",vertex,new Vertex<Double>("second",3.1,0)));
        vertex.getAdjacent().add(vertex.getIncidental().get(0).getSecond());
        Assert.assertTrue(!vertex.getAdjacent().isEmpty());
        Assert.assertTrue(!vertex.getIncidental().isEmpty());
        Assert.assertTrue(vertex.getIterator() instanceof Iterator<Double>);
    }

    @Test
    public void testGraphAndIterator(){
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
    }
}
