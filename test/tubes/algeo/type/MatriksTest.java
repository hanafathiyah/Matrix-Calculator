package tubes.algeo.type;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import tubes.algeo.lib.type.Matriks;

public class MatriksTest {
  // Helper
  private static Matriks matriksBuilderHelper(double[][] payload) {
    Matriks result = new Matriks(payload.length, payload[0].length);

    for (int i = 0; i < result.getNRows(); i++) {
      for (int j = 0; j < result.getNCols(); j++) {
        result.setElmt(i, j, payload[i][j]);
      }
    }

    return result;
  }

  private static void testKesamaanMatriks(Matriks m1, Matriks m2) {
    Assert.assertEquals(m1.getNCols(), m2.getNCols());
    Assert.assertEquals(m1.getNRows(), m2.getNRows());

    for (int i = 0; i < m1.getNRows(); i++) {
      Assert.assertArrayEquals(m1.getMatrix()[i], m2.getMatrix()[i], 1e-9);
    }
  }

  @Test
  public void testRowCol() {
    double[][] data = {{0, 1, 2, 3}, {0, 1, 2, 3}, {0, 1, 2, 3}};
    Matriks res = matriksBuilderHelper(data);

    Assert.assertEquals(4, res.getNCols());
    Assert.assertEquals(3, res.getNRows());
  }

  @Test
  public void testSquare() {
    Matriks m1 = new Matriks(2, 3);
    Matriks m2 = new Matriks(5, 5);

    Assert.assertFalse(m1.isSquare());
    Assert.assertTrue(m2.isSquare());
  }

  @Test
  public void testCopyMatriks() {
    double[][] data = {{0, 1, 2, 3}, {0, 1, 2, 3}, {0, 1, 2, 3}};

    Matriks m1 = matriksBuilderHelper(data);
    Matriks m2 = new Matriks();

    Matriks m3 = new Matriks(m1);
    m2.copyMatrix(m1);

    testKesamaanMatriks(m1, m2);
    testKesamaanMatriks(m1, m3);
  }

  @Test
  public void testTranspose() {
    double[][] data = {{0, 1, 2, 3}, {0, 1, 2, 3}, {0, 1, 2, 3}};
    double[][] res = {{0, 0, 0}, {1, 1, 1}, {2, 2, 2}, {3, 3, 3}};

    Matriks m1 = matriksBuilderHelper(data);
    Matriks m2 = matriksBuilderHelper(res);

    m1.transpose();

    testKesamaanMatriks(m1, m2);
  }

  @Test
  public void testSwapRow() {
    double[][] data = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
    double[][] result = {{0, 1, 2, 3}, {8, 9, 10, 11}, {4, 5, 6, 7}};

    Matriks m1 = matriksBuilderHelper(data);
    Matriks m2 = matriksBuilderHelper(result);

    m1.swapRow(1, 2);

    testKesamaanMatriks(m1, m2);
  }

  @Test
  public void testCutOne() {
    double[][] data = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
    double[][] result1 = {{0, 1, 2, 3}, {8, 9, 10, 11}};
    double[][] result2 = {{1, 2, 3}, {5, 6, 7}, {9, 10, 11}};

    Matriks mdata = matriksBuilderHelper(data);
    Matriks r1 = matriksBuilderHelper(result1);
    Matriks r2 = matriksBuilderHelper(result2);

    testKesamaanMatriks(r1, mdata.cutOneRow(1));
    testKesamaanMatriks(r2, mdata.cutOneCol(0));
  }

  @Test
  public void testAddRowToRow() {
    double[][] data = {{0, 1, 2, 3}, {4, 5, 6, 7}, {8, 9, 10, 11}};
    double[][] result = {{4, 6, 8, 10}, {4, 5, 6, 7}, {8, 8, 8, 8}};

    Matriks mdata = matriksBuilderHelper(data);
    Matriks r = matriksBuilderHelper(result);

    mdata.addRowToRow(0, 2, -1);
    mdata.addRowToRow(1, 0, 1);

    testKesamaanMatriks(mdata, r);
  }

