package tubes.algeo;

import org.junit.Assert;
import org.junit.Test;
import tubes.algeo.lib.Interpolasi;
import tubes.algeo.lib.error.InterpolasiException;
import tubes.algeo.lib.type.LinearFunction;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.Node;
import tubes.algeo.lib.type.Polynomial;

public class TestInterpolasi {
  @Test
  public void testDerajat1_01() throws Exception {
    Node[] data = new Node[2];
    double[][] tc = new double[2][1];
    tc[0][0] = 2;
    tc[1][0] = 4;

    data[0] = new Node(tc[0],4);
    data[1] = new Node(tc[1],7);

    Polynomial res = Interpolasi.getFunction(data);

    Assert.assertEquals(1, res.getDegree());
    Assert.assertEquals("p(x) = 1.0 + 1.5*x", res.getPolynomialStr());
  }

  @Test
  public void testDerajat1_02(){
    try{
      Node[] data = new Node[2];
      double[][] tc = new double[2][1];
      tc[0][0] = 2;
      tc[1][0] = 2;

      data[0] = new Node(tc[0],4);
      data[1] = new Node(tc[1],7);

      Polynomial res = Interpolasi.getFunction(data);
      Assert.fail();
    } catch (InterpolasiException e){
      Assert.assertTrue(true);
    }
  }

  @Test
  public void testDerajatTinggi() throws InterpolasiException{
    Node[] data = new Node[4];
    double[][] tc = new double[4][1];
    tc[0][0] = 0;
    tc[1][0] = 1;
    tc[2][0] = -1;
    tc[3][0] = 2;


    data[0] = new Node(tc[0],2);
    data[1] = new Node(tc[1],6);
    data[2] = new Node(tc[2],0);
    data[3] = new Node(tc[3],18);


    Polynomial res = Interpolasi.getFunction(data);

    Assert.assertEquals(3, res.getDegree());
    Assert.assertEquals("p(x) = 2.0 + 2.0*x + 1.0*x^2 + 1.0*x^3", res.getPolynomialStr());
  }
}
