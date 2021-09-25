package tubes.algeo.regresi;

import org.junit.Test;
import tubes.algeo.SPL.Helper;
import tubes.algeo.lib.Regresi;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.Node;

public class TestAugmentedBuilder {
  @Test
  public void tesAugmented01(){
    Node[] data = new Node[5];
    double[][] x = {{1,3},{4,2},{2,2},{3,9},{9,10}};
    double[] y = {5,7,6,10,11};

    for(int i = 0; i < 5; i++){
      data[i] = new Node(x[i],y[i]);
    }

    double[][] ans = {{5,19,26,39},{19,111,132,174},{26,132,198,241}};
    Matriks mans = Helper.matriksBuilderHelper(ans);
    Matriks mactual = Regresi.augmentedBuilder(data);

    Helper.testKesamaanMatriks(mans, mactual);
  }

  @Test
  public void tesAugmented02(){
    Node[] data = new Node[5];
    double[][] x = {{1,3,5},{2,6,5},{3,3,2},{1,3,5},{2,1,9}};
    double[] y = {7,9,1,4,6};

    for(int i = 0; i < 5; i++){
      data[i] = new Node(x[i],y[i]);
    }

    double[][] ans = {{5,9,16,26,27},{9,19,29,44,44},{16,29,64,75,96},{26,44,75,160,156}};

    Matriks mans = Helper.matriksBuilderHelper(ans);
    Matriks mactual = Regresi.augmentedBuilder(data);

    Helper.testKesamaanMatriks(mans, mactual);
  }

  @Test
  public void tesAugmented03(){
    Node[] data = new Node[5];
    double[][] x = {{1},{3},{7},{10},{4}};
    double[] y = {6,5,2,15,6};

    for(int i = 0; i < 5; i++){
      data[i] = new Node(x[i],y[i]);
    }

    double[][] ans = {{5,25,34},{25,175,209}};

    Matriks mans = Helper.matriksBuilderHelper(ans);
    Matriks mactual = Regresi.augmentedBuilder(data);

    Helper.testKesamaanMatriks(mans, mactual);
  }

  @Test
  public void tesAugmented04(){
    Node[] data = new Node[6];
    double[][] x = {{0.1},{0.4},{0.5},{0.7},{0.7},{0.9}};
    double[] y = {0.61, 0.92, 0.99, 1.52, 1.47, 2.03};

    for(int i = 0; i < 6; i++){
      data[i] = new Node(x[i],y[i]);
    }

    double[][] ans = {{6,3.3,7.54},{3.3,2.21,4.844}};

    Matriks mans = Helper.matriksBuilderHelper(ans);
    Matriks mactual = Regresi.augmentedBuilder(data);

    Helper.testKesamaanMatriks(mans, mactual);
  }
}
