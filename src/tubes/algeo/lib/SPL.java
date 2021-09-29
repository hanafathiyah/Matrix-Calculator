package tubes.algeo.lib;

import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.SPLResult;
import tubes.algeo.lib.util.floatingPoint;

public class SPL {
  public static int solutionChecker(Matriks augmented){
    int row = 0, eselon = 0;
    int result = -2;
    while(row < augmented.getNRows()
            && eselon < augmented.getNCols()){
      if(eselon == augmented.getNCols() - 1){
        if(floatingPoint.isEqual(augmented.getElmt(row,eselon), 0)){
          if(row < eselon){
            result = SPLResult.RESULT_MANY_SOLUTION;
          }else{
            row++;
          }
        }else{
          result = SPLResult.RESULT_NO_SOLUTION;
        }
      }else if(floatingPoint.isEqual(augmented.getElmt(row,eselon), 1)){
        row++;
      }

      eselon++;
    }

    if(result == -2){
      if(row >= augmented.getNCols() - 1){
        result = SPLResult.RESULT_ONE_SOLUTION;
      }else{
        result = SPLResult.RESULT_MANY_SOLUTION;
      }
    }

    return result;
  }

  public static SPLResult gaussElimination(Matriks augmented){
    Matriks res = new Matriks(10,1);
    res.setElmt(0,1,1);
    res.setElmt(1,1,10);
    res.setElmt(2,1,9);

    return new SPLResult(res, SPLResult.RESULT_ONE_SOLUTION);
  }

  public static SPLResult gaussJordanElimination(Matriks augmented){
    Matriks operasi = new Matriks(augmented);
    operasi.eliminasiGaussJordan();

    return new SPLResult(operasi, SPL.solutionChecker(operasi));
  }

  public static SPLResult cramer(Matriks augmented) throws Exception {
    Matriks operasi = new Matriks(augmented);
    Matriks hasil = operasi.metodeCrammer();
    return new SPLResult(hasil, SPL.solutionChecker(hasil));
  }

  public static SPLResult matriksInverseMethod(Matriks augmented){
    Matriks koefisien = new Matriks(augmented.getNCols() -1, augmented.getNCols() -1);

    return new SPLResult(koefisien, SPL.solutionChecker(koefisien));
  }
}
