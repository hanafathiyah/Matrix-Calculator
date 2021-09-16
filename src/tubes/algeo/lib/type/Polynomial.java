package tubes.algeo.lib.type;

public class Polynomial {
  final double[] constant;

  public Polynomial(double[] constant){
    this.constant = constant;
  }

  public int getDegree(){
    return constant.length - 1;
  }

  public double calculate(double x){
    double result = 0;
    double mul = 1;

    for(double c : this.constant){
      result += mul * c;
      mul *= x;
    }

    return result;
  }
}
