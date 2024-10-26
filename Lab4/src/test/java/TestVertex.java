import by.losik.lab4.Edge;
import by.losik.lab4.Iterator;
import by.losik.lab4.Vertex;
import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Optional;

public class TestVertex {
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
        vertex.clear();
        Assert.assertTrue(vertex.getIncidental().isEmpty() && vertex.getAdjacent().isEmpty());
    }
}
