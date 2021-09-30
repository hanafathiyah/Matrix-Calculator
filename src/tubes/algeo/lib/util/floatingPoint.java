package tubes.algeo.lib.util;

public class floatingPoint {
  private static final double EPSILON = 1e-9;

  public static boolean isEqual(double d1, double d2){
    return Math.abs(d1-d2) * 1e9 <= Math.max(Math.abs(d1), Math.abs(d2));
  }

  public static boolean isGreaterThan(double d1, double d2){
    return d1-d2 > EPSILON;
  }

  public static boolean isLessThan(double d1, double d2){
    return d2-d1 > EPSILON;
  }
}
