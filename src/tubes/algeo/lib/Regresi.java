package tubes.algeo.lib;

import tubes.algeo.lib.error.RegresiException;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.Node;
import tubes.algeo.lib.type.LinearFunction;
import tubes.algeo.lib.type.SPLResult;

public class Regresi {
  public static Matriks augmentedBuilder(Node[] nodes){
    int nvar = nodes[0].getXDimension();
    Matriks augmented = new Matriks(nvar+1,nvar+2);

    for(int i = 0; i <= nvar; i++){
      for(int j = 0; j <= nvar+1; j++){
        if(j < i){
          augmented.setElmt(i,j,augmented.getElmt(j,i));
        }else if(i == 0 && j == 0){
          augmented.setElmt(i,j, nodes.length);
        }else if(i == 0){
          double sum = 0;

          for (Node node : nodes) {
            if(j < nvar + 1){
              sum += node.getX()[j-1];
            }else{
              sum += node.getY();
            }
          }

          augmented.setElmt(i,j,sum);
        }else if(j == nvar + 1){
          double sum = 0;

          for (Node node : nodes) {
            sum += node.getX()[i-1] * node.getY();
          }

          augmented.setElmt(i,j,sum);
        }else{
          double sum = 0;

          for (Node node : nodes) {
            sum += node.getX()[i-1] * node.getX()[j-1];
          }

          augmented.setElmt(i,j,sum);
        }
      }
    }

    return augmented;
  }

  public static LinearFunction getFunction(Node[] nodes) throws RegresiException {
    if(nodes.length > 2){
      Matriks augmented = augmentedBuilder(nodes);
      SPLResult res = SPL.gaussJordanElimination(augmented);

      if(res.isOneSolution()){
        try{
          return new LinearFunction(res.getVariableValue());
        }catch (Exception e){
          throw new RegresiException(e.getMessage());
        }
      }else{
        throw new RegresiException("Hasil persamaan tidak tuggal");
      }

    }else{
      throw new RegresiException("Jumlah data tidak cukup");
    }
  }
}
