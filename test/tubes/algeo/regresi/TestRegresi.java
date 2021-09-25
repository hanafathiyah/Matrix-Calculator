package tubes.algeo.regresi;

import org.junit.Assert;
import org.junit.Test;
import tubes.algeo.lib.Regresi;
import tubes.algeo.lib.error.RegresiException;
import tubes.algeo.lib.type.LinearFunction;
import tubes.algeo.lib.type.Node;

public class TestRegresi {
  @Test
  public void tesRegresi01() throws RegresiException {
    Node[] data = new Node[6];
    double[][] x = {{0.1},{0.4},{0.5},{0.7},{0.7},{0.9}};
    double[] y = {0.61, 0.92, 0.99, 1.52, 1.47, 2.03};

    for(int i = 0; i < 6; i++){
      data[i] = new Node(x[i],y[i]);
    }

    double[] ans = {0.2862, 1.7645};

    LinearFunction res = Regresi.getFunction(data);
    Assert.assertArrayEquals(ans, res.getCoefficients(), 1e-4);
  }

  @Test
  public void tesRegresi02() throws RegresiException{
    Node[] data = new Node[5];
    double[][] x = {{1},{3},{7},{10},{4}};
    double[] y = {6,5,2,15,6};

    for(int i = 0; i < 5; i++){
      data[i] = new Node(x[i],y[i]);
    }

    double[] ans = {2.9, 0.78};

    LinearFunction res = Regresi.getFunction(data);
    Assert.assertArrayEquals(ans, res.getCoefficients(), 1e-9);
  }

  @Test
  public void tesRegresi03() throws RegresiException{
    Node[] data = new Node[5];
    double[][] x = {{1,3},{4,2},{2,2},{3,9},{9,10}};
    double[] y = {5,7,6,10,11};

    for(int i = 0; i < 5; i++){
      data[i] = new Node(x[i],y[i]);
    }

    double[] ans = {4.35971, 0.26379, 0.46882};

    LinearFunction res = Regresi.getFunction(data);
    Assert.assertArrayEquals(ans, res.getCoefficients(), 1e-5);
  }
}
