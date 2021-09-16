package tubes.algeo.lib.type;

public class Node {
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
}
