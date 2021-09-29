package tubes.algeo.lib;
import tubes.algeo.lib.type.Node;
import tubes.algeo.lib.type.Matriks;
import tubes.algeo.lib.util.terminalColor;

import java.io.*;
import java.util.Scanner;

public class IO {
  public static Scanner readFile(String path) throws FileNotFoundException{
    File f = new File(path);
    return new Scanner(f);
  }

  public static Matriks readFileMatriks(String path) throws FileNotFoundException {
    Scanner stream = readFile(path);
    return getMatriks(stream, false);
  }

  public static Node[] readFileNodes(String path) throws FileNotFoundException {
    Scanner stream = readFile(path);
    return getNodes(stream, false, false);
  }

  public static Node[] readFileNodes1(String path) throws FileNotFoundException{
    Scanner stream = readFile(path);
    return getNodes(stream, false, true);
  }

  static FileWriter openWriteMode(String path) throws Exception {
    File f = new File(path);
    FileWriter writer;

    if(!f.exists()){
      if(!f.createNewFile()){
        throw new Exception(terminalColor.TEXT_RED+"Gagal membuat file"+terminalColor.TEXT_RESET);
      }else{
        writer = new FileWriter(path);
      }
    }else{
        writer = new FileWriter(path);
    }

    return writer;
  }

  public static void writeTextFile(String path, String text) throws Exception{
    FileWriter w = IO.openWriteMode(path);
    w.write(text);
    w.close();
  }
  public static Matriks readMatrix(){
    Scanner stream = new Scanner(System.in);
    return getMatriks(stream, true);
  }

  public static Node[] readNodes(){
    Scanner stream = new Scanner(System.in);
    return getNodes(stream, true, false);
  }

  public static Node[] readNodes1(){
    Scanner stream = new Scanner(System.in);
    return getNodes(stream, true, true);
  }

  private static Node[] getNodes(Scanner stream, boolean showHint, boolean oneVariable) {
    int nx;
    int nNodes;

    if(!oneVariable){
      if(showHint){
        System.out.print("Masukkan jumlah variabel : ");
      }
      nx = stream.nextInt();
    }else{
      nx = 1;
    }

    if(showHint){
      System.out.print("Masukkan jumlah data : ");
    }
    nNodes = stream.nextInt();

    Node[] result = new Node[nNodes];

    for(int i = 0; i < nNodes; i++){
      if(showHint){
        System.out.println("\n====");
        System.out.print(terminalColor.TEXT_BLUE + "Data ke-");
        System.out.println(i+1);
      }

      double[] xdata = new double[nx];

      if(showHint){
        System.out.println(terminalColor.TEXT_RESET);
      }

      for(int j = 0; j < nx; j++){
        if(showHint){
          if(oneVariable){
            System.out.print("Masukkan parameter [x] : ");
          }else{
            System.out.printf("Masukkan parameter ke-%d [x_%d] : ", j+1, j);
          }
        }
        xdata[j] = stream.nextDouble();
      }

      if(showHint){
        System.out.print("Masukkan hasil [y] : ");
      }

      double y = stream.nextDouble();

      result[i] = new Node(xdata, y);
    }

    return result;
  }

  private static Matriks getMatriks(Scanner stream, boolean showHints) {
    int nrows;
    int ncolumns;

    if(showHints){
      System.out.print("Masukkan jumlah baris [nrows] : ");
    }
    nrows = stream.nextInt();

    if(showHints){
      System.out.print("Masukkan jumlah kolom [ncols] : ");
    }
    ncolumns = stream.nextInt();

    Matriks result = new Matriks(nrows, ncolumns);

    if(showHints){
      System.out.println(terminalColor.TEXT_YELLOW+"\n*** Mengambil data matriks ***"+terminalColor.TEXT_RESET);
      System.out.printf(terminalColor.TEXT_CYAN+"Silahkan masukan matriks anda [%d x %d] :\n"+ terminalColor.TEXT_RESET, nrows, ncolumns);
    }

    for(int i = 0; i < nrows; i++){
      for(int j = 0; j < ncolumns; j++){
        result.setElmt(i,j, stream.nextDouble());
      }
    }

    return result;
  }
}
