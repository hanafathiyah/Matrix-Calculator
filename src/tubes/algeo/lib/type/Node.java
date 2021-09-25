package tubes.algeo.lib.type;

import java.util.Arrays;

public class Node implements Comparable<Node>{
  private final double y;
  private final double[] x;

  public Node(double[] x, double y){
    this.x = x;
    this.y = y;
  }

  public int getXDimension(){
    return x.length;
  }

  public double[] getX() {
    return x;
  }

  public double getY() {
    return y;
  }

  @Override
  public int compareTo(Node o) {
    long sum1 = 0, sum2 = 0;

    for (double v : x) {
      sum1 += v;
    }

    for (double v: o.getX()){
      sum2 += v;
    }

    return (int) (sum1 - sum2);
  }

  @Override
  public String toString() {
    return "Node[" +
            "y=" + y +
            ", x=" + Arrays.toString(x) +
            ']';
  }
}