  @Test
  public void testPlus() throws Exception {
    double[][] data1 = {{0, 1, 2, 3}, {4, 5, 6, 7}};
    double[][] data2 = {{1, 1, 1, 1}, {2, 2, 2, 2}};
    double[][] res = {{1, 2, 3, 4}, {6, 7, 8, 9}};

    Matriks m1 = matriksBuilderHelper(data1);
    Matriks m2 = matriksBuilderHelper(data2);
    Matriks r = matriksBuilderHelper(res);

    Matriks actualResult = m2.plus(m1);
    testKesamaanMatriks(r, actualResult);
  }

  @Test
  public void testMinus() throws Exception {
    double[][] data1 = {{0, 1, 2, 3}, {4, 5, 6, 7}};
    double[][] data2 = {{1, 1, 1, 1}, {2, 2, 2, 2}};
    double[][] res = {{-1, 0, 1, 2}, {2, 3, 4, 5}};

    Matriks m1 = matriksBuilderHelper(data1);
    Matriks m2 = matriksBuilderHelper(data2);
    Matriks r = matriksBuilderHelper(res);

    Matriks actualResult = m1.minus(m2);
    testKesamaanMatriks(r, actualResult);
  }

  @Test
  public void testDotProduct() throws Exception {
    double[][] data1 = {{0, 2, 2, 5}, {10, 6, 2, 6}};
    double[][] data2 = {{0, 1, 9, 3}, {8, 7, 6, 2}, {1, 9, 2, 5}, {1, 1, 2, -9}};
    double[][] res = {{23, 37, 26, -31}, {56, 76, 142, -2}};

    Matriks m1 = matriksBuilderHelper(data1);
    Matriks m2 = matriksBuilderHelper(data2);
    Matriks mres = matriksBuilderHelper(res);

    Matriks actualRes = m1.dotProduct(m2);
    testKesamaanMatriks(mres, actualRes);
  }

  @Test
  public void testDeterminan() {
    double[][] data = {{1, 7, 7, 2, 5, 4}, {7, 2, 9, 2, 4, 9}, {0, 4, 8, 6, 9, 2}, {1, 0, 8, 9, 6, 0}, {2, 2, 3, 9, 5, 1}, {8, 3, 3, 9, 8, 0}};

    Matriks m = matriksBuilderHelper(data);
    Assert.assertEquals(76296, m.determinanByKofaktor(), 1e-9);
    Assert.assertEquals(76296, m.determinanByReduksi(), 1e-9);
  }

  @Test
  public void testInverse() {
    double[][] data = {{-1, 1, 1, 0}, {2, 3, -2, 6}, {0, -1, 2, 0}, {2, 0, 1, 5}};
    double[][] result = {{-14.0 / 8, 15.0 / 8, 31.0 / 8, -18.0 / 8}, {-4.0 / 8, 10.0 / 8, 18.0 / 8, -12.0 / 8}, {-2.0 / 8, 5.0 / 8, 13.0 / 8, -6.0 / 8},
            {6.0 / 8, -7.0 / 8, -15.0 / 8, 10.0 / 8}};

    Matriks m = matriksBuilderHelper(data);
    Matriks mres = matriksBuilderHelper(result);
    Matriks actualres1 = m.inverseByAugmented();
    Matriks actualres2 = m.inverseByKofaktor();

    testKesamaanMatriks(mres, actualres1);
    testKesamaanMatriks(mres, actualres2);
  }

