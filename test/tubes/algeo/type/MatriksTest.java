package tubes.algeo.type;

import org.junit.Assert;
import org.junit.Test;
import tubes.algeo.lib.type.Matriks;

public class MatriksTest {
  // Helper
  public static Matriks matriksBuilderHelper(double[][] payload){
    Matriks result = new Matriks(payload.length, payload[0].length);

    for(int i=0; i < result.getNRows(); i++){
      for(int j=0; j < result.getNCols(); j++){
        result.setElmt(i,j,payload[i][j]);
      }
    }

    return result;
  }

  @Test
  public void testRowCol(){
    double[][] data = {{0,1,2,3},{0,1,2,3},{0,1,2,3}};
    Matriks res = matriksBuilderHelper(data);

    Assert.assertEquals(4, res.getNCols());
    Assert.assertEquals(3, res.getNRows());

  }
}
