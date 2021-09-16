package tubes.algeo.lib;

import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.SPLResult;

public class SPL {
  public static SPLResult gaussElimination(Matriks augmented){
    return new SPLResult(new Matriks(0,0), SPLResult.RESULT_NO_SOLUTION);
  }

  public static SPLResult gaussJordanElimination(Matriks augmented){
    return new SPLResult(new Matriks(0,0), SPLResult.RESULT_NO_SOLUTION);

  }

  public static SPLResult kofaktorMethod(Matriks augmented){
    return new SPLResult(new Matriks(0,0), SPLResult.RESULT_NO_SOLUTION);
  }

  public static SPLResult cramer(Matriks augmented){
    return new SPLResult(new Matriks(0,0), SPLResult.RESULT_NO_SOLUTION);
  }
}
