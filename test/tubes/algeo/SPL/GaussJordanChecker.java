package tubes.algeo.SPL;

import org.junit.Assert;
import org.junit.Test;
import tubes.algeo.lib.SPL;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.SPLResult;

public class GaussJordanChecker {
  @Test
  public void oneSolutionTest(){
    double[][] m0 = {{1,2}};
    double[][] m1 = {{1,1,1,3},{3,2,1,6},{3,7,5,15}};
    double[][] m2 = {{1,1,1,3},{3,2,1,6},{3,7,5,15},{9,1,7,17}};

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

    SPLResult h1 = SPL.gaussJordanElimination(mat1);
    SPLResult h2 = SPL.gaussJordanElimination(mat2);
    SPLResult h3 = SPL.gaussJordanElimination(mat3);
    SPLResult h4 = SPL.gaussJordanElimination(mat4);

    Assert.assertTrue(h1.isNoSolution());
    Assert.assertTrue(h2.isNoSolution());
    Assert.assertTrue(h3.isNoSolution());
    Assert.assertTrue(h4.isNoSolution());
  }

  @Test
  public void manySolutionTest(){
    double[][] m1 = {{1,1,1,3},{3,2,1,6},{2,2,2,6}};
    double[][] m2 = {{1,0,1,2},{2,1,0,9}};
    double[][] m3 = {{1,1,1,3}};
    double[][] m4 = {{1,1,1,3},{3,2,1,6},{2,2,2,6},{6,4,2,12}};
    double[][] m5 = {{0,0,3,6},{2,1,0,3}};
    double[][] m6 = {{0,1,0,0,1,0,2},{0,0,0,1,1,0,-1},{0,1,0,0,0,1,1}};

    Matriks mat1 = Helper.matriksBuilderHelper(m1);
    Matriks mat2 = Helper.matriksBuilderHelper(m2);
    Matriks mat3 = Helper.matriksBuilderHelper(m3);
    Matriks mat4 = Helper.matriksBuilderHelper(m4);
    Matriks mat5 = Helper.matriksBuilderHelper(m5);
    Matriks mat6 = Helper.matriksBuilderHelper(m6);


    SPLResult h1 = SPL.gaussJordanElimination(mat1);
    SPLResult h2 = SPL.gaussJordanElimination(mat2);
    SPLResult h3 = SPL.gaussJordanElimination(mat3);
    SPLResult h4 = SPL.gaussJordanElimination(mat4);
    SPLResult h5 = SPL.gaussJordanElimination(mat5);
    SPLResult h6 = SPL.gaussJordanElimination(mat6);

    Assert.assertTrue(h1.isManySolution());
    Assert.assertTrue(h2.isManySolution());
    Assert.assertTrue(h3.isManySolution());
    Assert.assertTrue(h4.isManySolution());
    Assert.assertTrue(h5.isManySolution());
    Assert.assertTrue(h6.isManySolution());

    Assert.assertEquals("x_1 = r_2; x_2 = 3.0 - 2.0*r_2; x_3 = r_2", h1.getStrResult());
    Assert.assertEquals("x_1 = 2.0 - r_2; x_2 = 5.0 + 2.0*r_2; x_3 = r_2", h2.getStrResult());
    Assert.assertEquals("x_1 = 3.0 - r_1 - r_2; x_2 = r_1; x_3 = r_2", h3.getStrResult());
    Assert.assertEquals("x_1 = r_2; x_2 = 3.0 - 2.0*r_2; x_3 = r_2", h4.getStrResult());
    Assert.assertEquals("x_1 = 1.5 - 0.5*r_1; x_2 = r_1; x_3 = 2.0", h5.getStrResult());
    Assert.assertEquals("x_1 = r_0; x_2 = 1.0 - r_5; x_3 = r_2; x_4 = -2.0 - r_5; x_5 = 1.0 + r_5; x_6 = r_5", h6.getStrResult());
  }
}
