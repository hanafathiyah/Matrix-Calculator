package tubes.algeo.lib.type;


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

  public boolean isNoResult(){
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

  public String getStrResult(){
    final int nVars = this.result.getNCols() - 1;
    if(this.isManySolution()){
      String[] varName = new String[nVars - 1];
      for(int i = 0; i < varName.length; i++){
        varName[i] = "r" + (Integer.valueOf(i)).toString();
      }

      int i = 0, eselon = 0;
      while(i < nVars && eselon < nVars){
        if(this.result.getElmt(i, eselon) == 1){
          StringBuilder tmp = new StringBuilder((Double.valueOf(this.result.getElmt(i, nVars))).toString());

          for(int j = i+1; j < nVars; j++){
            if(this.result.getElmt(i, j) > 0){
              tmp.append(" - ");
              tmp.append(this.result.getElmt(i, j));
              tmp.append("*");
              tmp.append(varName[j]);
            }else if(this.result.getElmt(i, j) < 0){
              tmp.append(" + ");
              tmp.append(this.result.getElmt(i, j));
              tmp.append("*");
              tmp.append(varName[j]);
            }
          }

          varName[i] = tmp.toString();
          eselon++;
          i++;
        }else if(this.result.getElmt(i, eselon) == 0){
          eselon++;
        }
      }

      StringBuilder result = new StringBuilder();
      for(int j = 0; j < varName.length; j++){
        result.append("x");
        result.append(j+1);
        result.append(" = ");
        result.append(varName[i]);
        result.append("\n");
      }

      return result.toString();
    }else if(this.isNoResult()){
      return "Persamaan tidak memiliki solusi.";
    }else{
      StringBuilder result = new StringBuilder();
      for(int i = 0; i < nVars; i++){
        result.append("x");
        result.append(i+1);
        result.append(" = ");
        result.append(this.result.getElmt(i, nVars));
        result.append("\n");
      }

      return result.toString();
    }
  }
}
