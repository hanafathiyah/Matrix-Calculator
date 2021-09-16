package tubes.algeo.lib.type;


public class SPLResult {
  public static final int RESULT_ONE_SOLUTION = 0;
  public static final int RESULT_NO_SOLUTION = -1;
  public static final int RESULT_MANY_SOLUTION = 1;

  private final Matriks result;
  private final int status;

  public SPLResult(Matriks result, int status){
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

  public Matriks getResult(){
    // Memberikan hasil SPL bila SPL punya solusi
    return result;
  }

  public void printResult(){

  }
}
