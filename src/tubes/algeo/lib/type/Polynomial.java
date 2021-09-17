package tubes.algeo.lib.type;

public class Polynomial {
  final double[] constant;

  public Polynomial(double[] constant){
    // f(x) = 3x^3 + 2x + 1
    // double const = { 1, 2, 3}
    // Polynomial data = new Polynomial(const)
    // data.calculate(2) -> ...
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
