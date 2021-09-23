package tubes.algeo.type;

import org.junit.Assert;
import org.junit.Test;
import tubes.algeo.lib.type.LinearFunction;
import tubes.algeo.lib.util.floatingPoint;

public class LinearFunctionTest {
  @Test
  public void testNumVar(){
    double[] coeff = {1, 2, 3, 4, 5};
    double[] coeff2 = {1};

    LinearFunction lf = new LinearFunction(coeff);
    LinearFunction lf2 = new LinearFunction(coeff2);

    Assert.assertEquals(4, lf.getVariableNumber());
    Assert.assertEquals(0, lf2.getVariableNumber());
  }

  @Test
  public void testCalc() throws Exception {
    double[] coeff = {1, 2, 3, 4, 5};
    double[] coeff2 = {1};

    LinearFunction lf = new LinearFunction(coeff);
    LinearFunction lf2 = new LinearFunction(coeff2);

    double[] x1 = {1,1,1,1};
    double[] x2 = {};

    Assert.assertTrue(floatingPoint.isEqual(lf.calculate(x1), 15));
    Assert.assertTrue(floatingPoint.isEqual(lf2.calculate(x2), 1));
  }

  @Test
  public void testGetCoeff(){
    double[] coeff = {1, 2, 3, 4, 5};
    double[] coeff2 = {1};

    LinearFunction lf = new LinearFunction(coeff);
    LinearFunction lf2 = new LinearFunction(coeff2);

    Assert.assertEquals(lf.getCoefficients(), coeff);
    Assert.assertEquals(lf2.getCoefficients(), coeff2);
  }
}
