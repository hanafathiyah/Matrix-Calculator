package tubes.algeo.type;

import org.junit.Assert;
import org.junit.Test;
import tubes.algeo.lib.type.Node;

public class NodeTest {
  @Test
  public void testDismension(){
    double[] x = {1,2,3,4,5,6};
    double y = 100;

    Node node = new Node(x, y);

    Assert.assertEquals(6, node.getXDimension());
  }

  @Test
  public void testGetXY(){
    double[] x = {1,2,3,4,5,6};
    double y = 100;

    Node node = new Node(x, y);

    Assert.assertEquals(x, node.getX());
    Assert.assertEquals(y, node.getY(), 1e-9);
  }
}
