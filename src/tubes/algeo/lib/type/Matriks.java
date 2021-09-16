package tubes.algeo.lib.type;

public class Matriks {
  private int nRows, nCols;

  public Matriks(int nRows, int nCols){
    this.nRows = nRows;
    this.nCols = nCols;
  }

  // Selektor
  public int getnRows() {
    return nRows;
  }

  public int getnCols() {
    return nCols;
  }

  public boolean isSquare(){
    return this.nRows == this.nCols;
  }

  public void setElmt(int row, int col, double value){

  }

  public void getElmt(int row, int col){
    
  }

  // Operasi
  public Matriks transpose(){
    // Buat Transposenya
    return new Matriks(1,2);
  }

  // Operasi OBE
  public void plusMinusRow(int rowTarget, int row, double factor){
    // OBE buat nambahin atau ngurangin baris
  }

  public void scaleRow(int rowTarget, double factor){

  }

  public Matriks kofaktor(){
    return new Matriks(1,2);
  }

  // Operasi matriks biasa
  public Matriks plus(Matriks m){
    // Penjumlahan matriks
    return new Matriks(0,0);
  }

  public Matriks minus(Matriks m){
    // Penjumlahan matriks
    return new Matriks(0,0);
  }

  public Matriks product(Matriks m){
      return new Matriks(0,0);
  }

  public Matriks copy() {
    return new Matriks(0,0);
  }
}
