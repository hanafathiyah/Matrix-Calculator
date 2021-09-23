package tubes.algeo.type;

import org.junit.Assert;
import org.junit.Test;
import tubes.algeo.lib.type.Polynomial;

public class PolynomialTest {
  @Test
  public void getDegreeTest(){
    double[] constant = {1,2,3,4,5};
    double[] constant2 = {1};

    Polynomial p1 = new Polynomial(constant);
    Polynomial p2 = new Polynomial(constant2);

    Assert.assertEquals(4, p1.getDegree());
    Assert.assertEquals(0, p2.getDegree());
  }

  @Test
  public void calculateTest(){
    double[] constant = {1,2,3,4,5};
    double[] constant2 = {1};

    Polynomial p1 = new Polynomial(constant);
    Polynomial p2 = new Polynomial(constant2);

    Assert.assertEquals(129, p1.calculate(2), 1e-9);
    Assert.assertEquals(1, p2.calculate(2), 1e-9);
  }

  @Test
  public void getPolynomialStrTest(){
    double[] constant = {1,2,3,4,5};
    double[] constant2 = {1};

    Polynomial p1 = new Polynomial(constant);
    Polynomial p2 = new Polynomial(constant2);

    Assert.assertEquals("p(x) = 1.0 + 2.0*x + 3.0*x^2 + 4.0*x^3 + 5.0*x^4", p1.getPolynomialStr());
    Assert.assertEquals("p(x) = 1.0", p2.getPolynomialStr());
  }
}
