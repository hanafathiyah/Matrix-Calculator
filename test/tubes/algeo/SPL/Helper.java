package tubes.algeo.SPL;

import org.junit.Assert;
import tubes.algeo.lib.type.Matriks;

public class Helper {
  static Matriks matriksBuilderHelper(double[][] payload) {
    Matriks result = new Matriks(payload.length, payload[0].length);

    for (int i = 0; i < result.getNRows(); i++) {
      for (int j = 0; j < result.getNCols(); j++) {
        result.setElmt(i, j, payload[i][j]);
      }
    }

    return result;
  }

  static void testKesamaanMatriks(Matriks m1, Matriks m2) {
    Assert.assertEquals(m1.getNCols(), m2.getNCols());
    Assert.assertEquals(m1.getNRows(), m2.getNRows());

    for (int i = 0; i < m1.getNRows(); i++) {
      Assert.assertArrayEquals(m1.getMatrix()[i], m2.getMatrix()[i], 1e-9);
    }
  }
}
