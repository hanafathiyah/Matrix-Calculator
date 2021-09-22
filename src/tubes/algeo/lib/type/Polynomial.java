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

  public String getPolynomialStr(){
    StringBuilder result = new StringBuilder();
    result.append("p(x) = ");
    for(int i = 0; i < this.constant.length; i++){
      if(i == 0){
        result.append(this.constant[i]);
      }else if(i == 1){
        result.append(this.constant[i]);
        result.append("x");
      }else{
        result.append(this.constant[i]);
        result.append("x^");
        result.append(i);
      }

      if(i < this.constant.length - 1){
        result.append(" + ");
      }
    }
    result.append("\n");
    return result.toString();
  }
}
