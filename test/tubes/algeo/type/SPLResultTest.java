package tubes.algeo.type;

import org.junit.Assert;
import org.junit.Test;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.SPLResult;

public class SPLResultTest {
  // Helper
  public static Matriks matriksBuilderHelper(int nrows, int ncols, double[][] payload){
    Matriks result = new Matriks(nrows, ncols);

    for(int i=0; i < nrows; i++){
      for(int j=0; j < ncols; j++){
        result.setElmt(i,j,payload[i][j]);
      }
    }

    return result;
  }

  @Test
  public void TesSelektor(){
    double[][] m1 = {
            {1,0,0,0,5},
            {0,1,0,0,7},
            {0,0,1,0,2},
            {0,0,0,1,3}
    };

    double[][] m2 = {
            {1,0,0,3,5},
            {0,1,0,0,7},
            {0,0,1,5,2},
    };

    double[][] m3 = {
            {1,3,0,0,5},
            {0,0,1,0,7},
            {0,0,0,1,2},
    };

    double[][] m5 = {
            {1,0,0,0,5},
            {0,1,0,0,7},
            {0,0,1,0,2},
            {0,0,0,1,3},
            {0,0,0,0,0}
    };

    Matriks mat1 = SPLResultTest.matriksBuilderHelper(4,5, m1);
    Matriks mat2 = SPLResultTest.matriksBuilderHelper(3,5, m2);
    Matriks mat3 = SPLResultTest.matriksBuilderHelper(3,5, m3);
    Matriks mat4 = new Matriks();
    Matriks mat5 = SPLResultTest.matriksBuilderHelper(5,5, m5);


    SPLResult res1 = new SPLResult(mat1, SPLResult.RESULT_ONE_SOLUTION);
    SPLResult res2 = new SPLResult(mat2, SPLResult.RESULT_MANY_SOLUTION);
    SPLResult res3 = new SPLResult(mat3, SPLResult.RESULT_MANY_SOLUTION);
    SPLResult res4 = new SPLResult(mat4, SPLResult.RESULT_NO_SOLUTION);
    SPLResult res5 = new SPLResult(mat5, SPLResult.RESULT_ONE_SOLUTION);

    // Testing
    Assert.assertTrue(res1.isOneSolution());
    Assert.assertTrue(res2.isManySolution());
    Assert.assertTrue(res3.isManySolution());
    Assert.assertTrue(res4.isNoSolution());
    Assert.assertTrue(res5.isOneSolution());

    Assert.assertFalse(res1.isManySolution());
    Assert.assertFalse(res1.isNoSolution());
    Assert.assertFalse(res2.isOneSolution());
    Assert.assertFalse(res2.isNoSolution());
    Assert.assertFalse(res3.isOneSolution());
    Assert.assertFalse(res3.isNoSolution());
    Assert.assertFalse(res4.isManySolution());
    Assert.assertFalse(res4.isOneSolution());
    Assert.assertFalse(res5.isManySolution());
    Assert.assertFalse(res5.isNoSolution());
  }

