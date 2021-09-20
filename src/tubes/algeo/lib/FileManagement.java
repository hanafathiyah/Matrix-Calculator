package tubes.algeo.lib;
import tubes.algeo.lib.type.Node;
import tubes.algeo.lib.type.Matriks;

import java.util.Scanner;
import java.io.FileNotFoundException;
import java.io.File;

public class FileManagement {
  public static Scanner readFile(String path) throws FileNotFoundException{
    File f = new File(path);
    return new Scanner(f);
  }

  public static String readFileText(String path) throws FileNotFoundException{
    Scanner stream = FileManagement.readFile(path);
    String result = "";

    while(stream.hasNextLine()){
      result = result.concat(stream.nextLine());
    }

    return result;
  }

  public static Matriks readFileMatriks(String path) throws FileNotFoundException {
    // Baca ukuran
    int nrows, ncolumns;

    Scanner stream = readFile(path);
    nrows = stream.nextInt();
    ncolumns = stream.nextInt();

    Matriks result = new Matriks(nrows, ncolumns);

    for(int i = 0; i < nrows; i++){
      for(int j = 0; j < ncolumns; j++){
        result.setElmt(i,j, stream.nextDouble());
      }
    }

    return result;
  }

  public static Node[] readFileNodes(String path) throws FileNotFoundException {
    int nx, nNodes;

    Scanner stream = readFile(path);
    nx = stream.nextInt();
    nNodes = stream.nextInt();

    Node[] result = new Node[nNodes];

    for(int i = 0; i < nNodes; i++){
      double y = stream.nextDouble();
      double[] xdata = new double[nx];

      for(int j = 0; j < nx; j++){
        xdata[j] = stream.nextDouble();
      }

      result[i] = new Node(xdata, y);
    }

    return result;
  }
}
