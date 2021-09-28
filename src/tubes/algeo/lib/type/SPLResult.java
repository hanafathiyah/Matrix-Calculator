package tubes.algeo.lib.type;


import tubes.algeo.lib.util.floatingPoint;

public class SPLResult {
  public static final int RESULT_ONE_SOLUTION = 0;
  public static final int RESULT_NO_SOLUTION = -1;
  public static final int RESULT_MANY_SOLUTION = 1;

  private final Matriks result;
  private final int status;

  public SPLResult(Matriks result, int status){
    // Result harus dalam Eselon baris tereduksi
    this.result = result;
    this.status = status;
  }

  public boolean isNoSolution(){
    return this.status == SPLResult.RESULT_NO_SOLUTION;
  }

  public boolean isOneSolution(){
    return this.status == SPLResult.RESULT_ONE_SOLUTION;
  }

  public boolean isManySolution(){
    return  this.status == SPLResult.RESULT_MANY_SOLUTION;
  }

  public Matriks getMatrixResult(){
    // Memberikan hasil SPL bila SPL punya solusi
    return this.result;
  }

  public double[] getVariableValue() throws Exception {
    if(this.isOneSolution()){
      double[] result = new double[this.result.getNCols()-1];

      int c = 0;
      for(double[] i : this.result.getMatrix()){
        result[c] = i[this.result.getNCols() - 1];
        c++;
      }

      return result;
    }else{
      throw new Exception("Fungsi ini hanya berlaku untuk solusi tunggal");
    }
  }

  public String getStrResult(){
    final int nVars = this.result.getNCols() - 1;
    if(this.isManySolution()){
      String[] varName = new String[nVars];
      for(int i = 0; i < varName.length; i++){
        varName[i] = "r_" + (Integer.valueOf(i)).toString();
      }

      int i = 0, eselon = 0;
      while(i < this.result.getNRows() && eselon < nVars){
        if(floatingPoint.isEqual(this.result.getElmt(i, eselon), 1)){
          double val = this.result.getElmt(i, nVars);
          StringBuilder tmp = new StringBuilder();

          if(val != 0.0){
            tmp.append(val);
          }

          for(int j = eselon+1; j < nVars; j++){
            if(this.result.getElmt(i, j) > 0){
              if(val != 0.0){
                tmp.append(" - ");
              }

              if(this.result.getElmt(i, j) != 1){
                tmp.append(this.result.getElmt(i, j));
                tmp.append("*");
              }

              tmp.append(varName[j]);
            }else if(this.result.getElmt(i, j) < 0){
              if(val != 0.0){
                tmp.append(" + ");
              }

              if(this.result.getElmt(i, j) != -1){
                tmp.append(this.result.getElmt(i, j) * -1);
                tmp.append("*");
              }

              tmp.append(varName[j]);
            }
          }

          varName[eselon] = tmp.toString();
          eselon++;
          i++;
        }else if(this.result.getElmt(i, eselon) == 0){
          eselon++;
        }
      }

      StringBuilder result = new StringBuilder();
      for(int j = 0; j < varName.length; j++){
        result.append("x_");
        result.append(j+1);
        result.append(" = ");
        result.append(varName[j]);

        if(j < varName.length - 1){
          result.append("; ");
        }
      }

      return result.toString();
    }else if(this.isNoSolution()){
      return "Persamaan tidak memiliki solusi";
    }else{
      StringBuilder result = new StringBuilder();
      for(int i = 0; i < nVars; i++){
        result.append("x_");
        result.append(i+1);
        result.append(" = ");
        result.append(this.result.getElmt(i, nVars));

        if(i < nVars - 1){
          result.append("; ");
        }
      }

      return result.toString();
    }
  }

  public String getMatriksStr(){
    return this.result.getMatriksStr();
  }
}
