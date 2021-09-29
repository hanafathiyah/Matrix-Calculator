package tubes.algeo.SPL;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import tubes.algeo.lib.SPL;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.SPLResult;

@Ignore
public class InverseChecker {
  @Test
  public void oneSolutionTest(){
    double[][] m0 = {{1,2}};
    double[][] m1 = {{1,1,1,3},{3,2,1,6},{3,7,5,15}};
    double[][] m2 = {{1,1,1,3},{3,2,1,6},{3,7,6,16}};

    Matriks mat0 = Helper.matriksBuilderHelper(m0);
    Matriks mat1 = Helper.matriksBuilderHelper(m1);
    Matriks mat2 = Helper.matriksBuilderHelper(m2);

    SPLResult h0 = SPL.gaussJordanElimination(mat0);
    SPLResult h1 = SPL.gaussJordanElimination(mat1);
    SPLResult h2 = SPL.gaussJordanElimination(mat2);

    Assert.assertTrue(h0.isOneSolution());
    Assert.assertTrue(h1.isOneSolution());
    Assert.assertTrue(h2.isOneSolution());

    Assert.assertEquals("x_1 = 2.0",h0.getStrResult());
    Assert.assertEquals("x_1 = 1.0; x_2 = 1.0; x_3 = 1.0",h1.getStrResult());
    Assert.assertEquals("x_1 = 1.0; x_2 = 1.0; x_3 = 1.0",h2.getStrResult());
  }
}
