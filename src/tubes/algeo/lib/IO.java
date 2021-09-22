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
    return getMatriks(stream, false);
  }

  public static Node[] readFileNodes(String path) throws FileNotFoundException {
    int nx, nNodes;

    Scanner stream = readFile(path);
    return getNodes(stream, false);
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
    return getMatriks(stream, true);
  }

  public static Node[] readNodes(){
    int nx, nNodes;

    Scanner stream = new Scanner(System.in);
    return getNodes(stream, true);
  }

  private static Node[] getNodes(Scanner stream, boolean showHint) {
    int nx;
    int nNodes;

    if(showHint){
      System.out.print("Masukkan jumlah variabel : ");
    }
    nx = stream.nextInt();

    if(showHint){
      System.out.print("Masukkan jumlah data : ");
    }
    nNodes = stream.nextInt();

    Node[] result = new Node[nNodes];

    for(int i = 0; i < nNodes; i++){
      if(showHint){
        System.out.println("\n====");
        System.out.print("Data ke-");
        System.out.println(i+1);
        System.out.println();
        System.out.print("Masukkan hasil [y] : ");
      }

      double y = stream.nextDouble();
      double[] xdata = new double[nx];

      if(showHint){
        System.out.println();
      }

      for(int j = 0; j < nx; j++){
        if(showHint){
          System.out.printf("Masukkan parameter ke-%d [x%d] : ", j, j);
        }
        xdata[j] = stream.nextDouble();
      }

      result[i] = new Node(xdata, y);
    }

    return result;
  }

  private static Matriks getMatriks(Scanner stream, boolean showHints) {
    int nrows;
    int ncolumns;

    if(showHints){
      System.out.println("Masukkan jumlah baris [nrows] : ");
    }
    nrows = stream.nextInt();

    if(showHints){
      System.out.println("Masukkan jumlah kolom [ncols] : ");
    }
    ncolumns = stream.nextInt();

    Matriks result = new Matriks(nrows, ncolumns);

    if(showHints){
      System.out.println("\n*** Mengambil data matriks ***");
      System.out.printf("Silahkan masukan matriks anda [%d x %d] :", nrows, ncolumns);
    }

    for(int i = 0; i < nrows; i++){
      for(int j = 0; j < ncolumns; j++){
        result.setElmt(i,j, stream.nextDouble());
      }
    }

    return result;
  }
}
