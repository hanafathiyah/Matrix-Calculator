package tubes.algeo.SPL;

import org.junit.Assert;
import org.junit.Test;
import tubes.algeo.lib.SPL;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.SPLResult;

public class SolutionCheckerTest {
  @Test
  public void tesOneSolution(){
    double[][] m1 = {{1,0,1},{0,1,2}};
    double[][] m2 = {{1,0,1},{0,1,2},{0,0,0}};
    double[][] m3 = {{1,0,1},{0,1,2},{0,0,0},{0,0,0,0}};
    double[][] m4 = {{1,2}};

    Matriks t1 = Helper.matriksBuilderHelper(m1);
    Matriks t2 = Helper.matriksBuilderHelper(m2);
    Matriks t3 = Helper.matriksBuilderHelper(m3);
    Matriks t4 = Helper.matriksBuilderHelper(m4);


    Assert.assertEquals(SPLResult.RESULT_ONE_SOLUTION, SPL.solutionChecker(t1));
    Assert.assertEquals(SPLResult.RESULT_ONE_SOLUTION, SPL.solutionChecker(t2));
    Assert.assertEquals(SPLResult.RESULT_ONE_SOLUTION, SPL.solutionChecker(t3));
    Assert.assertEquals(SPLResult.RESULT_ONE_SOLUTION, SPL.solutionChecker(t4));
  }

  @Test
  public void testNoSolution(){
    double[][] m1 = {{1,0,0},{0,1,0},{0,0,1}};
    double[][] m2 = {{1,0,0},{0,0,1}};
    double[][] m3 = {{1,0,0},{0,1,0},{0,0,1},{0,0,0}};

    Matriks t1 = Helper.matriksBuilderHelper(m1);
    Matriks t2 = Helper.matriksBuilderHelper(m2);
    Matriks t3 = Helper.matriksBuilderHelper(m3);

    Assert.assertEquals(SPLResult.RESULT_NO_SOLUTION, SPL.solutionChecker(t1));
    Assert.assertEquals(SPLResult.RESULT_NO_SOLUTION, SPL.solutionChecker(t2));
    Assert.assertEquals(SPLResult.RESULT_NO_SOLUTION, SPL.solutionChecker(t3));
  }

  @Test
  public void testManySolution(){
    double[][] m1 = {{1,0,2,1},{0,1,3,2}};
    double[][] m2 = {{1,1,0,2,1},{0,0,1,2,1},{0,0,0,0,0}};
    double[][] m3 = {{1,1,0,2,1},{0,0,1,2,1}};
    double[][] m4 = {{1,2,3}};

    Matriks t1 = Helper.matriksBuilderHelper(m1);
    Matriks t2 = Helper.matriksBuilderHelper(m2);
    Matriks t3 = Helper.matriksBuilderHelper(m3);
    Matriks t4 = Helper.matriksBuilderHelper(m4);


    Assert.assertEquals(SPLResult.RESULT_MANY_SOLUTION, SPL.solutionChecker(t1));
    Assert.assertEquals(SPLResult.RESULT_MANY_SOLUTION, SPL.solutionChecker(t2));
    Assert.assertEquals(SPLResult.RESULT_MANY_SOLUTION, SPL.solutionChecker(t3));
    Assert.assertEquals(SPLResult.RESULT_MANY_SOLUTION, SPL.solutionChecker(t4));
  }
}
