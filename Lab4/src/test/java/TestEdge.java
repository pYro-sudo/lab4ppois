import by.losik.lab4.Edge;
import by.losik.lab4.Vertex;
import org.junit.Assert;
import org.junit.Test;

public class TestEdge {
    @Test
    public void testEdge(){
        Vertex<String> first = new Vertex<>("v1","home",0);
        Vertex<String> second = new Vertex<>("v2","school",0);
        Edge<String> edge = new Edge<>("path",first,second);
        Assert.assertTrue(edge.getEdgeDegree() == 0);
        Assert.assertEquals(edge.getFirst(),first);
        Assert.assertEquals(edge.getSecond(),second);
        Assert.assertEquals(edge.getName(),"path");
    }

}