  @Test
  public void tesGetMatriks(){
    double[][] m1 = {
            {1,0,0,0,5},
            {0,1,0,0,7},
            {0,0,1,0,2},
            {0,0,0,1,3}
    };

    double[][] m2 = {
            {1,0,0,3,5},
            {0,1,0,0,7},
            {0,0,1,5,2},
    };

    double[][] m3 = {
            {1,3,0,0,5},
            {0,0,1,0,7},
            {0,0,0,1,2},
    };

    double[][] m5 = {
            {1,0,0,0,5},
            {0,1,0,0,7},
            {0,0,1,0,2},
            {0,0,0,1,3},
            {0,0,0,0,0}
    };

    Matriks mat1 = SPLResultTest.matriksBuilderHelper(4,5, m1);
    Matriks mat2 = SPLResultTest.matriksBuilderHelper(3,5, m2);
    Matriks mat3 = SPLResultTest.matriksBuilderHelper(3,5, m3);
    Matriks mat4 = new Matriks();
    Matriks mat5 = SPLResultTest.matriksBuilderHelper(5,5, m5);


    SPLResult res1 = new SPLResult(mat1, SPLResult.RESULT_ONE_SOLUTION);
    SPLResult res2 = new SPLResult(mat2, SPLResult.RESULT_MANY_SOLUTION);
    SPLResult res3 = new SPLResult(mat3, SPLResult.RESULT_MANY_SOLUTION);
    SPLResult res4 = new SPLResult(mat4, SPLResult.RESULT_NO_SOLUTION);
    SPLResult res5 = new SPLResult(mat5, SPLResult.RESULT_ONE_SOLUTION);

    // Testing
    Assert.assertEquals(mat1,res1.getMatrixResult());
    Assert.assertEquals(mat2,res2.getMatrixResult());
    Assert.assertEquals(mat3,res3.getMatrixResult());
    Assert.assertEquals(mat4,res4.getMatrixResult());
    Assert.assertEquals(mat5,res5.getMatrixResult());
  }

  @Test
  public void tesStrResult(){
    double[][] m1 = {
            {1,0,0,0,5},
            {0,1,0,0,7},
            {0,0,1,0,2},
            {0,0,0,1,3}
    };

    double[][] m2 = {
            {1,0,0,3,5},
            {0,1,0,0,7},
            {0,0,1,-5,2},
    };

    double[][] m3 = {
            {1,3,0,0,5},
            {0,0,1,0,7},
            {0,0,0,1,2},
    };

    double[][] m5 = {
            {1,0,0,0,5},
            {0,1,0,0,7},
            {0,0,1,0,2},
            {0,0,0,1,3},
            {0,0,0,0,0}
    };

    Matriks mat1 = SPLResultTest.matriksBuilderHelper(4,5, m1);
    Matriks mat2 = SPLResultTest.matriksBuilderHelper(3,5, m2);
    Matriks mat3 = SPLResultTest.matriksBuilderHelper(3,5, m3);
    Matriks mat4 = new Matriks();
    Matriks mat5 = SPLResultTest.matriksBuilderHelper(5,5, m5);


    SPLResult res1 = new SPLResult(mat1, SPLResult.RESULT_ONE_SOLUTION);
    SPLResult res2 = new SPLResult(mat2, SPLResult.RESULT_MANY_SOLUTION);
    SPLResult res3 = new SPLResult(mat3, SPLResult.RESULT_MANY_SOLUTION);
    SPLResult res4 = new SPLResult(mat4, SPLResult.RESULT_NO_SOLUTION);
    SPLResult res5 = new SPLResult(mat5, SPLResult.RESULT_ONE_SOLUTION);

    // Testing
    Assert.assertEquals("x_1 = 5.0; x_2 = 7.0; x_3 = 2.0; x_4 = 3.0",res1.getStrResult());
    Assert.assertEquals("x_1 = 5.0 - 3.0*r_3; x_2 = 7.0; x_3 = 2.0 + 5.0*r_3; x_4 = r_3",res2.getStrResult());
    Assert.assertEquals("x_1 = 5.0 - 3.0*r_1; x_2 = r_1; x_3 = 7.0; x_4 = 2.0",res3.getStrResult());
    Assert.assertEquals("Persamaan tidak memiliki solusi",res4.getStrResult());
    Assert.assertEquals("x_1 = 5.0; x_2 = 7.0; x_3 = 2.0; x_4 = 3.0",res5.getStrResult());
  }

  @Test
  public void testGetKonstanta() throws Exception{
    double[][] tc = {{1,0,0,3},{0,1,0,2},{0,0,1,1}};
    Matriks mtc = SPLResultTest.matriksBuilderHelper(3,4,tc);
    SPLResult stc = new SPLResult(mtc, SPLResult.RESULT_ONE_SOLUTION);

    double[] ans = {3,2,1};
    double[] res = stc.getVariableValue();
    Assert.assertArrayEquals(ans, res, 1e-9);
  }
}
