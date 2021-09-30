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

  static Matriks backwardSubstitution(Matriks eselon){
    int lastRow = -1, i = 0, j = 0;
    while (j < eselon.getNCols() && i < eselon.getNRows()){
      if(floatingPoint.isEqual(eselon.getElmt(i,j),1)){
        lastRow = i;
        i++;
      }

      j++;
    }

    for(i = lastRow; i >= 0; i--){
      for(j = 0; j < eselon.getNRows(); j++){
        if(floatingPoint.isEqual(eselon.getElmt(i,j),1)){
          break;
        }
      }

      for(int k = i-1; k >= 0; k--){
        eselon.addRowToRow(i,k,-(eselon.getElmt(k,j)));
      }
    }

    return eselon;
  }

  static Matriks getCoefficientMatriks(Matriks augmented){
    Matriks result = new Matriks(augmented.getNRows(), augmented.getNCols()-1);

    for(int i = 0; i < result.getNRows(); i++){
      for(int j = 0; j < result.getNCols(); j++){
        result.setElmt(i,j, augmented.getElmt(i,j));
      }
    }

    return result;
  }

  static Matriks getConstantaMatriks(Matriks augmented){
    Matriks result = new Matriks(augmented.getNRows(), 1);
    for(int i = 0; i < result.getNRows(); i++){
      result.setElmt(i,0, augmented.getElmt(i, augmented.getNCols() - 1 ));
    }
    return result;
  }

  public static SPLResult gaussElimination(Matriks augmented){
    Matriks data = new Matriks(augmented);
    data.eliminasiGauss();

    Matriks res = backwardSubstitution(data);

    return new SPLResult(res, SPL.solutionChecker(res));
  }

  public static SPLResult gaussJordanElimination(Matriks augmented){
    Matriks operasi = new Matriks(augmented);
    operasi.eliminasiGaussJordan();

    return new SPLResult(operasi, SPL.solutionChecker(operasi));
  }

  private static Matriks getMatriksNonZeroDeterminant(Matriks augmented) throws Exception{
    Matriks upperMatriks = getCoefficientMatriks(truncateToSquare(augmented));
    if(augmented.getNCols()-1 > augmented.getNRows()){
      throw new Exception("Determinan memiliki nilai 0. Gunakan metode lain");
    }else if(augmented.getNCols() - 1 == augmented.getNRows() ||
            !floatingPoint.isEqual(upperMatriks.determinanByReduksi(), 0) ){
      return augmented;
    }else{
      boolean isZeroDeterminant = true;

      for(int i = 0; i < augmented.getNCols()-1 && isZeroDeterminant; i++){
        for(int j = augmented.getNCols()-1; j < augmented.getNRows() && isZeroDeterminant; j++){
          augmented.swapRow(i,j);

          Matriks swappedMatriks = getCoefficientMatriks(truncateToSquare(augmented));
          if(!floatingPoint.isEqual(swappedMatriks.determinanByReduksi(), 0)){
            isZeroDeterminant = false;
          }else{
            augmented.swapRow(i,j);
          }
        }
      }

      if(isZeroDeterminant){
        throw new Exception("Determinan memiliki nilai 0. Gunakan metode lain");
      }else{
        return augmented;
      }
    }
  }

  private static boolean isSolutionSatisfy(Matriks result, Matriks augmented) throws Exception {
    boolean isSatisfy = true;

    for(int i = 0; i < augmented.getNRows() && isSatisfy; i++){
      double res = 0;
      for(int j = 0; j < augmented.getNCols() - 1; j++){
        res += augmented.getElmt(i,j) * result.getElmt(j, result.getNCols()-1);
      }

      if(!floatingPoint.isEqual(res ,augmented.getElmt(i, augmented.getNCols() - 1))){
        isSatisfy = false;
      }
    }

    return isSatisfy;
  }

  private static Matriks truncateToSquare(Matriks augmented){
    Matriks res = new Matriks(augmented.getNCols()-1, augmented.getNCols());

    for(int i = 0; i < res.getNRows();i++){
      for(int j = 0; j < res.getNCols(); j++){
        res.setElmt(i,j,augmented.getElmt(i,j));
      }
    }

    return res;
  }

  public static SPLResult cramer(Matriks augmented) throws Exception {
    Matriks coeff = getCoefficientMatriks(augmented);

    if(coeff.isSquare() && !floatingPoint.isEqual(coeff.determinanByKofaktor(), 0)){
      Matriks operasi = new Matriks(augmented);
      Matriks hasil = operasi.metodeCrammer();
      return new SPLResult(hasil, SPL.solutionChecker(hasil));
    }else{
      Matriks m = getMatriksNonZeroDeterminant(augmented);
      Matriks ms = truncateToSquare(m);
      Matriks res = ms.metodeCrammer();

      boolean hasSolution = isSolutionSatisfy(res, m);
      if(hasSolution){
        return  new SPLResult(res, SPLResult.RESULT_ONE_SOLUTION);
      }else{
        return new SPLResult(res, SPLResult.RESULT_NO_SOLUTION);
      }
    }
  }

  public static SPLResult matriksInverseMethod(Matriks augmented) throws Exception {
    Matriks koefisien = getCoefficientMatriks(augmented);
    Matriks konstanta = getConstantaMatriks(augmented);
    if (koefisien.isSquare() && !floatingPoint.isEqual(koefisien.determinanByKofaktor(), 0)) {
      Matriks inverse = koefisien.inverseByKofaktor();
      Matriks hasil = inverse.product(konstanta);
      Matriks concatidentitashasil = new Matriks(augmented);
      for(int i = 0; i < concatidentitashasil.getNRows(); i++) {
        for(int j = 0; j < concatidentitashasil.getNCols(); j++) {
          if(i == j) {
            concatidentitashasil.setElmt(i,j,1);
          } else if(j == concatidentitashasil.getNCols() - 1) {
            concatidentitashasil.setElmt(i,j,hasil.getElmt(i,0));
          } else {
            concatidentitashasil.setElmt(i,j,0);
          }
        }
      }
      return new SPLResult(concatidentitashasil, SPL.solutionChecker(concatidentitashasil));
    } else{
      Matriks m = getMatriksNonZeroDeterminant(augmented);
      Matriks ms = truncateToSquare(m);

      Matriks coeff = getCoefficientMatriks(ms);
      Matriks constant = getConstantaMatriks(ms);

      Matriks inverse = coeff.inverseByAugmented();
      Matriks hasil = inverse.product(constant);
      Matriks concatidentitashasil = new Matriks(augmented);
      for(int i = 0; i < concatidentitashasil.getNRows(); i++) {
        for(int j = 0; j < concatidentitashasil.getNCols(); j++) {
          if(i == j) {
            concatidentitashasil.setElmt(i,j,1);
          } else if(j == concatidentitashasil.getNCols() - 1) {
            concatidentitashasil.setElmt(i,j,hasil.getElmt(i,0));
          } else {
            concatidentitashasil.setElmt(i,j,0);
          }
        }
      }

      if(isSolutionSatisfy(concatidentitashasil, m)){
        return new SPLResult(concatidentitashasil, SPLResult.RESULT_ONE_SOLUTION);
      }else{
        return new SPLResult(concatidentitashasil, SPLResult.RESULT_NO_SOLUTION);
      }
    }
  }
}