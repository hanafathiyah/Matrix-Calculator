package tubes.algeo.lib;

import tubes.algeo.lib.error.InterpolasiException;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.Polynomial;
import tubes.algeo.lib.type.Node;
import tubes.algeo.lib.type.SPLResult;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;

public class Interpolasi {
  public static Polynomial getFunction(Node[] titik) throws InterpolasiException {
    // Interpolasi 1 variabel
    Arrays.sort(titik);

    int degree = titik.length - 1;
    Matriks augmented = new Matriks(degree + 1, degree + 2);

    for(int i = 0; i < degree + 1; i++){
      double mul = 1, exp = titik[i].getX()[0];

      for(int j = 0; j < degree + 1; j++, mul *= exp){
        augmented.setElmt(i,j,mul);
      }

      augmented.setElmt(i, degree + 1, titik[i]. getY());
    }

    SPLResult res = SPL.gaussJordanElimination(augmented);

    if(res.isOneSolution()){
      try{
        return new Polynomial(res.getVariableValue());
      }catch(Exception e){
        throw new InterpolasiException(e.getMessage());
      }
    }else{
      throw new InterpolasiException("Tidak ada persamaan interpolasi yang memenuhi");
    }

  }
}
