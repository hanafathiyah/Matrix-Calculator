package tubes.algeo.SPL;

import org.junit.Assert;
import org.junit.Test;
import tubes.algeo.lib.SPL;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.SPLResult;

public class CramerChecker {
  @Test
  public void oneSolutionTest() throws Exception {
    double[][] m0 = {{1,2}};
    double[][] m1 = {{1,1,1,3},{3,2,1,6},{3,7,5,15}};
    double[][] m2 = {{1,1,1,3},{3,2,1,6},{3,7,6,16}};
    double[][] m3 = {{1,1,1,3},{3,2,1,6},{3,7,5,15},{9,1,7,17}};

    Matriks mat0 = Helper.matriksBuilderHelper(m0);
    Matriks mat1 = Helper.matriksBuilderHelper(m1);
    Matriks mat2 = Helper.matriksBuilderHelper(m2);
    Matriks mat3 = Helper.matriksBuilderHelper(m3);

    SPLResult h0 = SPL.cramer(mat0);
    SPLResult h1 = SPL.cramer(mat1);
    SPLResult h2 = SPL.cramer(mat2);
    SPLResult h3 = SPL.cramer(mat3);

    Assert.assertTrue(h0.isOneSolution());
    Assert.assertTrue(h1.isOneSolution());
    Assert.assertTrue(h2.isOneSolution());
    Assert.assertTrue(h3.isOneSolution());

    Assert.assertEquals("x_1 = 2.0",h0.getStrResult());
    Assert.assertEquals("x_1 = 1.0; x_2 = 1.0; x_3 = 1.0",h1.getStrResult());
    Assert.assertEquals("x_1 = 1.0000000000000002; x_2 = 1.0000000000000002; x_3 = 1.0",h2.getStrResult());
    Assert.assertEquals("x_1 = 1.0; x_2 = 1.0; x_3 = 1.0",h3.getStrResult());
  }

  @Test
  public void noSolutionTest(){
    double[][] m1 = {{1,1,1,3},{3,2,1,6},{2,2,2,9}};
    double[][] m2 = {{1,0,1,2},{2,0,2,9}};
    double[][] m3 = {{1,1,1,3},{3,2,1,6},{3,7,5,15},{2,2,3,10}};
    double[][] m4 = {{1,1,1,3},{3,2,1,6},{3,7,5,15},{9,1,7,17},{2,2,3,10}};

    Matriks mat1 = Helper.matriksBuilderHelper(m1);
    Matriks mat2 = Helper.matriksBuilderHelper(m2);
    Matriks mat3 = Helper.matriksBuilderHelper(m3);
    Matriks mat4 = Helper.matriksBuilderHelper(m4);

    try {
      SPLResult h1 = SPL.cramer(mat1);
      Assert.assertTrue(h1.isNoSolution());
    }catch (Exception ignored){}

    try {
      SPLResult h2 = SPL.cramer(mat2);
      Assert.assertTrue(h2.isNoSolution());
    }catch (Exception ignored){}

    try{
      SPLResult h3 = SPL.cramer(mat3);
      Assert.assertTrue(h3.isNoSolution());
    }catch (Exception ignored){}

    try{
      SPLResult h4 = SPL.cramer(mat4);
      Assert.assertTrue(h4.isNoSolution());
    }catch (Exception ignored){}

  }
}
