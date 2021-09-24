package tubes.algeo.lib;

import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.SPLResult;

public class SPL {
  public static SPLResult gaussElimination(Matriks augmented){
    Matriks res = new Matriks(10,1);
    res.setElmt(0,1,1);
    res.setElmt(1,1,10);
    res.setElmt(2,1,9);

    return new SPLResult(res, SPLResult.RESULT_ONE_SOLUTION);
  }

  public static SPLResult gaussJordanElimination(Matriks augmented){
    Matriks res = new Matriks(10,1);
    // Klo misal ada bannyak solusi, keluarkan dalam bentuk matriks eselon tereduksi
    return new SPLResult(res, SPLResult.RESULT_MANY_SOLUTION);
  }

  public static SPLResult kofaktorMethod(Matriks augmented){
    // Gaada solusi
    Matriks res = new Matriks(0,0);
    return new SPLResult(res, SPLResult.RESULT_NO_SOLUTION);
  }

  public static SPLResult cramer(Matriks augmented){
    Matriks res = new Matriks(10,1);
    return new SPLResult(res, SPLResult.RESULT_ONE_SOLUTION);
  }
}