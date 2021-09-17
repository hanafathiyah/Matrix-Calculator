package tubes.algeo;

import org.junit.Assert;
import org.junit.Test;

public class Test01 {
  public static int tambah(int a, int b){
    return a+b;
  }

  @Test
   public void shouldAnswerWithTrue()
    {
      Assert.assertEquals(5+6, Test01.tambah(5,6));
    }
}
