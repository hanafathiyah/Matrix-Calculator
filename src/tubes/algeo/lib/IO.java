package tubes.algeo.lib;
import tubes.algeo.lib.type.Node;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.type.Polynomial;
import tubes.algeo.lib.type.SPLResult;

import java.io.*;
import java.util.Scanner;

public class IO {
  public static Scanner readFile(String path) throws FileNotFoundException{
    File f = new File(path);
    return new Scanner(f);
  }

  public static String readFileText(String path) throws FileNotFoundException{
    Scanner stream = IO.readFile(path);
    String result = "";

    while(stream.hasNextLine()){
      result = result.concat(stream.nextLine());
    }

    return result;
  }

  public static Matriks readFileMatriks(String path) throws FileNotFoundException {
    Scanner stream = readFile(path);
    return getMatriks(stream);
  }

  public static Node[] readFileNodes(String path) throws FileNotFoundException {
    int nx, nNodes;

    Scanner stream = readFile(path);
    return getNodes(stream);
  }

  static FileWriter openWriteMode(String path) throws Exception {
    File f = new File(path);
    FileWriter writer;

    if(!f.exists()){
      if(!f.createNewFile()){
        throw new Exception("Gagal membuat file");
      }else{
        writer = new FileWriter(path);
      }
    }else{
        writer = new FileWriter(path);
    }

    return writer;
  }

  public static void writeFileSPLResult(String path, SPLResult result) throws Exception {
    FileWriter w = IO.openWriteMode(path);
    String strResult = result.getStrResult();
    w.write(strResult);
    w.close();
  }

  public static void writeFilePolynomial(String path, Polynomial result) throws Exception {
    FileWriter w = IO.openWriteMode(path);
    String strResult = result.getPolynomialStr();
    w.write(strResult);
    w.close();
  }

  public static Matriks readMatrix(){
    Scanner stream = new Scanner(System.in);
    return getMatriks(stream);
  }

  public static Node[] readNodes(){
    int nx, nNodes;

    Scanner stream = new Scanner(System.in);
    return getNodes(stream);
  }

  private static Node[] getNodes(Scanner stream) {
    int nx;
    int nNodes;
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

  private static Matriks getMatriks(Scanner stream) {
    int nrows;
    int ncolumns;
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
}
