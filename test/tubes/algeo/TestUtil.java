package tubes.algeo;

import org.junit.Assert;
import org.junit.Test;
import tubes.algeo.lib.util.floatingPoint;

public class TestUtil {
  @Test
   public void shouldAnswerWithTrue()
    {
      double a = .1;
      double b = .2;
      double c = a + b;

      Assert.assertTrue(floatingPoint.isEqual(c, 0.3));
      Assert.assertTrue(floatingPoint.isLessThan(a, b));
      Assert.assertTrue(floatingPoint.isGreaterThan(b, a));
    }
}
