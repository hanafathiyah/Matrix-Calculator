package tubes.algeo.lib.util;

import java.math.BigDecimal;

public class floatingPoint {
  private static final double EPSILON = 1e-9;

  public static boolean isEqual(double d1, double d2){
    return Math.abs(d1-d2) < EPSILON;
  }

  public static boolean isGreaterThan(double d1, double d2){
    return d1-d2 > EPSILON;
  }

  public static boolean isLessThan(double d1, double d2){
    return d2-d1 > EPSILON;
  }
}