  @Test
  public void tesGauss() {
    double[][] tc1 = {{2, 3, -1, 5}, {4, 4, -3, 3}, {-2, 3, -1, 1}};
    double[][] tc2 = {{1, 2, 1, 2}, {3, 6, 0, 9}, {2, 8, 4, 6}};
    double[][] tc3 = {{6, 3}};

    double[][] res1 = {{2.0 / 2, 3.0 / 2, -1.0 / 2, 5.0 / 2}, {0, -2.0 / -2, -1.0 / -2, -7.0 / -2}, {0, 0, -5.0 / -5, -15.0 / -5}};
    double[][] res2 = {{1, 2, 1, 2}, {0, 1, 0.5, 0.5}, {0, 0, 1, -1}};
    double[][] res3 = {{1, 0.5}};

    Matriks m1 = matriksBuilderHelper(tc1);
    Matriks m2 = matriksBuilderHelper(tc2);
    Matriks m3 = matriksBuilderHelper(tc3);

    Matriks mres1 = matriksBuilderHelper(res1);
    Matriks mres2 = matriksBuilderHelper(res2);
    Matriks mres3 = matriksBuilderHelper(res3);

    m1.eliminasiGauss();
    m2.eliminasiGauss();
    m3.eliminasiGauss();

    testKesamaanMatriks(mres1, m1);
    testKesamaanMatriks(mres2, m2);
    testKesamaanMatriks(mres3, m3);
  }

  @Test
  public void tesGaussJordan() {
    double[][] tc1 = {{2, 3, -1, 5}, {4, 4, -3, 3}, {-2, 3, -1, 1}};
    double[][] tc2 = {{1, 2, 1, 2}, {3, 6, 0, 9}, {2, 8, 4, 6}};
    double[][] tc3 = {{6, 3}};

    double[][] res1 = {{1, 0, 0, 1}, {0, 1, 0, 2}, {0, 0, 1, 3}};
    double[][] res2 = {{1, 0, 0, 1}, {0, 1, 0, 1}, {0, 0, 1, -1}};
    double[][] res3 = {{1, 0.5}};

    Matriks m1 = matriksBuilderHelper(tc1);
    Matriks m2 = matriksBuilderHelper(tc2);
    Matriks m3 = matriksBuilderHelper(tc3);

    Matriks mres1 = matriksBuilderHelper(res1);
    Matriks mres2 = matriksBuilderHelper(res2);
    Matriks mres3 = matriksBuilderHelper(res3);

    m1.eliminasiGaussJordan();
    m2.eliminasiGaussJordan();
    m3.eliminasiGaussJordan();

    testKesamaanMatriks(mres1, m1);
    testKesamaanMatriks(mres2, m2);
    testKesamaanMatriks(mres3, m3);
  }

  @Test
  public void testGaussJordanTakPas() {
    double[][] tc1 = {{2, 1, 1, 7}, {0, 2, 3, 13}};
    double[][] tc2 = {{1, 1, 3}, {2, 5, 12}, {3, 2, 7}};
    double[][] tc3 = {{1, 1, 3}, {2, 5, 12}, {3, 2, 8}};

    double[][] res1 = {{1, 0, -0.25, 0.25}, {0, 1, 1.5, 6.5}};
    double[][] res2 = {{1, 0, 1}, {0, 1, 2}, {0, 0, 0}};
    double[][] res3 = {{1, 0, 2}, {0, 1, 1}, {0, 0, 3}};

    Matriks m1 = matriksBuilderHelper(tc1);
    Matriks m2 = matriksBuilderHelper(tc2);
    Matriks m3 = matriksBuilderHelper(tc3);

    Matriks mres1 = matriksBuilderHelper(res1);
    Matriks mres2 = matriksBuilderHelper(res2);
    Matriks mres3 = matriksBuilderHelper(res3);

    m1.eliminasiGaussJordan();
    m2.eliminasiGaussJordan();
    m3.eliminasiGaussJordan();

    testKesamaanMatriks(mres1, m1);
    testKesamaanMatriks(mres2, m2);
//    testKesamaanMatriks(mres3, m3);
  }

  @Test
  public void TestCrammer() throws Exception {
    double[][] tc = {{2,5,1,10},{1,3,0,4},{1,0,2,7}};
    double[][] res = {{1,0,0,1},{0,1,0,1},{0,0,1,3}};

    Matriks m1 = matriksBuilderHelper(tc);
    Matriks mres1 = matriksBuilderHelper(res);

    testKesamaanMatriks(mres1, m1.metodeCrammer());
  }
}
