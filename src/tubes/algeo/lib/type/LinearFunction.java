package tubes.algeo.lib.type;

public class LinearFunction {
  private final double[] coefficient;

  public LinearFunction(double[] coefficient){
    this.coefficient = coefficient;
  }

  public int getVariableNumber(){
    // Elemen pertama konstanta tanpa variabel
    return coefficient.length - 1;
  }

  public double calculate(double[] value) throws Exception {
    if(value.length == this.getVariableNumber()){
      double result = this.coefficient[0];

      for(int i = 1; i < this.coefficient.length; i++){
        result += value[i-1] * this.coefficient[i];
      }

      return result;
    }else{
      throw new Exception("Jumlah variabel yang diinputkan tidak sama");
    }
  }

  public double[] getCoefficients(){
    return this.coefficient;
  }
}
